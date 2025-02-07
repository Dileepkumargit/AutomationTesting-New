package POM;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import static POM.resultsPage.random;

public class homePage{
	static WebDriver driver;
	
//	public static homePage getHomepage() {
//		return new homePage(driver);
//	}	
//	
		public homePage(WebDriver driver){
        this.driver = driver;
    }
	
	public homePage enterFromCity() throws InterruptedException {
		Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='container text-input  ']//div[@class=' col']/input[contains(@placeholder,'From Station')]")).sendKeys("Ban");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='container text-input  ']//div[@class=' col']/input[contains(@placeholder,'From Station')]")).sendKeys(Keys.ENTER);
		return this;

	}

	public homePage enterToCity() throws InterruptedException {
			driver.findElement(By.xpath("//div[@class='container text-input  ']//div[@class=' col']/input[contains(@placeholder,'To Station')]")).sendKeys("chennai");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='container text-input  ']//div[@class=' col']/input[contains(@placeholder,'To Station')]")).sendKeys(Keys.ENTER);
			return this;

	}

	public homePage pickJourneydate() throws InterruptedException {
//			WebElement flightTooltip_Msg = driver.findElement(By.xpath("//h1[contains(text(),'Flight Booking')]"));
		try{
		if(driver.findElement(By.xpath("//h1[contains(text(),'Book Bus Tickets')]")).isEnabled()) {

				Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='container text-input  ']//div[@class=' col']/input[contains(@placeholder,'Onward Journey Date')]")).click();
				WebElement datePicker = driver.findElement(By.xpath("//div[@class='container text-input  ']//div[@class=' col']/input[contains(@placeholder,'Onward Journey Date')]"));
				String todayDate =datePicker.getAttribute("value");
				String date= todayDate.substring(0,2);
				System.out.println(date);
				driver.findElement(By.xpath("//div[@class='container calendar  ']//span[@data-date='19']")).click();
		}}catch (NoSuchElementException e){
		if (driver.findElement(By.xpath("//h1[contains(text(),'Flight Booking')]")).isDisplayed()){

			driver.findElement(By.xpath("//p[contains(text(),'Departure')]//ancestor::div[@class='bg-charcoal-40 hover:bg-neutral-subtle-over w-full']")).click();
			driver.findElement(By.xpath("//button[@class='react-calendar__tile react-calendar__month-view__days__day']//abbr[@aria-label='February 21, 2025']")).click();
		}}

		return this;

	}

	public homePage clickonSearch() {

			driver.findElement(By.xpath("//div[@id='search-button']")).click();

		return this;

	}

	public homePage ClickOnOperator(operator value) throws InterruptedException {
			Thread.sleep(3000);
			System.out.println("checking in "+value +" Operator");
			driver.findElement(By.xpath("//div[@id='top-navigation']//a[@id='" + value + "-link']")).click();
		return this;
	}

	public homePage fromStation(String fromCity) throws InterruptedException {
//			WebElement BusBooking = driver.findElement(By.xpath("//h1[contains(text(),'Book Bus Tickets')]"));
			try{
				driver.findElement(By.xpath("//input[@placeholder= 'From Station' ]//ancestor::div[@class='container form-control  ']")).click();
				driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys(fromCity);
				Thread.sleep(2000);
				driver.findElement((By.xpath("//input[@placeholder='From Station']//ancestor::div[@id='search-from']//ul/li[contains(@data-id,'Bangalore')]"))).click();
			}

			catch(NoSuchElementException f){

				Thread.sleep(3000);
				try {
					driver.findElement(By.xpath("//div[@class='source']//div")).click();
					driver.findElement(By.xpath("//div[@class='search-input']//input[1]")).sendKeys(fromCity);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//ul//li[@id='source-item-0']")).click();
				}
				catch(NoSuchElementException e){
					driver.findElement(By.xpath("//div[@class='flex justify-between items-center relative w-full h-full  block']")).click();
					driver.findElement(By.xpath("//label[contains(text(),'From')]//parent::div[@class='flex flex-grow items-center']//input")).sendKeys(fromCity);
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//div[contains(@class,'overflow-y-scroll absolute')]//div[@role='listitem'])[1]")).click();
				}
			}
			return this;
	}

	public homePage ToStation(String ToCity) throws InterruptedException {
		Thread.sleep(2000);
		try{
			driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys(ToCity);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='To Station']//ancestor::div//ul//li[contains(@data-id,'Chennai')]")).click();
		}
		catch(NoSuchElementException e) {
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='destination']//div")).click();
				driver.findElement(By.xpath("//div[@class='destination']//input[1]")).sendKeys(ToCity);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//ul//li[@id='destination-item-1']")).click();
			}
			catch(NoSuchElementException f) {
				driver.findElement(By.xpath("//div[@class='bg-charcoal-40 flex items-center relative w-full h-[60px] hover:bg-neutral-subtle-over border-b-4 border-blue-500 ']")).click();
				driver.findElement(By.xpath("//label[contains(text(),'To')]//parent::div[@class='flex flex-grow items-center']//input")).sendKeys(ToCity);
				Thread.sleep(1500);
				driver.findElement(By.xpath("(//div[@class='bg-charcoal-40 flex items-center relative w-full h-[60px] hover:bg-neutral-subtle-over border-b-4 border-blue-500 ']//div[contains(@class,'overflow-y-scroll absolute')]//div[@role='listitem'])[1]")).click();
			}
		}
		return this;
	}

	public homePage selectDate() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//input[@id='dateOfJourney']")).click();
		List<WebElement> Dates = driver.findElements(By.xpath("//div[@class='MuiPickersCalendar-week']//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersDay-day']//parent::div"));
		WebElement SelectedDate = Dates.get(1);
		System.out.println(SelectedDate.getText());
		SelectedDate.click();
		return  this;
	}

	public homePage clickOnSearch() {
			try {
			driver.findElement(By.xpath("//div[@class='search-form']//button")).click();
		}catch ( NoSuchElementException e){
				driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
			}

		return this;
	}

	public homePage enterThefromLocation() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		if(driver.getTitle().contains("Flight Booking, Cheap Flights, Air Tickets at Lowest Fare | ixigo")){
			String fromLocation = "BLR";
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@role='tablist']/button[2]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'From')]//ancestor::div[@class='relative flex gap-0.5 flex-1']/div[1]")).click();

			driver.findElement(By.xpath("//label[contains(text(),'From')]/ancestor::div/input")).sendKeys(fromLocation);
			driver.findElement(By.xpath("//div[@class='overflow-y-scroll absolute top-[61px] bg-white w-[375px] min-h-[150px] max-h-[450px] shadow-500 z-20 rounded-20 !animate-none no-scrollbar block Autocompleter_animate__zqRDe']//li//span[contains(text(),'"+fromLocation+"')]")).click();
			driver.findElement(By.xpath("//div[@class='flex gap-0.5 cursor-pointer h-[60px]']/button")).sendKeys("Bangalore");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='overflow-y-scroll absolute top-[61px] bg-white w-[375px] min-h-[150px] max-h-[450px] shadow-500 z-20 rounded-20 !animate-none no-scrollbar block Autocompleter_animate__zqRDe']//li//span[contains(text(),'DEL')]")).click();
		}
			return  this;
	}

	public homePage enterToLocation() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		if(driver.getTitle().contains("Flight Booking, Cheap Flights, Air Tickets at Lowest Fare | ixigo")){
			String ToLocation = "BLR";

			driver.findElement(By.xpath("//span[contains(text(),'From')]//ancestor::div[@class='relative flex gap-0.5 flex-1']/div[2]")).click();

			driver.findElement(By.xpath("//label[contains(text(),'From')]/ancestor::div/input")).sendKeys(ToLocation);
			driver.findElement(By.xpath("//div[@class='overflow-y-scroll absolute top-[61px] bg-white w-[375px] min-h-[150px] max-h-[450px] shadow-500 z-20 rounded-20 !animate-none no-scrollbar block Autocompleter_animate__zqRDe']//li//span[contains(text(),'"+ToLocation+"')]")).click();
			driver.findElement(By.xpath("//div[@class='flex gap-0.5 cursor-pointer h-[60px]']/button")).sendKeys("Delhi");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='overflow-y-scroll absolute top-[61px] bg-white w-[375px] min-h-[150px] max-h-[450px] shadow-500 z-20 rounded-20 !animate-none no-scrollbar block Autocompleter_animate__zqRDe']//li//span[contains(text(),'DEL')]")).click();
		}
		return  this;
	}

	public homePage ChooseOriginStation(){
			List<WebElement> Origin_Stations = driver.findElements(By.xpath("//div[contains(text(),'Origin Station')]//following-sibling::div/div[@class='MuiGrid-root MuiGrid-container']//span[@class='MuiIconButton-label']"));
			random(Origin_Stations);
			return this;
	}
	public homePage ChooseDestinationStation(){
			List<WebElement> Destination_Station=  driver.findElements(By.xpath("//div[contains(text(),'Destination Station')]//following-sibling::div/div[@class='MuiGrid-root MuiGrid-container']//span[@class='MuiIconButton-label']"));
			random((Destination_Station));
			return this;
	}

	public homePage ChooseTrainFromList(){
			List<WebElement> TrainsList = driver.findElements(By.xpath("//div[@class='name']"));
			int TotalTrains = random.nextInt(TrainsList.size());
			String selectedPickup = TrainsList.get(TotalTrains).getText();
			System.out.println("Selected Train::" +selectedPickup);

			//Select seat category
			List< WebElement> seatCategory = driver.findElements(By.xpath("//div[@class='name']//ancestor::div/div[@class='train']//div[@class='avail-block']"));
			int TotalSeatCategories = random.nextInt(seatCategory.size());
			String SelectedSeatCategory = seatCategory.get(TotalSeatCategories).getText();
			System.out.println("Selected Seat Category ::  "+ SelectedSeatCategory);
			random(seatCategory);
			return this;
	}
	public void random(List<WebElement> links) {
//		List<WebElement> AllLinks;
		int pickupPoint = random.nextInt(links.size());
		String selectedPickup = links.get(pickupPoint).getText();
		System.out.println("Selected ::" +selectedPickup);
		links.get(pickupPoint).click();
	}

}
