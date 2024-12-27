package StepDefination;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class hooks {
	
	public static WebDriver driver;
	@Before
	public void before() throws Exception {
	
//		String browser = "chrome";
//		
//		if(browser.equalsIgnoreCase("chrome")) {
//		
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			
//		}
//		else if(browser.equalsIgnoreCase("firefox")) {
//		
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		else if(browser.equalsIgnoreCase("Edge")) {
//			
//			WebDriverManager.edgedriver().setup();
//			driver = new FirefoxDriver();
//		}
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.abhibus.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
	}
//	 @After
     public void close(Scenario scenario) {

			 if (scenario.isFailed()) {
		      // Take a screenshot...
				 
				 TakesScreenshot ts = (TakesScreenshot) driver;

				 byte[] src = ts.getScreenshotAs(OutputType.BYTES);
				 scenario.attach(src, "image/png", "screenshot"); // ... and embed it in the report.
			 }
			 driver.quit();
        }
//	 public void embedScreenshot(Scenario scenario) {
//	        if(scenario.isFailed()) {
//	            try {
//	                scenario.write("Current Page URL is " + driver.getCurrentUrl());
//	                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//	                scenario.embed(screenshot, "image/png");
//	            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
//	                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
//	            }
//	        }}
	
}
