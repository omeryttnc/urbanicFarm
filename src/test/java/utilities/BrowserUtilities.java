package utilities;

import enums.USERINFO;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class BrowserUtilities {
    public static void loginMethod(USERINFO userinfo) {

        driver.get("https://test.urbanicfarm.com/auth/login");
        commonPage.getLoginPage().loginMethod(userinfo);
    }

    public static void loginMethod(String userName, String password) {
        driver.get("https://test.urbanicfarm.com/auth/login");
        commonPage.getLoginPage().loginMethod(userName, password);
    }

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void localClear() {
        LocalStorage local = ((WebStorage) Driver.getDriver()).getLocalStorage();
         local.clear();
        Driver.getDriver().navigate().refresh();
        waitForPageToLoad(10);

    }
}
