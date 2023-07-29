package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPage {
    WebDriver driver;

    public FbLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath="xpath of username")
    public WebElement textField_username;

    @FindBy(xpath="xpath of password")
    public WebElement textField_password;

    @FindBy(xpath="xpath of login button")
    public WebElement button_login;

    @FindBy(xpath="xpath of password forgot button")
    public WebElement button_Forgotpass;

    @FindBy(xpath="xpath of password forgot button")
    public WebElement text_LoginAction;

    public void typeOneElement(String data,  WebElement element){
        element.sendKeys(data);
    }

    public void ClickOnElement(WebElement element){
        element.click();
    }

    public String returnResult(){
        return text_LoginAction.getText();
    }


}
