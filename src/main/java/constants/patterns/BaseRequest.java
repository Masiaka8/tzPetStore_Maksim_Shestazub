package constants.patterns;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class BaseRequest {

    public static ValidatableResponse createPostRequestAndTakeResponse(Object body, String endpoint, int statusCode) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(statusCode)
                .log().all();
    }

    public static ValidatableResponse createPutRequestAndTakeResponse(Object body, String endpoint, int statusCode) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .assertThat().statusCode(statusCode)
                .log().all();
    }

    public static ValidatableResponse createGetRequestAndTakeResponse(String endpoint, int statusCode) {
        return given()
                .contentType("application/json")
                .when()
                .get(endpoint)
                .then()
                .assertThat().statusCode(statusCode)
                .log().all();
    }
}
