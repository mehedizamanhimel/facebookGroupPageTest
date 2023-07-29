import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FbGroupAdminPage;
import pages.FbLoginPage;

public class Test_PostInteractions extends BaseTestClass{

    FbGroupAdminPage adminPage;
    FbLoginPage loginPage;
    String baseurl = "https://www.facebook.com";
    String AdminUsername = "TestAdmin";
    String AdminPass= "TestAdmin@123";



    @BeforeClass
    public void beforeClass(){
        loginPage = new FbLoginPage(driver);

        driver.get(baseurl);
        //login to facebook page, here we've used a single method for both typing username and password by passing the arguments as seperate web element
        loginPage.typeOneElement(AdminUsername, loginPage.textField_username);
        loginPage.typeOneElement(AdminPass, loginPage.textField_password);

        loginPage.ClickOnElement(loginPage.button_login);

        //Verify that user is login successfully
        Assert.assertEquals(loginPage.returnResult() , "User is logged in Successfully");

    }

    //For the cases below, I've used single function based behavior like "typing", "clicking" & "verifying" by passing different webelement and string values as argument



}
