package steps;

import SeleniumRunners.SeleniumRunner;
import dev.corbett.pages.FinanceMgrChangePage;
import dev.corbett.pages.FinanceMgrUpdatePage;
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

public class FinanceMgrChangeReimburseAmtSteps {
    private WebDriver driver = SeleniumRunner.driver;

    private FinanceMgrUpdatePage financeMgrUpdatePage = SeleniumRunner.financeMgrUpdatePage;
    @Given("a Finance Manager is on the Update Reimbursement Amount page")
    public void a_finance_manager_is_on_the_update_reimbursement_amount_page() {
        driver.get("http://localhost:8080/fmgrUpdateRequest.html");
    }
    @When("the Finance Manager enters the {string}, {string}, and {string} and clicks submit")
    public void the_finance_manager_enters_the_and_and_clicks_submit(String requestid, String userid, String amount) {
        financeMgrUpdatePage.fmUpdateReqId.sendKeys("4");
        financeMgrUpdatePage.fmUpdateEmpId.sendKeys("3");
        financeMgrUpdatePage.fmUpdateAmt.sendKeys("2700");
        financeMgrUpdatePage.fmUpdateButton.click();
    }
    @Then("the Finance Manager sees the Success message")
    public void the_finance_manager_sees_the_success_message() {

    }
}

