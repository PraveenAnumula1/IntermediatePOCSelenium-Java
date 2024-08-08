package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
    features = "src/test/java/feature",
    
    glue = {"stepDefinition", "listeners"},
    
    plugin = { "pretty", "html:target/cucumber-reports.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    
    monochrome = true
)
public class RunnerTest 
{    
		
}
