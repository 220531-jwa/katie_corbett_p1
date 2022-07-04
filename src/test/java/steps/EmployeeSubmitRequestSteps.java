package steps;

import SeleniumRunners.SeleniumRunner;
import dev.corbett.pages.EmployeeViewRequestsPage;
import dev.corbett.pages.SubmitPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeSubmitRequestSteps {
    private WebDriver driver = SeleniumRunner.driver;
    private SubmitPage submitPage = SeleniumRunner.submitPage;
    @Given("an Employee is on the Submit Requests page")
    public void an_employee_is_on_the_submit_requests_page() {
        driver.get("http://localhost:8080/submit.html");
    }
    @When("the Employee enters their {string} and their {string} and their {string} and their {string} and their {string} and their {string} and their {string} and their {string} and their {string} and their {string} and clicks the Submit button")
    public void the_employee_enters_their_and_their_and_their_and_their_and_their_and_their_and_their_and_their_and_their_and_their_and_clicks_the_submit_button(String userid, String firstname, String lastname, String date, String time, String type, String description, String cost, String justification, String gradetype) {
        submitPage.eSubmitUid.sendKeys("4");
        submitPage.eSubmitFname.sendKeys("Fjord");
        submitPage.eSubmitLname.sendKeys("Stone");
        submitPage.eSubmitDate.sendKeys("07/03/2022");
        submitPage.eSubmitTime.sendKeys("3:44 PM");
        submitPage.eSubmitTraining.sendKeys("2");
        submitPage.eSubmitDesc.sendKeys("Wildmother Meditation with Caduceus");
        submitPage.eSubmitCost.sendKeys("50");
        submitPage.eSubmitJustify.sendKeys("To become a better paladin");
        submitPage.eSubmitGrade.sendKeys("1");
        submitPage.eSubmitRequestButton.click();
    }
    @Then("the Employee should see the Successful Submit message")
    public void the_employee_should_see_the_Successful_Submit_message() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(submitPage.eSubmitChangeConf));
        WebElement successMessageDisp = driver.findElement(By.id("changeConfirm"));
        assertEquals(true, successMessageDisp.isDisplayed());
    }
}
