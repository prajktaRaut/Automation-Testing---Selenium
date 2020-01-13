package com.bridgelabz.seleniumtesting;

import com.bridgelabz.seleniumtesting.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MainTest extends BaseTest {

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
    }

    @Test
    public void captureScreenshots() {
        try {
            Date d = new Date();
            String date = d.toString();
            System.out.println("Current date is "+date);
            String newDate = date.replaceAll(":", "-");
            System.out.println("New date is "+newDate);
            driver.get("https://www.youtube.com/watch?v=T_4ZFj_KTx4");
            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("/home/admin1/Documents/PrajktaRaut/SeleniumDemo/src/test/resources/ScreenShots/"+methodName+".jpg");
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mouseAndKeyboardMoves() {

        try {
            System.setProperty("webdriver.chromedriver.driver","chromedriver");
            driver.navigate().to("https://www.google.com/");
            Thread.sleep(2000);
            Robot robot = new Robot();
            robot.mouseMove(200,50);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_F);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyPress(KeyEvent.VK_ALT);
            Thread.sleep(3000);
            robot.keyRelease(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_F);
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);
            Thread.sleep(1000);
            //driver.close();
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void locatorExample() {

        try {
            System.setProperty("webdriver.chromedriver.driver","chromedriver");
            driver.get("https://www.facebook.com");
            WebElement firstname = driver.findElement(By.name("firstname"));
            firstname.sendKeys("prajkta");
            Thread.sleep(2000);
            WebElement lastname = driver.findElement(By.id("u_0_o"));
            lastname.sendKeys("Raut");
            Thread.sleep(3000);
           // WebElement websubmit = driver.findElement(By.linkText("Forgotten account?"));
            WebElement websubmit = driver.findElement(By.name("websubmit"));
            websubmit.click();
            Thread.sleep(3000);
            driver.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

