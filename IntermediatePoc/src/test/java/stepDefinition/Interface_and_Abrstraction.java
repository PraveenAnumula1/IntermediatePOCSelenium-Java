package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Interface_and_Abrstraction {

    public static WebDriver driver;

    public static void main(String[] args) {
       
        driver = new ChromeDriver();

      
        Website_Abstract homePage = new Homepage(driver);

     
        homePage.open();

       
        ((Homepage) homePage).clickhomebutton();

        
        System.out.println("Page Title: " + homePage.getPageTitle());
     
        driver.quit();
    }
}
