package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FbGroupAdminPage {

    WebDriver driver;

    public FbGroupAdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "xpath for list of post approval")
    public List<WebElement> post_waitingForapproval;

    @FindBy(xpath = "xpath for list of user approval")
    public List<WebElement> member_waitingForapproval;

    @FindBy(xpath="xpath of Approve button")
    public WebElement button_Approve_Member;

    @FindBy(xpath="xpath of ApproveAll button")
    public WebElement button_ApproveAllMember;

    @FindBy(xpath="xpath of Decline button")
    public WebElement button_DeclineMember;

    @FindBy(xpath="xpath of DeclineAll button")
    public WebElement button_DeclineAllMember;

    @FindBy(xpath="xpath of Approve button")
    public WebElement button_Approve_Post;

    @FindBy(xpath="xpath of Pre Approve button")
    public WebElement button_PreApprove_Post;

    @FindBy(xpath="xpath of ApproveAll button")
    public WebElement button_ApproveAllPost;

    @FindBy(xpath="xpath of DeclineAll button")
    public WebElement button_DeclineAllPost;

    @FindBy(xpath="xpath of BanUser button")
    public WebElement button_BanUser;

    @FindBy(xpath="xpath of delete post button")
    public WebElement button_DeletePost;

    @FindBy(xpath="xpath of text result once a post is being approved or declined")
    public WebElement text_PostActions;

    @FindBy(xpath="xpath of text result once a member request is being approved or declined")
    public WebElement text_UserActions;


    //Writing a single method instead of repeatative code to cofirm if a webelement is displayed
    //
    public void Verify_button_available(WebElement element){
        element.isDisplayed();
    }

    //Writing a single method instead of repeatative code to cofirm if a webelement is displayed
    //
    public void Verify_button_click(WebElement element){
        element.isDisplayed();
    }

    public void verify_pendingPost_available(){
        for (int i =0 ; i < post_waitingForapproval.size();i++){
            post_waitingForapproval.get(i).isDisplayed();
        }
    }

    public void verify_pendingMemberShipList_available(){
        for (int i =0 ; i < member_waitingForapproval.size();i++){
            member_waitingForapproval.get(i).isDisplayed();
        }
    }

    public String returnUserMessage_PostAcceptDecline(){
        return text_PostActions.getText();
    }
    public String returnUserMessage_MemberAcceptDecline(){
        return text_UserActions.getText();
    }

}
