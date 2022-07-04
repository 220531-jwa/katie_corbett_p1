package dev.corbett.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeUpdatePage {
    private WebDriver driver;

    public EmployeeUpdatePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "rid")
    public WebElement eUpdateRequestID;

    @FindBy(id = "uid")
    public WebElement eUpdateUserID;

    @FindBy(id = "grade")
    public WebElement eUpdateGrade;

    @FindBy(id = "gradeSubmit")
    public WebElement eUpdateGradeButton;

    @FindBy(id = "changeConfirm")
    public WebElement eUpdateChangeConf;
}
