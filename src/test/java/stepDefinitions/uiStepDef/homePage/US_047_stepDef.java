package stepDefinitions.uiStepDef.homePage;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.Hooks.commonPage;

public class US_047_stepDef {
    @Given("user login as Buyer")
    public void userLoginAsBuyer() {
        BrowserUtilities.loginMethod(

                ConfigurationReader.getProperty("buyerEmail"),
                ConfigurationReader.getProperty("buyerPassword")

        );

        BrowserUtilities.wait(5);
    }

    @Given("Account must be clickable")
    public void account_must_be_clickable() {
        BrowserUtilities.waitForClickable(commonPage.getHomePage().accountName_navbar);

    }

    @When("Account is clicked, Qr code, Full name, Email, Phone should be seen.")
    public void account_is_clicked_qr_code_full_name_email_phone_should_be_seen() {
        commonPage.getHomePage().accountName_navbar.click();
        Assert.assertTrue(commonPage.getAccountPage().qrCode.isDisplayed());
        Assert.assertTrue(commonPage.getAccountPage().firstName.isDisplayed());
        Assert.assertTrue(commonPage.getAccountPage().phone.isDisplayed());
        Assert.assertTrue(commonPage.getAccountPage().email.isDisplayed());


    }

    @When("Copy button should be functional")
    public void copy_button_should_be_functional() {
        commonPage.getAccountPage().copy.click();
        BrowserUtilities.wait(2);
        String actualMessage = commonPage.getAccountPage().toastMessage.getText();
        String expectedMessage = "Copied!";

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @When("Download button should be functional")
    public void download_button_should_be_functional() {

        if (BrowserUtilities.fileIsExist(System.getProperty("user.dir") + "\\target", "QRCode.png")) {
            BrowserUtilities.deleteFile(System.getProperty("user.dir") + "\\target", "QRCode.png");
        }

        commonPage.getAccountPage().download.click();
        BrowserUtilities.wait(2);

        Assert.assertTrue(BrowserUtilities.fileIsExist(System.getProperty("user.dir") + "\\target", "QRCode.png"));
    }

    @Test
    public void userHome() {
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
    }

    @Test
    public void name() {

        File file = new File(System.getProperty("user.home") + "\\Downloads");

        File[] listFiles = file.listFiles();
        boolean flag = false;
        for (File w : listFiles
        ) {

            if (w.getName().equals("QRCode.png")) {
                flag = w.exists();
                break;
            }

        }

        Assert.assertTrue(flag);
    }

    @When("Edit button should be clickable")
    public void edit_button_should_be_clickable() {

        commonPage.getAccountPage().edit.click();
        BrowserUtilities.wait(2);

        Assert.assertTrue(commonPage.getAccountPage().save.isDisplayed());
        Assert.assertTrue(commonPage.getAccountPage().chooseFile.isDisplayed());

    }

    @When("Choose file button should be functional")
    public void choose_file_button_should_be_functional() {


        List<String> list = new ArrayList<>();

        list.add("flagCanada.png");
        list.add("flagGermany.png");
        list.add("flagTurkey.png");
        list.add("flagUnitedKingdom.png");
        list.add("flagUnitedStates.png");

        String firstFlag = System.getProperty("user.dir") + "\\src\\test\\resources\\userLogo\\" + BrowserUtilities.giveMeRandomFlag(list);
        commonPage.getAccountPage().chooseFile.sendKeys(firstFlag);

        BrowserUtilities.screenShotWebElement(commonPage.getAccountPage().userLogo, "target/firstImage.png");

        String secondFlag = System.getProperty("user.dir") + "\\src\\test\\resources\\userLogo\\" + BrowserUtilities.giveMeRandomFlag(list, firstFlag);
        commonPage.getAccountPage().chooseFile.sendKeys(secondFlag);

        BrowserUtilities.screenShotWebElement(commonPage.getAccountPage().userLogo, "target/secondImage.png");

        boolean assertImageAreDifferent = BrowserUtilities.assertImageAreDifferent("target/firstImage.png", "target/secondImage.png");
        Assert.assertTrue(assertImageAreDifferent);
    }

    @When("The file should be selected when the choose file button is clicked.")
    public void the_file_should_be_selected_when_the_choose_file_button_is_clicked() {

    }

    @When("The account photo should change after the selected file")
    public void the_account_photo_should_change_after_the_selected_file() {

    }

    @When("After clicking the Edit button, the phone menu should be updated.")
    public void after_clicking_the_edit_button_the_phone_menu_should_be_updated() {


        Faker faker = new Faker();
        faker.number().digits(10);

        String phoneNumber = BrowserUtilities.fakePhoneNumber();  // 123132124564


        String firstNumber = commonPage.getAccountPage().phone.getAttribute("value"); //48722576294
        Assert.assertNotEquals(phoneNumber,firstNumber);


        BrowserUtilities.cleanTextFromWebelemnt(commonPage.getAccountPage().phone);

        commonPage.getAccountPage().phone.sendKeys(phoneNumber); // 123132124564
        String secondNumber = commonPage.getAccountPage().phone.getAttribute("value");

        Assert.assertEquals(phoneNumber,secondNumber.replaceAll("[ \\-+)(]",""));

    }



    @When("Save button should be functional")
    public void save_button_should_be_functional() {
        commonPage.getAccountPage().save.click();
        BrowserUtilities.wait(2);
    }

    @Then("After clicking the Save button, {string} should be displayed.")
    public void after_clicking_the_save_button_should_be_displayed(String expectedMessage) {
        String actualMessage = commonPage.getAccountPage().toastMessage.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Then("Toogle the menu button must be functional")
    public void toogle_the_menu_button_must_be_functional() {
        commonPage.getAccountPage().toggle.click();
    }

    @Then("Clicking the menu button on the Tooglle should change the menu dimensions.")
    public void clicking_the_menu_button_on_the_tooglle_should_change_the_menu_dimensions() {
        BrowserUtilities.wait(2);
        Assert.assertFalse(BrowserUtilities.isDisplayed(commonPage.getAccountPage().account_sideBar));
    }

}
