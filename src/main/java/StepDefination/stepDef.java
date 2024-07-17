package StepDefination;
import POM.busType;
import POM.homePage;
import POM.operator;
import POM.resultsPage;
import com.itextpdf.text.log.SysoCounter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementClickInterceptedException;

import static StepDefination.hooks.driver;
import static com.github.mkolisnyk.cucumber.assertions.LazyAssert.assertEquals;

public class stepDef {

//    String operators = String.valueOf(operator.valueOf("BUS"));
    homePage Home = new homePage(driver);
    resultsPage results = new resultsPage(driver);
    @Given("user enter the AbhiBus Website")
    public void user_enter_the_abhi_bus_website() {
        System.out.println(this);
    }
//    @When("user select the {} type")
//    public void userSelectTheType(String Operator) throws InterruptedException {
//        Thread.sleep(3000);
//       String Opertators = Home.ClickOnOperator(Operator).toString();
//        System.out.println("Operator :: " +Operator);
//    }
    @When("user select the Operator type")
    public void userSelectTheTypeOperator() throws InterruptedException {
        Thread.sleep(3000);
       Home.ClickOnOperator(operator.valueOf("Bus"));
    }
//    @Then("user enter the {} and {}")
//    public void user_enter_the_{}_and_{}() throws InterruptedException {
//        Thread.sleep(3000);
//        Home.enterFromCity().enterToCity().pickJourneydate();
//    }
    @Then("Click on the search")
    public void click_on_the_search() {
        Home.clickonSearch();
    }
    @Then("User select the BusType")
    public void user_select_the_bus_type() {
        results.selectBusType(busType.AC);
    }
    @Then("User select the Bus from the list and select the seat")
    public void user_select_the_bus_from_the_list_and_select_the_seat() throws InterruptedException {

           results.selectBus().selectSeat().selectPickUpLoc().selectdroppoint();

    }
    @Then("user enter the {string} and {string}")
    public void user_Enter_The_From_Station_And_To_Station(String value, String value1) throws InterruptedException {
        Thread.sleep(3000);
        Home.enterFromCity().enterToCity().pickJourneydate();
    }
}
