package POM;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import StepDefination.hooks;

public class resultsPage{
	
	static Random random = new Random();
	
	WebDriver driver;
	
	public resultsPage(WebDriver driver){
        this.driver = driver;
    }
	
	public resultsPage selectBus() throws InterruptedException {
		
		WebElement BusName = driver.findElement(By.xpath("//div[@class='container card service  md '][1]"));
//		System.out.println("BusOperator :: "+BusName.getText());
		driver.findElement(By.xpath("//div[@class='container card service  md '][1]/div//button")).click();
		return this;
		
	}
	
	public resultsPage selectSeat() throws InterruptedException {
		
		List<WebElement> AllSeats = driver.findElements(By.xpath("//div[@class='Tooltip-Wrapper ']"));
		
		int selectseat = random.nextInt(AllSeats.size());
		String SelectedSeat = AllSeats.get(selectseat).getText();
		System.out.println(SelectedSeat);
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
