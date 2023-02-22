package stepDefinitions.uiStepDef.welcomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.DatabaseUtilities;

import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.Hooks.*;

public class US_68_stepDef {

    List<String> addedProductNames = new ArrayList<>();
    List<Double> addedProductPrice = new ArrayList<>();

    int count = 0;
    double toplam = 0;

    @Given("delete used promocode")
    public void delete_used_promocode() {

        DatabaseUtilities.deleteUsedPromoCode();

    }

    @Given("User login as Buyer")
    public void user_login_as_buyer() {

        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("buyerToken"), "home");

        BrowserUtilities.wait(3);

    }

    @Given("Cart i bosalt")
    public void cart_i_bosalt() {
        if (!commonPage.getHomePage().go_to_cart_button.getText().equals("0")) {
            commonPage.getHomePage().go_to_cart_button.click();
            BrowserUtilities.wait(2);


            while (!commonPage.getHomePage().go_to_cart_button.getText().equals("0")) {

                commonPage.getCartPage().removeProductFromCart.get(0).click();
                BrowserUtilities.wait(2);
                actions.sendKeys(Keys.TAB, Keys.ENTER).perform();
                BrowserUtilities.wait(2);


            }

            driver.navigate().back();
            BrowserUtilities.wait(3);

            // TODO: 22/02/2023 burayi backend seklinde degistir

        }

    }

    @Given("Add some product to cart")
    public void add_some_product_to_cart() {

        for (int i = 0; i < 5; i++) {
            commonPage.getHomePage().productAddToCart.get(i).click();

            BrowserUtilities.waitForClickable(commonPage.getAccountPage().toastMessage);

            if (commonPage.getAccountPage().toastMessage.getText().contains("added to your basket")) {

                toplam = toplam + Double.parseDouble(commonPage.getHomePage().productPrices.get(i).getText().substring(1));
                addedProductPrice.add(Double.valueOf(commonPage.getHomePage().productPrices.get(i).getText().substring(1)));
                addedProductNames.add(commonPage.getHomePage().getProductNames().get(i).getText());
                count++;
            }
            commonPage.getAccountPage().toastMessage.click();
            BrowserUtilities.wait(1);

        }

    }

    @Given("User goes to cart page")
    public void user_goes_to_cart_page() {

        int expectedCartNumber = Integer.parseInt(commonPage.getHomePage().go_to_cart_button.getText());
        Assert.assertEquals(expectedCartNumber, count);
        commonPage.getHomePage().go_to_cart_button.click();
        BrowserUtilities.wait(3);

        double subtotalPromocodeOncesi = Double.parseDouble(commonPage.getCartPage().cartTotal_subtotal.getText().substring(1));

        Assert.assertEquals(toplam, subtotalPromocodeOncesi,0.0);

    }

    @Then("Enter promo code menu should be functional")
    public void enter_promo_code_menu_should_be_functional() {
        commonPage.getCartPage().enterPromoCode_button.click();
        BrowserUtilities.wait(1);
        Assert.assertTrue(commonPage.getCartPage().enterPromoCode_apply.isDisplayed());
    }

    @When("Code enter in the Enter {string} menu")
    public void code_enter_in_the_enter_menu(String promocode) {
        commonPage.getCartPage().enterPromoCode_text.sendKeys(promocode);
    }

    @When("Click the Apply button.")
    public void click_the_apply_button() {
        commonPage.getCartPage().enterPromoCode_apply.click();

    }

    @Then("assert toast message {string} if it is {string}")
    public void assert_toast_message_if_it_is(String expectedToastMessage, String valid) {

        if (!Boolean.parseBoolean(valid)) {
            BrowserUtilities.waitForClickable(commonPage.getAccountPage().toastMessage);
            String actualToastMesaj = commonPage.getAccountPage().toastMessage.getText();
            Assert.assertEquals(expectedToastMessage, actualToastMesaj);

        }

    }

    @Then("After the code is entered, the code rate should give results has {string} and amount is {int} .")
    public void after_the_code_is_entered_the_code_rate_should_give_results_has_and_amount_is(String type, Integer amount) {

        double deliveryCost = Double.parseDouble(commonPage.getCartPage().cartTotal_deliveryCost.getText().substring(1));
        double subtotal = Double.parseDouble(commonPage.getCartPage().cartTotal_subtotal.getText().substring(1));
        double total = Double.parseDouble(commonPage.getCartPage().cartTotal_total.getText().substring(1));

        if (type.equals("money")) {
            Assert.assertEquals(total, subtotal + deliveryCost,0.0);
            Assert.assertEquals(toplam-amount,subtotal,0.0);
        }else {
            Assert.assertEquals(total, subtotal + deliveryCost,0.0);
            Assert.assertEquals(toplam*(1-amount*0.01),subtotal,0.0);
        }

    }

    @Then("proceed from the Proceed to checkout button and complete the payment.")
    public void proceed_from_the_proceed_to_checkout_button_and_complete_the_payment() {

    }

}
