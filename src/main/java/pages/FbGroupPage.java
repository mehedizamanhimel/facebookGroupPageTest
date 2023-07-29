package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbGroupPage {

    WebDriver driver;

    public FbGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="xpath of like button")
    public WebElement button_Like;

    @FindBy(xpath="xpath of report button")
    public WebElement TextField_Post;

    @FindBy(xpath="xpath of comment field")
    public WebElement TextField_Comment;

    @FindBy(xpath="xpath of messages ")
    public WebElement TextField_ActionMessages;



    //Writing a single method instead of repeatative code to cofirm if a webelement is displayed
    //
    public void Verify_button_available(WebElement element){
        element.isDisplayed();
    }

    public boolean button_clicked(WebElement element){

        element.click();

        if(element.isSelected()==true){
            return true;
        }
        return false;
    }


    public void Type_Comment( WebElement element, String commentData){
        element.sendKeys(commentData);
    }

    public String returnText(){
        return TextField_ActionMessages.getText();
    }

}
