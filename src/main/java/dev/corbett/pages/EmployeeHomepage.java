package dev.corbett.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeHomepage {
    private WebDriver driver;

    public EmployeeHomepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "viewRequest")
    public WebElement eViewRequestLink;

    @FindBy(id = "submitRequest")
    public WebElement eSubmitRequestLink;

    @FindBy(id = "updateRequest")
    public WebElement eUpdateRequestLink;
}
