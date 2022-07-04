package steps;

import SeleniumRunners.SeleniumRunner;
import dev.corbett.pages.FinanceMgrHomepage;
import dev.corbett.pages.FinanceMgrViewRequestsPage;
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

public class FinanceMgrViewRequestsSteps {
    private WebDriver driver = SeleniumRunner.driver;

    private FinanceMgrViewRequestsPage financeMgrViewRequestsPage = SeleniumRunner.financeMgrViewRequestsPage;
    @Given("a Finance Manager is on the Finance Manager View Requests page")
    public void a_finance_manager_is_on_the_finance_manager_view_requests_page() {
        driver.get("http://localhost:8080/fmgrViewRequests.html");
    }
    @When("the Finance Manager clicks on the View Requests button")
    public void the_finance_manager_clicks_on_the_view_requests_button() {
        financeMgrViewRequestsPage.fmViewReqButton.click();
    }
    @Then("the Finance Manager can see all requests that have been submitted")
    public void the_finance_manager_can_see_all_requests_that_have_been_submitted() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(financeMgrViewRequestsPage.fmRequestsTable));
        WebElement displayedTable = driver.findElement(By.id("requestsTable"));
        assertEquals(true, displayedTable.isDisplayed());
    }
}
