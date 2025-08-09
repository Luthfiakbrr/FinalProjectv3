package api.helpers;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiHelper {
    public static final String APP_ID = "63a804408eb0cb069b57e43a";

    static {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
    }

    public static RequestSpecification givenAuth(){
        return RestAssured.given().header("app-id", APP_ID).contentType("application/json");
    }
}
