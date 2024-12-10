package testes_api.config;

import io.qameta.allure.Epic;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import testes_api.utils.ConfigUtil;

public abstract class ApiTestBase {

    @Epic("API Tests")
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = ConfigUtil.get("baseUrl");
    }
}
