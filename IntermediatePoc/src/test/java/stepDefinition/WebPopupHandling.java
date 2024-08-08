package stepDefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WebPopupHandling {
	
	WebDriver driver;
	WebDriverWait wait;
     String URL="https://omayo.blogspot.com/";
@Given("user is able to enter URL and launch application")
			
			public void user_is_able_to_enter_url_and_launch_application() 
			{
				driver = new ChromeDriver();
			    driver.get(URL);
			    driver.manage().window().maximize();
			}

@Then("perform Windows Handling operation")
public void perform_windows_handling_operation() throws InterruptedException {
    String Parentwindow = driver.getWindowHandle();
    driver.findElement(By.linkText("Open a popup window")).click();
    Set<String> windows = driver.getWindowHandles();
    for (String win : windows) {
        driver.switchTo().window(win);
        if (driver.getTitle().equals("New Window")) {
            driver.manage().window().maximize();
            Thread.sleep(4000);
            driver.close();
   }
    }
    driver.switchTo().window(Parentwindow);  // Switching back to the parent window
    Thread.sleep(4000);
    driver.close();
}
}
