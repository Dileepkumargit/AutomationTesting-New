package POM;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.apache.commons.io.filefilter.FileFilterUtils.toList;

public class resultsPage{
	
	static Random random = new Random();
	
	WebDriver driver;
	
	public resultsPage(WebDriver driver){
        this.driver = driver;
    }

	public resultsPage busses() throws InterruptedException {
		List<WebElement> AllBusses = driver.findElements(By.xpath("//div[@class='container  ']//div[@class='operator-info col s12 m6 l6']/h5"));
		int TotalBus = random.nextInt(AllBusses.size());
		String selectedBus = AllBusses.get(TotalBus).getText();
		System.out.println("Selected ::" +selectedBus);
		Thread.sleep(2000);
		AllBusses.get(TotalBus).click();
		List<WebElement> SeatsBtn = driver.findElements(By.xpath("//div/h5[@class='title']//ancestor::div[@class='container  ']//div[contains(@id,'service-operator-select-seat')]"));

		random(SeatsBtn);
//		driver.findElement(By.xpath(selectedBus)).click();

		return this;

	}
	public resultsPage selectBus() throws InterruptedException {
		busses();

		WebElement BusName = driver.findElement(By.xpath("//div[@class='container card service  md '][1]"));
//		System.out.println("BusOperator :: "+BusName.getText());
//		List<WebElement> Showseats = driver.findElements(By.xpath("//div[@class='container card service  md ']//div//button"));
//		Thread.sleep(5000);
//		random(Showseats);
		return this;

	}
	
	public resultsPage selectSeat() throws InterruptedException {
		
		List<WebElement> AllSeats = driver.findElements(By.xpath("//div[@class='Tooltip-Wrapper ']/button/*/*[1][contains(@fill,'white')]//ancestor::button"));
		int selectseat = random.nextInt(AllSeats.size());
		String SelectedSeat = AllSeats.get(selectseat).getText();

		System.out.println("SelectedSeat :: "+SelectedSeat);
		Thread.sleep(2000);
		AllSeats.get(selectseat).click();

		return this;
		
		
	}
	
	public resultsPage selectPickUpLoc() {
		
		List<WebElement> Pickuploc = driver.findElements(By.xpath("//div[@id='place-container']//div[@class='label']//parent::div"));
		random(Pickuploc);
		return this;
	}
	
	public resultsPage selectdroppoint() {
		
		List<WebElement> DropPoint = driver.findElements(By.xpath("//div[@id='place-container']//div[@class='label']//parent::div"));
		random(DropPoint);
		return this;
	}
	
	public resultsPage selectBusType(busType value) {
		System.out.println("BusType :: "+ value);
//		WebDriverWait wait = new WebDriverWait(driver, );
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
		driver.findElement(By.xpath("//div[@id='seat-filter-bus-type']//span[starts-with(text(),'"+value+"')]")).click();

		return this;
		
	}
	
	public void random(List<WebElement> links) {
//		List<WebElement> AllLinks;
		int pickuppoint = random.nextInt(links.size());
		String selectedPickup = links.get(pickuppoint).getText();
		System.out.println("Selected ::" +selectedPickup);
		links.get(pickuppoint).click();
	}


}
