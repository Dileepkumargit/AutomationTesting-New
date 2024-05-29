package POM;

import org.openqa.selenium.By;

import StepDefination.hooks;

public class loginPage extends hooks{
	
	public void clickOnSignLinks() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='login-link']//span[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='login-with-google']//a[@id='login-google-link']")).click();
				
	}
	
	public void enterUsername() throws InterruptedException {
		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='Xb9hP']/input[@type='email']")).sendKeys("thupatidileep@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='identifierNext']//span[@class='VfPpkd-vQzf8d']")).click();
		
	}
	
	public void enterPassword() {
		
	}

}
