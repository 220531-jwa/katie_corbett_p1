package steps;

import SeleniumRunners.SeleniumRunner;
import dev.corbett.pages.EmployeeUpdatePage;
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

public class EmployeeChangeGradeSteps {
    private WebDriver driver = SeleniumRunner.driver;
    private EmployeeUpdatePage employeeUpdatePage = SeleniumRunner.employeeUpdatePage;
    @Given("an Employee is on the Update Request page")
    public void an_employee_is_on_the_update_request_page() {
        driver.get("http://localhost:8080/addGrade.html");
    }
    @When("the Employee enters their {string} and their {string} and their {string} and clicks Submit Changes")
    public void the_employee_enters_their_and_their_and_their_and_clicks_submit_changes(String requestid, String userid, String proof) {
        employeeUpdatePage.eUpdateRequestID.sendKeys("2");
        employeeUpdatePage.eUpdateUserID.sendKeys("2");
        employeeUpdatePage.eUpdateGrade.sendKeys("Pass");
        employeeUpdatePage.eUpdateGradeButton.click();
    }
    @Then("the Employee sees the Success message")
    public void the_employee_sees_the_success_message() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(employeeUpdatePage.eUpdateChangeConf));
        WebElement successMessageDisp = driver.findElement(By.id("changeConfirm"));
        assertEquals(true, successMessageDisp.isDisplayed());
    }
}
