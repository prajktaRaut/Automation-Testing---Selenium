import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    String methodName=null;
    WebDriver driver = null;
    ChromeOptions options = new ChromeOptions();
    @BeforeMethod
    public void setUp(Method method) {

        methodName=method.getName();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver","/home/admin1/Documents/PrajktaRaut/SeleniumDemo/src/drivers/chromedriver");
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
