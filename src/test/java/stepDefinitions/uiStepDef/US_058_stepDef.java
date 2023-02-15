package stepDefinitions.uiStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.DatabaseUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class US_058_stepDef {

    Random random = new Random();

    int randomHub;

    String addedProduct = "";


    @Given("User login as Seller")
    public void userLoginAsSeller() {

        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("sellerToken"), "account/hub");
    }


    @Test
    public void name() {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String key1 = "a27c6fac85ae1295535e42c9d3e3f305";
        String key2 = "e3e1601fca9c429344c15527cd542142";

        String url = "https://test.urbanicfarm.com/";

        String value2 = ConfigurationReader.getProperty("sellerToken");
        String value1 = ConfigurationReader.getProperty("sellerToken").split("\\.")[1];
        driver.get(url);
        localStorage.setItem(key1, value1);
        localStorage.setItem(key2, value2);

        driver.get(url + "account/hub");

        BrowserUtilities.wait(20);

    }

    @And("User goes to Your products-services")
    public void userGoesToYourProductsServices() {
    }

    @And("User click on random Hubs")
    public void userClickOnRandomHubs() {
        randomHub = random.nextInt(commonPage.getProductPage().allhubs.size());
        commonPage.getProductPage().allhubs.get(randomHub).click();
        BrowserUtilities.wait(2);

    }

    public static String getRandomIndexFromList(List<String> getString) {
        Random random1 = new Random();

        int randomIndex = random1.nextInt(getString.size());

        return getString.get(randomIndex);

    }

    @When("Product Name, Price, Stock, Unit information added products should be displayed.")
    public void productNamePriceStockUnitInformationAddedProductsShouldBeDisplayed() {

        Assert.assertTrue(commonPage.getProductPage().addNewProduct_Name.isDisplayed());
        Assert.assertTrue(commonPage.getProductPage().addNewProduct_Price.isDisplayed());
        Assert.assertTrue(commonPage.getProductPage().addNewProduct_Stock.isDisplayed());
        Assert.assertTrue(commonPage.getProductPage().addNewProduct_Unit.isDisplayed());


        // structure  programming
        List<String> list = new ArrayList<>();

        for (int i = 0; i < commonPage.getProductPage().allAddedProducts.size(); i++) {

            list.add(commonPage.getProductPage().allAddedProducts.get(i).getText());

        }

        // functional programming

        List<String> addProductNames = commonPage.getProductPage().allAddedProducts.stream()
                .map(t -> t.getText())
                .collect(Collectors.toList());


        List<String> allProductNames = commonPage.getProductPage().allProductsNames.stream()
                .map(t -> t.getAttribute("value"))
                .collect(Collectors.toList());

        allProductNames.removeAll(addProductNames);

        addedProduct = getRandomIndexFromList(allProductNames);
        BrowserUtilities.wait(5);
        commonPage.getProductPage().addNewProduct_Name.sendKeys(addedProduct);


        commonPage.getProductPage().addNewProduct_Price.sendKeys("15");
        commonPage.getProductPage().addNewProduct_Stock.sendKeys("15");
        Select select = new Select(commonPage.getProductPage().addNewProduct_Unit);

        select.selectByIndex(5);


        BrowserUtilities.scrollAndClickWithJS(commonPage.getProductPage().addNewProduct_Submit);

    }

    @Then("One of the Approved, In-Review, Rejected options for each product should be visible on the file.")
    public void oneOfTheApprovedInReviewRejectedOptionsForEachProductShouldBeVisibleOnTheFile() {
BrowserUtilities.wait(5);

        for (int i = 0; i < commonPage.getProductPage().allProductsStatus.size(); i++) {

            String actualStatus = commonPage.getProductPage().allProductsStatus.get(i).getText();


            Assert.assertTrue(
                    actualStatus.equals("APPROVED") ||
                            actualStatus.equals("IN_REVIEW") ||
                            actualStatus.equals("REJECTED")
            );


        }
    }

    @Then("In-Review should be visible on the added product.")
    public void inReviewShouldBeVisibleOnTheAddedProduct() {

        String actualProductStatus = BrowserUtilities.getStatusOfProduct(addedProduct);
        String expectedProductStatus = "IN_REVIEW";

        Assert.assertEquals(expectedProductStatus, actualProductStatus);


    }

    @Then("User approve last added product from database")
    public void userApproveLastAddedProductFromDatabase() {
        DatabaseUtilities.approveLastProduct();
    }

    @Then("Approved should be visible on the added product.")
    public void approvedShouldBeVisibleOnTheAddedProduct() {
        driver.navigate().back();
        BrowserUtilities.wait(2);
        commonPage.getProductPage().allhubs.get(randomHub).click();
        BrowserUtilities.wait(2);

        String actualProductStatus = BrowserUtilities.getStatusOfProduct(addedProduct);
        String expectedProductStatus = "APPROVED";

        Assert.assertEquals(expectedProductStatus, actualProductStatus);
    }

    @Then("It should be possible to click on the product name on the file related to the previously added product.")
    public void itShouldBePossibleToClickOnTheProductNameOnTheFileRelatedToThePreviouslyAddedProduct() {

        commonPage.getProductPage().clickAddedProduct(addedProduct);
    }

    @When("The product name is clicked, the update-delete page is displayed.")
    public void theProductNameIsClickedTheUpdateDeletePageIsDisplayed() {

        Assert.assertTrue(commonPage.getProductPage().update.isDisplayed());
        Assert.assertTrue(commonPage.getProductPage().delete.isDisplayed());
    }

    @When("Product information should be able to be changed on this page")
    public void productInformationShouldBeAbleToBeChangedOnThisPage() {
    }

    @When("the update option is clicked after the necessary corrections, \\(.....) has been succesfully updated alert should be displayed.")
    public void theUpdateOptionIsClickedAfterTheNecessaryCorrectionsHasBeenSuccesfullyUpdatedAlertShouldBeDisplayed() {
        commonPage.getProductPage().update.click();


        BrowserUtilities.toastMessageAssertion(addedProduct + " has been successfully updated");

    }


    @When("the Delete button is clicked, yes- no options should appear.")
    public void theDeleteButtonIsClickedYesNoOptionsShouldAppear() {
        commonPage.getProductPage().delete.click();
        BrowserUtilities.wait(6);
        // TODO: 15/02/2023 buranin uzerinde durmak lazim 
    }

    @Then("Yes-No options should appear.")
    public void yesNoOptionsShouldAppear() {
        Assert.assertTrue(commonPage.getProductPage().yes.isDisplayed());
        Assert.assertTrue(commonPage.getProductPage().no.isDisplayed());

    }

    @When("One of the Yes-No options should be selected.")
    public void oneOfTheYesNoOptionsShouldBeSelected() {
    }

    @Then("No option should cancel the operation")
    public void noOptionShouldCancelTheOperation() {
    }

    @When("Yes option is selected, the product should be removed from the page.")
    public void yesOptionIsSelectedTheProductShouldBeRemovedFromThePage() {
        commonPage.getProductPage().yes.click();
        BrowserUtilities.toastMessageAssertion(addedProduct + " has been successfully deleted");

        BrowserUtilities.wait(3);

        Assert.assertTrue(
                commonPage.getProductPage().allAddedProducts.stream()
                        .map(t -> t.getText())
                        .noneMatch(t -> t.equals(addedProduct))
        );

    }
}
