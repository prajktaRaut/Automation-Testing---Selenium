
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class SeleniumTest extends BaseTest {

    @Test
    public void upcastingToWebdriver_ToLunchBrowser() {

        try {
            driver.get("https://www.google.com/");
            String title = driver.getTitle();
            System.out.println("Title of page is "+title);
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current url of page is "+currentUrl);
            String pageSource = driver.getPageSource();
            System.out.println("pagesource of page is "+pageSource);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Test
    public void captureScreenshots() {
        try {
            Date d = new Date();
            String date = d.toString();
            System.out.println("Current date is "+date);
            String newDate = date.replaceAll(":", "-");
            System.out.println("New date is "+newDate);
            System.setProperty("webdriver.chrome.driver","chromedriver");
            driver.get("https://www.youtube.com/watch?v=T_4ZFj_KTx4");
            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("/home/admin1/Documents/PrajktaRaut/SeleniumDemo/src/test/resources/ScreenShots/image.jpg");
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Test
    public void browserNavigationExamples() {

        try {
            System.setProperty("webdriver.chromedriver.driver","chromedriver");
            driver.get("https://www.google.com/");
            Thread.sleep(2000);
            driver.navigate().to("https://www.gmail.com/");
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(3000);
            driver.navigate().forward();
            Thread.sleep(3000);
            driver.navigate().refresh();
            driver.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

