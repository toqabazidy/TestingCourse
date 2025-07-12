package flatPackage;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrowserInteractionsTests {
    /**
     * This test will follow these steps using selenium web driver:
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">...</a>]
     * Assert that the page title is [Google]
     * Close Google Chrome
     */
    @Test
    public void testMethod(){
        WebDriver driver;
        ChromeOptions options;
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setBrowserVersion("134");
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
        options.setImplicitWaitTimeout(Duration.ofSeconds(30));
        driver = new ChromeDriver(options);
        //another new way to open an instant from chrome:
        //driver = ChromeDriver.builder().build();
        driver.navigate().to("https://duckduckgo.com/");
        String windowhandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://google.com");
        String windowhandle2 = driver.getWindowHandle();

        driver.switchTo().window(windowhandle);
        String duckDuckGo = driver.getCurrentUrl();

        driver.switchTo().window(windowhandle2);
        String google = driver.getCurrentUrl();

        String title = driver.getTitle();

        driver.quit();
    }
}
