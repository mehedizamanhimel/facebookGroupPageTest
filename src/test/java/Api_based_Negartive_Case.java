import Api.FBPostCommentApi;
import Api.LoginApi;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Api_based_Negartive_Case {

    LoginApi loginApi = new LoginApi();
    FBPostCommentApi fbpostcomment = new FBPostCommentApi();

    String username_mutedUser= "mmm";
    String password_mutedUser= "mmm";

    String username_BannedUser= "nnn";
    String password_BannedUser= "nnn";

    String facebookPostComment = "this is a sample post or comment data";

    @Test (priority = 0, description = "Verify that banned user cannot make a post by bypass the UI and use api token")
    public void Verify_BannedUser_cannot_Post_Comment(){

        // firing login api with banned user's credential and generate token
        loginApi.loginApi(username_BannedUser, password_BannedUser);

        String token = loginApi.returnToken();

        // try to make a post by firing the facebook post api with banned user's token, and verifying the statuscode returned 401
        fbpostcomment.Post_Comment_Api(token, facebookPostComment,401);

        Assert.assertEquals(fbpostcomment.returnData(),"Sorry you are not authorized to create a post");

    }


    @Test (priority = 0, description = "Verify that banned user cannot make a post by bypass the UI and use api token")
    public void Verify_Muted_User_cannot_Post_Comment(){

        // firing login api with muted user's credential and generate token
        loginApi.loginApi(username_mutedUser, password_mutedUser);


        String token = loginApi.returnToken();

        // try to make a post by firing the facebook post api with muted user's token, and verifying the statuscode returned 401
        fbpostcomment.Post_Comment_Api(token, facebookPostComment,401);

        Assert.assertEquals(fbpostcomment.returnData(),"Sorry you are not authorized to create a comment");

    }



}
