package RunnerFiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/FeatureFiles/AbhiBus_Ticket_Booking_for_Bus.feature",
        glue = "StepDefination",
        plugin = {"pretty","html:target/cucumber-report","json:target/cucumber.json","pretty:target/cucumber-pretty.txt, com.avenstack.extentreports.cucumber.adpter.ExtentCucumberAdpter"},
        tags = "@FunctionalTest"
        
)
public class mainRunner {
}
