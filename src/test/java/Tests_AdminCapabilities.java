import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FbGroupAdminPage;
import pages.FbGroupPage;
import pages.FbLoginPage;
import utils.TestData;

public class Tests_AdminCapabilities extends BaseTestClass{


    FbGroupAdminPage adminPage;
    FbLoginPage loginPage;
    String baseurl = "https://www.facebook.com";
    String AdminUsername = "TestAdmin";
    String AdminPass= "TestAdmin@123";

    ExtentTest logger;

    @BeforeClass
    public void startTest(){
        loginPage = new FbLoginPage(driver);

        driver.get(baseurl);
        //login to facebook page, here we've used a single method for both typing username and password by passing the arguments as seperate web element
        loginPage.typeOneElement(AdminUsername, loginPage.textField_username);
        loginPage.typeOneElement(AdminPass, loginPage.textField_password);

        loginPage.ClickOnElement(loginPage.button_login);
        logger = extent.startTest("The first test of flink has started");
        //Verify that user is login successfully
        Assert.assertEquals(loginPage.returnResult() , "User is logged in Successfully");

    }

    //For the cases below, I've used single function based behavior like "typing", "clicking" & "verifying" by passing different webelement and string values as argument

    @Test(priority = 0, description = "Verify that admin can see pending posts successfully")
    public void Vreify_Admin_See_Pending_Posts(){
        adminPage = new FbGroupAdminPage(driver);

        driver.get("https://www.facebook.com/sampleGroupPage");
        //
        adminPage.verify_pendingPost_available();

        logger = extent.startTest("The test session has started");

    }


    @Test(priority = 1, description = "Verify that admin can see pending member approval successfully")
    public void Vreify_Admin_See_Pending_MemberApproval(){
        adminPage = new FbGroupAdminPage(driver);

        adminPage.verify_pendingMemberShipList_available();

        logger.log(LogStatus.PASS , "Admin see pending member approval");

    }

    @Test(priority = 2, description = "Verify that admin can approve a member successfully")
    public void Vreify_Admin_MemberApproval(){
        adminPage = new FbGroupAdminPage(driver);

        adminPage.Verify_button_click(adminPage.button_Approve_Member);
        Assert.assertEquals(adminPage.returnUserMessage_MemberAcceptDecline(),"member approved successfully");

        logger.log(LogStatus.PASS , "Admin approved member approval");

    }

    @Test(priority = 3, description = "Verify that admin can approve a post successfully")
    public void Vreify_Admin_PostApproval(){
        adminPage = new FbGroupAdminPage(driver);

        adminPage.Verify_button_click(adminPage.button_Approve_Post);
        Assert.assertEquals(adminPage.returnUserMessage_MemberAcceptDecline(),"post approved successfully");
        logger.log(LogStatus.PASS , "Admin approved a post");
    }

    @Test(priority = 4, description = "Verify that admin can pre approve a member post successfully")
    public void Vreify_Admin_Preapprove_MemberApproval(){
        adminPage = new FbGroupAdminPage(driver);

        adminPage.Verify_button_click(adminPage.button_Approve_Member);
        adminPage.Verify_button_click(adminPage.button_PreApprove_Post);

        Assert.assertEquals(adminPage.returnUserMessage_MemberAcceptDecline(),"member pre approved successfully");

        logger.log(LogStatus.PASS , "Admin pre approved a member");
    }

    @Test(priority = 5, description = "Verify that admin can decline a member successfully successfully")
    public void Vreify_Admin_Decline_MemberApproval(){
        adminPage = new FbGroupAdminPage(driver);

        adminPage.Verify_button_click(adminPage.button_DeclineMember);
        Assert.assertEquals(adminPage.returnUserMessage_MemberAcceptDecline(),"member request decline successfully");

        logger.log(LogStatus.PASS , "Admin decline a member approval");
    }

    @Test(priority = 6, description = "Verify that admin can ban a member")
    public void Vreify_Admin_Can_Ban_Member(){
        adminPage = new FbGroupAdminPage(driver);

        adminPage.Verify_button_click(adminPage.button_BanUser);
        Assert.assertEquals(adminPage.returnUserMessage_MemberAcceptDecline(),"member banned successfully");
        logger.log(LogStatus.PASS , "Admin decline member approval");

    }

    @Test(priority = 7, description = "Verify that admin can approve all member request successfully")
    public void Vreify_Admin_Can_ApproveAll_member_request(){
        adminPage = new FbGroupAdminPage(driver);

        adminPage.Verify_button_click(adminPage.button_ApproveAllMember);
        Assert.assertEquals(adminPage.returnUserMessage_MemberAcceptDecline(),"All member approved successfully");
        logger.log(LogStatus.PASS , "Admin approved all member");
    }

    @Test(priority = 8, description = "Verify that admin can approve all post request successfully")
    public void Vreify_Admin_Can_ApproveAll_post_request(){
        adminPage = new FbGroupAdminPage(driver);

        adminPage.Verify_button_click(adminPage.button_ApproveAllPost);
        Assert.assertEquals(adminPage.returnUserMessage_MemberAcceptDecline(),"All post approved successfully");
        logger.log(LogStatus.PASS , "Admin approved all post");
    }

    @Test(priority = 9, description = "Verify that admin can decline all member request once successfully")
    public void Vreify_Admin_Can_DeclineAll_member_request(){
        adminPage = new FbGroupAdminPage(driver);

        adminPage.Verify_button_click(adminPage.button_DeclineAllMember);
        Assert.assertEquals(adminPage.returnUserMessage_MemberAcceptDecline(),"All member request declined successfully");
        logger.log(LogStatus.PASS , "Admin declined all member");
    }

    @Test(priority = 10, description = "Verify that admin can decline all post at once successfully")
    public void Vreify_Admin_Can_DeclineAll_post_request(){
        adminPage = new FbGroupAdminPage(driver);

        adminPage.Verify_button_click(adminPage.button_DeclineAllPost);
        Assert.assertEquals(adminPage.returnUserMessage_MemberAcceptDecline(),"All post request declined successfully");
        logger.log(LogStatus.PASS , "Admin declined all post");
    }

    @Test(priority = 11, description = "Verify that admin can delete a post successfully")
    public void Vreify_Admin_Can_delete_post(){
        adminPage = new FbGroupAdminPage(driver);

        adminPage.Verify_button_click(adminPage.button_DeletePost);
        Assert.assertEquals(adminPage.returnUserMessage_MemberAcceptDecline(),"post has been deleted successfully");
        Assert.assertEquals(adminPage.returnUserMessage_MemberAcceptDecline(),"post has been deleted successfully");
        logger.log(LogStatus.PASS , "Admin deleted a post");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
        logger.log(LogStatus.INFO , "Admin related Test suit run complete");
    }




}
