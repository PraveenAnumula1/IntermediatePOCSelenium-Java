package stepDefinition;

import java.awt.Robot;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class Robot_class {

     WebDriver driver;
     Robot robot;

    @Given("I open the Facebook login page")
    public void openFacebookPage() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
    }

    @And("maximize the browser window")
    public void maximizeWindow() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @When("I perform mouse actions")
    public void performMouseActions() throws Exception {
        robot = new Robot();
        
        robot.setAutoDelay(500);

        robot.mouseMove(370, 466);
    
        robot.mouseWheel(100);
    
    }

    @Then("verify the actions are performed successfully")
    public void verifyActions() {
        
    	driver.close();
   
        }
    
}
