package RunnerFiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

                features = "src/test/java/FeatureFiles/AbhiBus_Booking.feature",
                glue = "StepDefination",
                plugin = {"pretty","html:target/cucumber-report","json:target/cucumber.json","pretty:target/cucumber-pretty.txt, com.avenstack.extentreports.cucumber.adpter.ExtentCucumberAdpter"}
)
public class Runner {
}
