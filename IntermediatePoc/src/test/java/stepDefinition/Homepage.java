package stepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends Website_Abstract {

    public Homepage(WebDriver driver) {
	        super(driver);
	    }

	    public void clickhomebutton() {
	    	
	        driver.findElement(By.cssSelector("span[id='home']")).click();
	    }
	}


