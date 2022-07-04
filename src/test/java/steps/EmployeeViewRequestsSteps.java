package steps;

import SeleniumRunners.SeleniumRunner;
import dev.corbett.pages.EmployeeViewRequestsPage;
import dev.corbett.pages.LoginPage;
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

public class EmployeeViewRequestsSteps {
    private WebDriver driver = SeleniumRunner.driver;
    private EmployeeViewRequestsPage employeeViewRequestsPage = SeleniumRunner.employeeViewRequestsPage;
    @Given("an Employee is on the View Requests page")
    public void an_employee_is_on_the_View_Requests_page() {
        driver.get("http://localhost:8080/requests.html");
    }
    @When("the Employee clicks on the View Requests button")
    public void the_employee_clicks_on_the_View_Requests_button() {
        employeeViewRequestsPage.eViewButton.click();
    }
    @Then("the Employee can see all requests they have submitted")
    public void the_employee_can_see_all_requests_they_have_submitted() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(employeeViewRequestsPage.eRequestsViewTable));
        WebElement displayedTable = driver.findElement(By.id("requestsTable"));
        assertEquals(true, displayedTable.isDisplayed());
    }
}
