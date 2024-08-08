package stepDefinition;

import base.BaseClass; // Import BaseClass
import base.BrowserHandler;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowsHandling {
    
    private BrowserHandler browserHandler;

    // Public zero-argument constructor
    public WindowsHandling() {
        // Instantiate BaseClass which implements BrowserHandler
        this.browserHandler = new BaseClass();
    }

    public WindowsHandling(BrowserHandler browserHandler) {
        this.browserHandler = browserHandler;
    }

    @Given("user is able to enter the url and launch the Naukari application")
    public void user_is_able_to_enter_the_url_and_launch_the_naukari_application() {
        browserHandler.setUp();
        browserHandler.getDriver().manage().window().maximize();
        browserHandler.getDriver().get("http://www.naukri.com");
    }

    @Then("Perform Windows handling operation")
    public void perform_windows_handling_operation() throws InterruptedException {
        WebDriver driver = browserHandler.getDriver();
        String parent = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            String windowHandle = iterator.next();
            if (!windowHandle.equals(parent)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Window Title: " + driver.getTitle());
                driver.close();
            }
        }
        // Switch back to the parent window
        driver.switchTo().window(parent);       
        Thread.sleep(5000);
        driver.close();
    }
}
