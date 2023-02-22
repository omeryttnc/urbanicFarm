package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends CommonPage {

    @FindBy(css = "//a[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "(//a[text()='Logout'])[2]")
    public WebElement logoutButton;

    @FindBy(css = ".Navbar_textLink__f6_Al.mr-2")
    public WebElement registerButton_navbar;

    @FindBy(css = "nav>a[href^='/account/home']")
    public WebElement accountName_navbar;

    @FindBy(xpath = "//div[@class='row p-0']")
    private List<WebElement> productCards;

    @FindBy(css = "div.ProductCard_namePrice__1GlyT > p")
    public List<WebElement> productPrices;

    @FindBy(xpath = "//button[contains(@class,'btn-success ProductCard_addCartBtn___oxgf') and text()='Add to Cart']")
    public List<WebElement> productAddToCart;
    @FindBy(xpath = "//span[@class='Navbar_cartText__1jkrK']")
    public WebElement go_to_cart_button;


    public List<WebElement> getProductNames() {

        return productCards.stream()
                .map(t -> t.findElement(By.cssSelector("p.m-0.text-white.ProductCard_productTitle__3K4rg")))
                .collect(Collectors.toList());

    }

}
