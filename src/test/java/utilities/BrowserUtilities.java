package utilities;

import enums.USERINFO;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static stepDefinitions.Hooks.*;

public class BrowserUtilities {

    static Random random = new Random();

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

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    /**
     * methood used to clean text
     * @param webElement webelemnt will be cleaned
     * @since 01.02.2023
     * @author omeryttnc
     */
    public static void cleanTextFromWebelemnt(WebElement webElement) {
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


    /**
     * method verdigimiz listeden sectigimiz bir objeyi cikartip bize bir tane random obje verecek
     *
     * @param flags icerisinde String turunde variable larimiz oldugu liste
     * @param flag  istemedigimiz String degerimiz
     * @return istemedigimiz String haricinde listeden verilecek bir parametre
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static String giveMeRandomFlag(List<String> flags, String flag) {
        flags.remove(flag);
        int randomFlag = random.nextInt(flags.size());
        return flags.get(randomFlag);
    }

    /**
     * method bize listeden random bir String degeri verecek
     *
     * @param flags icerisinde String turunde variable larimiz oldugu liste
     * @return listeden rastgele alacagimiz bir String
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static String giveMeRandomFlag(List<String> flags) {
        int randomFlag = random.nextInt(flags.size());
        return flags.get(randomFlag);
    }

    /**
     * method webelementin resmini almak icin kullanildi
     *
     * @param webElement resmini alacagimiz webelement
     * @param filePath   aldigimiz resmi koyacagimiz yol
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static void screenShotWebElement(WebElement webElement, String filePath) {

        File screenshotAs = webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotAs, new File(filePath));
        } catch (IOException e) {
            //System.out.println("dosya bulunamadi");
            throw new RuntimeException(e);
        }
    }

    /**
     * method bize iki resim farkli mi oldugunu gosteriyor
     *
     * @param image1Path ilk resmin yolu
     * @param image2Path ikinci resmin yolu
     * @return iki resim birbirinden FARKLI mi, farkli ise true ayni ise false donecek
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static boolean assertImageAreDifferent(String image1Path, String image2Path) {
        BufferedImage image1, image2;
        try {
            image1 = ImageIO.read(new File(image1Path));
            image2 = ImageIO.read(new File(image2Path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ImageDiffer imageDiffer = new ImageDiffer();
        ImageDiff diff = imageDiffer.makeDiff(image1, image2);


        return diff.hasDiff();
    }

    /**
     * method webelemente tiklayabilecegimiz ana kadar bekliyecek
     *
     * @param webElement bekleyecegimiz webelement note: bekleme suresini default olarak 10 saniye yaptim
     * @return bekledigimiz webelement
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static WebElement waitForClickable(WebElement webElement) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));

        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * method bilgisayarimizda olan bir dosyayi silmeye yariyor
     *
     * @param filePath silinecek dosyanin oldugu klasorun yolu
     * @param fileName silinecek dosyanin adi note: uzantisiyla beraber
     * @return eger dosya silindi ise true silinemedi ise false
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static boolean deleteFile(String filePath, String fileName) {
        File file = new File(filePath);

        File[] listFiles = file.listFiles();

        for (File w : listFiles
        ) {

            if (w.getName().equals(fileName)) {
                w.delete();
                break;
            }

        }
        return false;

    }

    /**
     * method bilgisayarimizda olan bir dosyanin varligini gosteriyor
     *
     * @param filePath bakacagimiz dosyanin oldugu klasorun yolu
     * @param fileName bakacagimiz dosyanin adi note: uzantisiyla beraber
     * @return eger dosya var ise true yok ise false dondurecek
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static boolean fileIsExist(String filePath, String fileName) {

        File file = new File(filePath);

        File[] listFiles = file.listFiles();

        for (File w : listFiles
        ) {

            if (w.getName().equals(fileName)) {
                return w.exists();
            }

        }
        return false;
    }

    /**
     * method bize 11 haneli random bir sayi verecek
     *
     * @return 11 haneli bir sayi
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static String fakePhoneNumber() {

        String phone = "1";

        StringBuilder fakeResult = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            fakeResult.append(random.nextInt(10));

        }
        return "1"+fakeResult.toString();



    }

    /**
     * method webelementin UI da gozukup gozukmedigini anlamamiza yarayacak
     *
     * @param webElement bakacagimiz webelement
     * @return eger gozukuyorsa true gozukmuyorsa false donecek
     * @author omeryttnc
     * @since 04.02.2023
     */
    public static boolean isDisplayed(WebElement webElement) {
        boolean flag;


        try {
            flag = webElement.isDisplayed();
        } catch (Exception e) {
            flag = false;
        }

        return flag;
    }


}
