
package base;
import org.openqa.selenium.WebDriver;

public interface BrowserHandler {
	    void setUp();
	    void tearDown();
	    WebDriver getDriver();
	}
