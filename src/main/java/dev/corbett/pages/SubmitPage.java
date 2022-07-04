package dev.corbett.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitPage {
    private WebDriver driver;

    public SubmitPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "uid")
    public WebElement eSubmitUid;

    @FindBy(id = "fname")
    public WebElement eSubmitFname;

    @FindBy(id = "lname")
    public WebElement eSubmitLname;

    @FindBy(id = "date")
    public WebElement eSubmitDate;

    @FindBy(id = "time")
    public WebElement eSubmitTime;

    @FindBy(id = "training")
    public WebElement eSubmitTraining;

    @FindBy(id = "desc")
    public WebElement eSubmitDesc;

    @FindBy(id = "cost")
    public WebElement eSubmitCost;

    @FindBy(id = "justify")
    public WebElement eSubmitJustify;

    @FindBy(id = "grade")
    public WebElement eSubmitGrade;

    @FindBy(id = "submitRequest")
    public WebElement eSubmitRequestButton;

    @FindBy(id = "changeConfirm")
    public WebElement eSubmitChangeConf;
}
