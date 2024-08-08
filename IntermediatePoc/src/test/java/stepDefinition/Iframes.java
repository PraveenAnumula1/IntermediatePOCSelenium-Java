package stepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Iframes {
	
	 public static WebDriver driver;
	    public static WebDriverWait wait;

	    @Given("the user launches the Instacart application")
	    public void launchInstacartApplication() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
	        driver.get("https://www.instacart.com");
	    }

	    @Then("the user should find and interact with the iframe")
	    public void handleIframe() throws InterruptedException {
	    	 WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox']"));
	    	 checkBox1.click();
	        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[tabindex='0']")));
	        driver.switchTo().frame(iframe);

	        if (iframe != null) {
	            Thread.sleep(10000);
	            System.out.println("Iframe with specified tabindex found");
	           
	            WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
	            if (checkBox != null) {
	                System.out.println("Checkbox found");
	                checkBox.click(); 
	            } else {
	                System.out.println("Checkbox not found");
	            }
	        } else {
	            System.out.println("Iframe with specified tabindex not found");
	        }

	        driver.quit();
        }
	
	}
