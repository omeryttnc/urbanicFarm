package stepDefinitions.uiStepDef.deliveryAndPickupSettings;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtilities;

import java.util.List;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class US_057 {
    Select select;
    @When("user clicks on user name")
    public void userClicksOnUserName() {
        commonPage.getSettings().user.click();
    }

    @And("user clicks on delivery and pickup settings")
    public void userClicksOnDeliveryAndPickupSettings() {
        commonPage.getSettings().delivery.click();
    }

    @And("user clicks on seller flexible")
    public void userClicksOnSellerFlexible() {
        commonPage.getSettings().seller_flexible.click();
    }

    @Then("user verifies web elements with following ids are visible")
    public void userVerifiesWebElementsWithFollowingIdsAreVisible(DataTable dataTable) {
        List<String> ids = dataTable.row(0);

        for (int i = 0; i < ids.size(); i++) {
            WebElement element = driver.findElement(By.cssSelector("#" + ids.get(i)));
            Assert.assertTrue(element.isDisplayed());
            System.out.println(element.getText());
        }

    }

    @And("user verifies web elements with following ids are clickable")
    public void userVerifiesWebElementsWithFollowingIdsAreClickable(DataTable dataTable) {
        List<String> ids = dataTable.column(0);

        for (int i = 0; i < ids.size(); i++) {
            WebElement element = driver.findElement(By.cssSelector("#" + ids.get(i)));
            Assert.assertTrue(element.isEnabled());
            System.out.println(element.getText());

        }
    }

    @When("user enters number to free delivery range and asserts border color and alerts")
    public void userEntersNumberToFreeDeliveryRangeAndAssertsBorderColorAndAlerts(DataTable dataTable) {
        BrowserUtilities.cleanTextFromWebelemnt(commonPage.getSettings().freeFlexibleDeliveryRange);
        commonPage.getSettings().freeFlexibleDeliveryRange.clear();
        BrowserUtilities.cleanTextFromWebelemnt(commonPage.getSettings().minFreeFlexibleDeliveryOrder);
        commonPage.getSettings().minFreeFlexibleDeliveryOrder.clear();

        List<String> data = dataTable.column(0);
        List<String> rgba = dataTable.column(1);
        List<String> alerts = dataTable.column(2);
        List<String> data2 = dataTable.column(2);
        Actions actions = new Actions(driver);

        for (int i = 0; i < data.size(); i++) {
            BrowserUtilities.cleanTextFromWebelemnt(commonPage.getSettings().minFreeFlexibleDeliveryOrder);
//            BrowserUtilities.cleanTextFromWebelemnt(commonPage.getSettings().minFreeFlexibleDeliveryOrder);
            commonPage.getSettings().minFreeFlexibleDeliveryOrder.clear();
            actions.sendKeys(commonPage.getSettings().minFreeFlexibleDeliveryOrder, Keys.BACK_SPACE,Keys.BACK_SPACE).perform();
            BrowserUtilities.scrollToElement(commonPage.getSettings().freeFlexibleDeliveryRange);
            commonPage.getSettings().freeFlexibleDeliveryRange.sendKeys(data.get(i));
            commonPage.getSettings().minFreeFlexibleDeliveryOrder.sendKeys(data2.get(i));
//            BrowserUtilities.assertBorderColor(rgba.get(i), commonPage.getSettings().freeFlexibleDeliveryRange);
            BrowserUtilities.wait(2);
            BrowserUtilities.wait(2);
            BrowserUtilities.scrollAndClickWithJS(commonPage.getSettings().update);
            if (alerts.get(i).equals("Please fill out this field.")) {
                Assert.assertEquals(alerts.get(i), commonPage.getSettings().minFreeFlexibleDeliveryOrder.getDomProperty("validationMessage"));
            } else
                Assert.assertEquals(alerts.get(i), commonPage.getSettings().freeFlexibleDeliveryRange.getDomProperty("validationMessage"));
            BrowserUtilities.wait(2);
            BrowserUtilities.cleanTextFromWebelemnt(commonPage.getSettings().minFreeFlexibleDeliveryOrder);
            BrowserUtilities.cleanTextFromWebelemnt(commonPage.getSettings().freeFlexibleDeliveryRange);
            System.out.println(i);
        }
    }

    @When("user selects {string} for orderBegin")
    public void userSelectsForOrderBegin(String day) {
        select = new Select(commonPage.getSettings().deliveryBeginDay);
        select.selectByValue(day);
    }

    @And("user enters input to order begin {string}")
    public void userEntersInputToOrderBegin(String time) {
        commonPage.getSettings().deliveryBeginTime.sendKeys(time);
    }

    @When("user selects {string} for orderEnd")
    public void userSelectsForOrderEnd(String day) {
        select = new Select(commonPage.getSettings().deliveryEndDay);
        select.selectByValue(day);
    }

    @And("user enters input to order end {string}")
    public void userEntersInputToOrderEnd(String time) {
        commonPage.getSettings().deliveryEndTime.sendKeys(time);

    }

    @When("user selects {string} for deliverBy")
    public void userSelectsForDeliverBy(String day) {
        select = new Select(commonPage.getSettings().orderByDay);
        select.selectByValue(day);
    }

    @And("user enters input to deliver by {string}")
    public void userEntersInputToDeliverBy(String time) {
        commonPage.getSettings().orderByTime.sendKeys(time);

    }

    @And("user clicks on update button")
    public void userClicksOnUpdateButton() {
        BrowserUtilities.scrollAndClickWithJS(commonPage.getSettings().update);
    }

    @Then("user verifies the toast message is {string}")
    public void userVerifiesTheToastMessageIs(String message) {
        BrowserUtilities.toastMessageAssertion(message);
    }
}
