package stepDefinition;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.time.Duration;

public class Hash_Maps_Arraylist {

    public static WebDriver driver;

    @Given("User is on the inventory page")
    public void user_is_on_the_inventory_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='login-button']")).click();
        Thread.sleep(2000);
    }

    @Then("User adds specified items to the cart")
    public void user_adds_specified_items_to_the_cart() {
        Map<String, String> addtocartitems = new HashMap<>();
        addtocartitems.put("Sauce Labs Backpack", "$29.99");
        addtocartitems.put("Sauce Labs Bolt T-Shirt", "$15.99");

        List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));

        for (Entry<String, String> entry : addtocartitems.entrySet()) {
            String itemName = entry.getKey();
            String price = entry.getValue();

            boolean itemFound = false;
            for (WebElement product : products) {
                String productName = product.findElement(By.cssSelector(".inventory_item_name")).getText();

                if (productName.equals(itemName)) {
                    product.findElement(By.cssSelector(".btn_inventory")).click();
                    itemFound = true;
                    break;
                }
            }

            if (!itemFound) {
                System.out.println("Item not found: " + itemName);
           
            }
        }
    }
}
