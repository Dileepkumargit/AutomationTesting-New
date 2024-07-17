package POM;

import java.util.List;

import org.openqa.selenium.*;

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
		Thread.sleep(2000);

			driver.findElement(By.xpath("//div[@class='container text-input  ']//div[@class=' col']/input[contains(@placeholder,'Onward Journey Date')]"))
					.click();
			driver.findElement(By.xpath("//div[@class='container calendar  ']//span[@data-date='30']")).click();
		return this;

	}

	public homePage clickonSearch() {

			driver.findElement(By.xpath("//div[@id='search-button']")).click();

		return this;

	}

	public homePage ClickOnOperator(operator value) {
		System.out.println("checking in "+value +" Operator");
		driver.findElement(By.xpath("//div[@id='top-navigation']//a[@id='"+value+"-link']")).click();
		return this;
		
	}

	public homePage fromTrainStation() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='source']//div")).click();
		driver.findElement(By.xpath("//div[@class='search-input']//input[1]")).sendKeys("Bangalore");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul//li[@id='source-item-0']")).click();
		
		return this;
	}

	public homePage ToTrainStation() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='destination']//div")).click();
		driver.findElement(By.xpath("//div[@class='destination']//input[1]")).sendKeys("Chennai");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul//li[@id='destination-item-1']")).click();
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
		driver.findElement(By.xpath("//div[@class='search-form']//button")).click();
		return this;
	}
}
