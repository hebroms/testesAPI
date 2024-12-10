package testes_api.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiHelper {

    public static Response post(String endpoint, String body) {
        return RestAssured
                .given()
                    .header("Content-Type", "application/json")
                .when()
                    .body(body)
                    .post(endpoint);
    }

    public static Response post(String endpoint, Object body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when()
                .body(body)
                .post(endpoint);
    }
}

