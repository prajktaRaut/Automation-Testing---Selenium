package com.bridgelabz.seleniumtestforfacebook;

import com.bridgelabz.seleniumtesting.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FacebookAppTest extends BaseTest {

    @Test
    public void performing_LoginOperationOfFacebook() {

        try {
            driver.get("https://www.facebook.com");
            WebElement email = driver.findElement(By.name("email"));
            email.sendKeys("9764324126");
            WebElement password = driver.findElement(By.name("pass"));
            password.sendKeys("Psraut@123");
            Thread.sleep(2000);
            WebElement websubmit = driver.findElement(By.id("loginbutton"));
            websubmit.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void performing_ForgottenAccountOperationOfFacebook() {

        try {
            driver.get("https://www.facebook.com");
            WebElement forgetAccount = driver.findElement(By.linkText("Forgotten account?"));
            forgetAccount.click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void performing_LogoutOperationOfFacebook() {

        try {
            driver.get("https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110");
            WebElement email = driver.findElement(By.name("email"));
            email.sendKeys("9764324126");
            WebElement password = driver.findElement(By.name("pass"));
            password.sendKeys("Psraut@123");
            Thread.sleep(2000);
            WebElement websubmit = driver.findElement(By.name("login"));
            websubmit.click();
            WebElement moreOption = driver.findElement(By.xpath("//div[@id='userNavigationLabel']"));
            moreOption.click();
            Thread.sleep(5000);
            WebElement logout = driver.findElement(By.xpath("//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']"));
            logout.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
