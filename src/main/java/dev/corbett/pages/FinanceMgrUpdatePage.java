package dev.corbett.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinanceMgrUpdatePage {
    private WebDriver driver;

    public FinanceMgrUpdatePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "rid")
    public WebElement fmUpdateReqId;

    @FindBy(id = "uid")
    public WebElement fmUpdateEmpId;

    @FindBy(id = "amt")
    public WebElement fmUpdateAmt;

    @FindBy(id = "change")
    public WebElement fmUpdateButton;

    @FindBy(id = "changeConfirm")
    public WebElement fmUpdateChangeConf;
}
