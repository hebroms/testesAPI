package testes_api.utils;

import com.github.javafaker.Faker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GeneretePostsUtil {

    static Faker faker = new Faker();

    public static void generatePost() throws IOException {

        Map<String, Object> newData = new HashMap<>();
        newData.put("title", faker.lorem().word());
        newData.put("body", faker.lorem().paragraph());
        newData.put("userId", faker.number().randomDigit());

        // Escrever em um novo arquivo JSON
        JsonUtil.writeJson(ConfigUtil.get("requestBodyPath"), newData);
    }

    public static void generatePartialPost() throws IOException {

        Map<String, Object> newData = new HashMap<>();
        newData.put("title", faker.lorem().word());
        newData.put("userId", faker.number().randomDigit());

        // Escrever em um novo arquivo JSON
        JsonUtil.writeJson(ConfigUtil.get("requestBodyPath"), newData);
    }

}
