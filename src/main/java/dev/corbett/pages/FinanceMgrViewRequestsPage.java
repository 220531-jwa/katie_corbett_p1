package dev.corbett.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinanceMgrViewRequestsPage {
    private WebDriver driver;

    public FinanceMgrViewRequestsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "view")
    public WebElement fmViewReqButton;

    @FindBy(id = "requestsTable")
    public WebElement fmRequestsTable;
}
