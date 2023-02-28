package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import static utilities.Driver.getDriver;

public class RegisterPage extends CommonPage {
    @FindBy(css = "#registration_form_firstname")
    public WebElement firstName_registerForm;

    // ctrl D -> duplicate
    @FindBy(css = "#registration_form_lastname")
    public WebElement lastName_registerForm;


    // 2. yol
  //  public WebElement webElement = getDriver().findElement(By.cssSelector("#registration_form_firstname"));

    @FindBy(css = "#registration_form_firstname")
    public WebElement firstname;

    @FindBy(css = "#registration_form_middlename")
    public WebElement middleName;

    @FindBy(css = "#registration_form_lastname")
    public WebElement lastName;

    @FindBy(css = "#registration_form_email")
    public WebElement email;

    @FindBy(css = "#registration_form_plainPassword")
    public WebElement password;

    @FindBy(css = "#registration_form_confirmPassword")
    public WebElement confirmPassword;

    @FindBy(css = "[name='zipCode']")
    public WebElement zipCode;

    @FindBy(css = ".btn.alazea-btn")
    public WebElement registerButton;

    @FindBy(xpath = "//h1")
    public WebElement welcome;

    @FindBy(xpath = "//h2")
    public WebElement whatWouldYouLikeToDo;

    @FindBy(xpath = "//a[text()='Buy local food']")
    public WebElement buyLocalFood;

    @FindBy(xpath = "//a[text()='Sell local food']")
    public WebElement sellLocalFood;

    @FindBy(xpath = "//a[text()='Provide service for gardening']")
    public WebElement serviceForGardening;

    @FindBy(xpath = "//a[text()='I will do all']")
    public WebElement willDoAll;

}
