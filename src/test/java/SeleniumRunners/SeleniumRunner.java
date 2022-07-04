package SeleniumRunners;

import dev.corbett.pages.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

@Suite
@Tag("CucumberTests")
@IncludeTags("CucumberTests")
public class SeleniumRunner {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static EmployeeHomepage employeeHomepage;
    public static EmployeeViewRequestsPage employeeViewRequestsPage;
    public static EmployeeUpdatePage employeeUpdatePage;
    public static FinanceMgrChangePage financeMgrChangePage;
    public static FinanceMgrUpdatePage financeMgrUpdatePage;
    public static FinanceMgrViewRequestsPage financeMgrViewRequestsPage;
    public static SubmitPage submitPage;

    public static FinanceMgrHomepage financeMgrHomepage;

    @BeforeAll
    public static void setup(){
        File chrome = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        employeeHomepage = new EmployeeHomepage(driver);
        employeeViewRequestsPage = new EmployeeViewRequestsPage(driver);
        employeeUpdatePage = new EmployeeUpdatePage(driver);
        financeMgrChangePage = new FinanceMgrChangePage(driver);
        financeMgrUpdatePage = new FinanceMgrUpdatePage(driver);
        financeMgrViewRequestsPage = new FinanceMgrViewRequestsPage(driver);
        submitPage = new SubmitPage(driver);
        financeMgrHomepage = new FinanceMgrHomepage(driver);
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }
}
