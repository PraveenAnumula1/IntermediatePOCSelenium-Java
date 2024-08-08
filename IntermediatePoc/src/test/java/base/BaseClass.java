package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass implements BrowserHandler {
    protected static WebDriver driver;

    public void setUp() {
        driver = new ChromeDriver();
    }
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
