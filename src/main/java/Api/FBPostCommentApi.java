package Api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FBPostCommentApi {

    Response response;


    // added this api considering that the login api is a REST based post api
    public void Post_Comment_Api(String token, String facebookPostData, int ResponseCode){
        RestAssured.baseURI="https://www.facebook.com";
        RestAssured.basePath="/post";

        response = RestAssured.given()
                .queryParam("token", token)
                .body(facebookPostData)
                .get();

        response.then()
                .assertThat()
                .statusCode(ResponseCode);

        response.prettyPrint();
    }


    //added a method to capture the token upon a successful login of regular user, not admin user
    public String returnData(){
        return response.jsonPath().get("statusmessage");
    }

}
