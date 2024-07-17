package StepDefination;
import POM.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import static StepDefination.hooks.driver;

public class stepDefination{

	String operators;
	loginPage LoginPage = new loginPage();
	homePage home = new homePage(driver);
	resultsPage resultPage = new resultsPage(driver);

	
	@Given("I want to open the AbhiBus Website")
	public void i_want_to_open_the_abhi_bus_website() throws Exception {
		
		System.out.println("Passed the test");
	}

	@And("user login the abhibus website with {string} and {string} credentials")
	public void user_login_the_abhibus_website_with_and_credentials(String Bangalore, String chennai) throws InterruptedException {
	   
//		LoginPage.clickOnSignLinks();
//		LoginPage.enterUsername();
	}

	@And("user enter the from city and distination city")
	public void user_enter_the_from_city_and_distination_city() throws InterruptedException {
		 Thread.sleep(3000); 
			home.enterFromCity()
					.enterToCity()
					.pickJourneydate()
					.clickonSearch();
			
//		 HomePage.enterToCity();
//		 Thread.sleep(5000);
//		 HomePage.pickJourneydate();
		 
	}

	@And("user enter the date of journey")
	public void user_enter_the_date__of_journey() {
	    
	}

	@And("user click on the search button")
	public void user_click_on_the_search_button() {
	    
		home.clickonSearch();
	}

	@And("user will see the buss list and choose what you want")
	public void user_will_see_the_buss_list_and_choose_what_you_want() throws InterruptedException {
		resultPage.selectBusType(busType.SLEEPER);
		Thread.sleep(3000);
		resultPage.selectBus().selectSeat().selectPickUpLoc().selectdroppoint();
	}

	@And("user will pick the seat")
	public void user_will_pick_the_seat() throws InterruptedException {
//		resultPage.selectBusType(busType.SLEEPER);
//	    resultPage.selectSeat();
//	    resultPage.selectPickUpLoc();
//	    Thread.sleep(3000);
//	    resultPage.selectdroppoint();
	}
	
	@Given("Open the AbhiBus train booking website")
	public void open_the_abhi_bus_train_booking_website() throws Exception {
	 
	   Thread.sleep(2000);
	   home.ClickOnOperator(operator.Train);
	   
	}

	@And("user enter the <from station> and <to station>")
	public void user_enter_the_from_station_and_to_station() throws InterruptedException {
	    Thread.sleep(2000);
		home.fromTrainStation();
	    home.ToTrainStation();

	}
	

	@And("user select the date")
	public void user_select_the_date() throws InterruptedException {
	   home.selectDate();
	}

	@And("click on the search button")
	public void click_on_the_search_button() {
	    home.clickOnSearch();
	}

	@And("select the train in the list")
	public void select_the_train_in_the_list() {
	    
	}

}
