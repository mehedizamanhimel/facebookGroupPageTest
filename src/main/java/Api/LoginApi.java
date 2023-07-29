package Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginApi {

    Response response;

    // added this api considering that the login api is a REST based get api
    public void loginApi(String username, String pass){
        RestAssured.baseURI="https://www.facebook.com";
        RestAssured.basePath="/login";

        response = RestAssured.given()
                .queryParam("username", username)
                .queryParam("pass", pass)
                .when()
                .log()
                .all()
                .get();

        response.then()
                .assertThat()
                .statusCode(200);

        response.prettyPrint();
    }


    //added a method to capture the token upon a successful login of regular user, not admin user
    public String returnToken(){
        return response.jsonPath().get("token");
    }
}
