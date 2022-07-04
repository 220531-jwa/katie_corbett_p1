package dev.corbett.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinanceMgrChangePage {
    private WebDriver driver;

    public FinanceMgrChangePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "rid")
    public WebElement fmChangeReqId;

    @FindBy(id = "uid")
    public WebElement fmChangeEmpId;

    @FindBy(id = "num")
    public WebElement fmChangeStatus;

    @FindBy(id = "changeStatus")
    public WebElement fmChangeStatusButton;

    @FindBy(id = "changeConfirm")
    public WebElement fmChangeChangeConf;
}
