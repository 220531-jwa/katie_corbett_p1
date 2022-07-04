package dev.corbett.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinanceMgrHomepage {
    private WebDriver driver;

    public FinanceMgrHomepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "fmView")
    public WebElement fmViewLink;

    @FindBy(id = "fmChange")
    public WebElement fmChangeLink;

    @FindBy(id = "fmUpdate")
    public WebElement fmUpdateLink;
}
