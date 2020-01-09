
import org.testng.annotations.Test;

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

}

