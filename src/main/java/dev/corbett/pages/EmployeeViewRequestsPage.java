package dev.corbett.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeViewRequestsPage {
    private WebDriver driver;

    public EmployeeViewRequestsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "view")
    public WebElement eViewButton;

    @FindBy(id = "requestsTable")
    public WebElement eRequestsViewTable;

}
