import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FbGroupAdminPage;
import pages.FbGroupPage;
import pages.FbLoginPage;

public class Test_NonAdminCapabilities extends BaseTestClass{

    FbGroupPage groupPage;
    FbLoginPage loginPage;
    String baseurl = "https://www.facebook.com";
    String RegularUser_Username = "TestUser";
    String RegularUser_Pass= "TestUser@123";

    @BeforeClass
    public void beforeClass(){
        loginPage = new FbLoginPage(driver);

        driver.get(baseurl);
        //login to facebook page, here we've used a single method for both typing username and password by passing the arguments as seperate web element
        loginPage.typeOneElement(RegularUser_Username, loginPage.textField_username);
        loginPage.typeOneElement(RegularUser_Pass, loginPage.textField_password);

        loginPage.ClickOnElement(loginPage.button_login);

        //Verify that user is login successfully
        Assert.assertEquals(loginPage.returnResult() , "User is logged in Successfully");

    }

    //For the cases below, I've used single function based behavior like "typing", "clicking" & "verifying" by passing different webelement and string values as argument

    @Test(priority = 0, description = "Verify that regular user can make a post successfully")
    public void verify_user_Can_Post_Successfully(){
        groupPage = new FbGroupPage(driver);

        groupPage.Type_Comment(groupPage.TextField_Post,"Sample String to type in the post");

        Assert.assertEquals(groupPage.TextField_ActionMessages,"your post has been successfully submitted and sent for admin approval");

    }

    @Test(priority = 1, description = "Verify that regular user can make a comment successfully")
    public void verify_user_Can_Comment_Successfully(){
        groupPage = new FbGroupPage(driver);

        groupPage.Type_Comment(groupPage.TextField_Comment,"Sample String to type in the comment");

        Assert.assertEquals(groupPage.TextField_ActionMessages,"your comment has been successfully submitted and sent for admin approval");


    }

    @Test(priority = 2, description = "Verify that regular user can react to a post successfully ")
    public void verify_user_Can_React_Successfully(){
        groupPage = new FbGroupPage(driver);

        groupPage.button_clicked(groupPage.button_Like);

        Assert.assertEquals(groupPage.button_clicked(groupPage.button_Like), true);

    }

    @Test(priority = 3, description = "Verify that muted user is getting mute notification for post and comment")
    public void verify_user_Can_EditPost_Successfully(){
        groupPage = new FbGroupPage(driver);

        groupPage.Type_Comment(groupPage.TextField_Post,"Sample String to type in the post");

        Assert.assertEquals(groupPage.TextField_ActionMessages,"Sorry, you cannot make any post right now");

        groupPage.Type_Comment(groupPage.TextField_Comment,"Sample String to type in the comment");

        Assert.assertEquals(groupPage.TextField_ActionMessages,"Sorry, you cannot make any comment right now");


    }


}
