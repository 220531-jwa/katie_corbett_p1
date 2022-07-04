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

public class EmployeeLoginSteps {
    private WebDriver driver = SeleniumRunner.driver;
    private LoginPage loginPage = SeleniumRunner.loginPage;
    @Given("an Employee is on the login page")
    public void an_employee_is_on_the_login_page() {
        driver.get("http://localhost:8080/login.html");
    }
    @When("the Employee types in their {string} and {string} and clicks the Login button")
    public void the_employee_types_in_their_and_and_clicks_the_login_button(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }
    @Then("the Employee should be on the Employee Homepage")
    public void the_employee_should_be_on_the_employee_homepage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("ERS Employee Homepage"));
        assertEquals("ERS Employee Homepage", driver.getTitle());
    }
}
