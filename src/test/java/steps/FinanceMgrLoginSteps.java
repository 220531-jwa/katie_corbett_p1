package steps;

import SeleniumRunners.SeleniumRunner;
import dev.corbett.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinanceMgrLoginSteps {
    private WebDriver driver = SeleniumRunner.driver;
    private LoginPage loginPage = SeleniumRunner.loginPage;
    @Given("a Finance Manager is on the login page")
    public void a_finance_manager_is_on_the_login_page() {
        driver.get("http://localhost:8080/login.html");
    }
    @When("the Finance Manager types in their {string} and {string} and clicks the Login button")
    public void the_finance_manager_types_in_their_and_and_clicks_the_login_button(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }
    @Then("the Finance Manager should be on the Finance Manager Homepage")
    public void the_finance_manager_should_be_on_the_finance_manager_homepage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("ERS Finance Manager Homepage"));
        assertEquals("ERS Finance Manager Homepage", driver.getTitle());
    }
}
