package pages;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryAndPickupSettings extends CommonPage {
    @FindBy(css = ".Navbar_textLink__f6_Al.cursor-pointer.ml-4.mr-3.text-capitalize")
    public WebElement user;

    @FindBy(css = "[href='/account/delivery']")
    public WebElement delivery;

    @FindBy(id = "SELLER_FLEXIBLE")
    public WebElement seller_flexible;

    @FindBy(css = "#freeFlexibleDeliveryRange")
    public WebElement freeFlexibleDeliveryRange;

    @FindBy(css = "#minFreeFlexibleDeliveryOrder")
    public WebElement minFreeFlexibleDeliveryOrder;

    @FindBy(css = "[type='submit']")
    public WebElement update;

    @FindBy(css = "#_deliveryBeginDay")
    public WebElement deliveryBeginDay;
    @FindBy(css = "#_deliveryBeginTime")
    public WebElement deliveryBeginTime;
    @FindBy(css = "#_deliveryEndDay")
    public WebElement deliveryEndDay;
    @FindBy(css = "#_deliveryEndTime")
    public WebElement deliveryEndTime;
    @FindBy(css = "#_orderByDay")
    public WebElement orderByDay;
    @FindBy(css = "#_orderByTime")
    public WebElement orderByTime;


}