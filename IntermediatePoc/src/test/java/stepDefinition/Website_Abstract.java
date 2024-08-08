package stepDefinition;
import org.openqa.selenium.WebDriver;

public abstract class Website_Abstract implements Page{
		
		protected WebDriver driver;

	    public Website_Abstract(WebDriver driver) {
	        this.driver = driver;
	    }
	    @Override
	    public void open() {
	        driver.get("https://omayo.blogspot.com/");
	    }
	    @Override
	    public String getPageTitle() {
	        
	        return driver.getTitle();	        
	    }
	}

