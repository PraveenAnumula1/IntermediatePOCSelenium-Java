package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utils.baseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertHandling extends baseClass{
	
    private WebDriver driver;

    @Given("User is on the Alerts page")
    public void userIsOnAlertsPage() {
        initializeWebDriver();
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();      
    }   
    private void initializeWebDriver() {
    	 driver=baseClass.createDriver();
    }
    @When("User clicks on the {string} button")
    public void userClicksOnButton(String buttonName) {
        clickAlertButton();
        
        // Abstraction: Hiding the details of handling sleep
        waitForAlert();
    }   
    private void clickAlertButton() {
        WebElement alertPromptLink = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        alertPromptLink.click();
    }   
    private void waitForAlert() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Then("User should see an alert prompt with message {string}")
    public void userShouldSeeAlertPromptWithMessage(String expectedMessage) {
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @When("User handles the alert prompt using try-catch")
    public void userHandlesAlertPromptUsingTryCatch() {
       
        handleAlert();
    }   
    private void handleAlert() {
        try {
            driver.switchTo().alert().accept();
            System.out.println("Alert is Presented");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Then("User should see the alert prompt dismissed")
    public void userShouldSeeAlertPromptDismissed() {
        closeWebDriver();
    }
    private void closeWebDriver() {
        driver.close();
    }
}
