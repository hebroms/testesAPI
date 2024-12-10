package testes_api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Ler JSON de um arquivo e retornar como String
    public static String readJsonString(String filePath) throws IOException {
        return objectMapper.writeValueAsString(objectMapper.readTree(new File(filePath)));
    }

    // Ler JSON de um arquivo e converter para um Map
    public static Map<String, Object> readJsonMap(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), Map.class);
    }

    // Escrever um Map como JSON em um arquivo
    public static void writeJson(String filePath, Map<String, Object> data) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
    }
}
