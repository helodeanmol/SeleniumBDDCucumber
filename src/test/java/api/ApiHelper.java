package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiHelper {
    public Response getUser(String userId) {
        return RestAssured.given()
                .baseUri("https://api.example.com")
                .when()
                .get("/users/" + userId);
    }
}