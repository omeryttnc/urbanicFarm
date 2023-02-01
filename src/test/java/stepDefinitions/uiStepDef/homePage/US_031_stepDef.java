package stepDefinitions.uiStepDef.homePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;

import java.util.List;

import static stepDefinitions.Hooks.*;

public class US_031_stepDef extends CommonPage {

    String red = "rgba(245, 110, 105, 1)";
    String black = "rgba(72, 72, 72, 1)";


    @Given("user goes to website")
    public void user_goes_to_website() {
        driver.get("https://test.urbanicfarm.com/");
    }

    @Given("user clicks on the register button on the navbar")
    public void user_clicks_on_the_register_button_on_the_navbar() {

        // . -> class
        // # -> id
        WebElement registerButton = getHomePage().registerButton_navbar;// ctrl alt  v
        registerButton.click();

    }

    @When("user send a to first name on the registration form")
    public void user_send_a_to_first_name_on_the_registration_form() {
        WebElement firstName = getRegisterPage().firstName_registerForm;

        firstName.sendKeys("a");


    }

    @Then("firstname text suppose to be red")
    public void firstname_text_suppose_to_be_red() {
        WebElement firstName = getRegisterPage().firstName_registerForm;

        String actualTextColor = firstName.getCssValue("color");
        Assert.assertEquals(red, actualTextColor);

        //2. yol
        assertTextColor(red, firstName);
    }

    @When("user click on enter")
    public void user_click_on_enter() {
        Actions actions1 = new Actions(driver);

        actions1.sendKeys(Keys.ENTER).perform();


    }

    @Then("user suppose to see {string} text")
    public void user_suppose_to_see_text(String expectedValidationMessage) {
        WebElement firstName = commonPage.getRegisterPage().firstName_registerForm;

        String actualValidationMessage = firstName.getAttribute("validationMessage");
        Assert.assertEquals(
                "firstname a girdigimde bana yanlis bir mesaj getirdi",
                expectedValidationMessage,
                actualValidationMessage);

    }

    @Then("firstname text suppose to be black")
    public void firstnameTextSupposeToBeBlack() {
        //1. yol
        Assert.assertEquals(black, commonPage.getRegisterPage().firstName_registerForm.getCssValue("color"));
        // 2. yol
        assertTextColor(black, commonPage.getRegisterPage().firstName_registerForm);
    }

    @When("user send to last name on the registration form")
    public void userSendToLastNameOnTheRegistrationForm(DataTable dataTable) {
        List<String> text = dataTable.column(0);
        List<String> color = dataTable.column(1);


        for (int i = 0; i < text.size(); i++) {
            commonPage.getRegisterPage().lastName_registerForm.sendKeys(text.get(i));
            assertTextColor(color.get(i), commonPage.getRegisterPage().lastName_registerForm);
            cleanTextFromWebelemnt(commonPage.getRegisterPage().lastName_registerForm);
        }


    }

    /**
     * methood used to clean text
     * @param webElement webelemnt will be cleaned
     * @since 01.02.2023
     * @author omeryttnc
     */
    public void cleanTextFromWebelemnt(WebElement webElement) {
// omer -> 4 -> 4 defa backspace
        // a -> 1
        int valueLength = webElement.getAttribute("value").length();

        for (int i = 0; i < valueLength; i++) {
            actions.sendKeys(Keys.BACK_SPACE).perform();

        }

    }


    /**
     * method used to assert text color of web element
     *
     * @param rgba       webelementin rgba degeri
     * @param webElement bakilcak weblement
     * @author omeryttnc
     * @since 01.02.2023
     */
    public void assertTextColor(String rgba, WebElement webElement) {
        Assert.assertEquals(rgba, webElement.getCssValue("color"));
    }


}
