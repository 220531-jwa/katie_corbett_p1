package steps;

import SeleniumRunners.SeleniumRunner;
import dev.corbett.pages.FinanceMgrChangePage;
import dev.corbett.pages.FinanceMgrUpdatePage;
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

public class FinanceMgrChangeStatusSteps {
    private WebDriver driver = SeleniumRunner.driver;

    private FinanceMgrChangePage financeMgrChangePage = SeleniumRunner.financeMgrChangePage;
    @Given("a Finance Manager is on the Change Request Status page")
    public void a_finance_manager_is_on_the_change_request_status_page() {
        driver.get("http://localhost:8080/fmgrChangeRequest.html");
    }
    @When("the Finance Manager enters the {string}, {string}, and {string} and clicks the submit button")
    public void the_finance_manager_enters_the_and_and_clicks_the_submit_button(String requestid, String userid, String status) {
        financeMgrChangePage.fmChangeReqId.sendKeys("2");
        financeMgrChangePage.fmChangeEmpId.sendKeys("2");
        financeMgrChangePage.fmChangeStatus.sendKeys("5");
        financeMgrChangePage.fmChangeStatusButton.click();
    }
    @Then("the Finance Manager sees a message of Success")
    public void the_finance_manager_sees_a_message_of_success() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(financeMgrChangePage.fmChangeChangeConf));
        WebElement successMessageDisp = driver.findElement(By.id("changeConfirm"));
        assertEquals(true, successMessageDisp.isDisplayed());
    }
}
