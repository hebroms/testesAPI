package testes_api.tests;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import testes_api.config.ApiTestBase;
import testes_api.models.Post;
import testes_api.utils.ApiHelper;
import testes_api.utils.ConfigUtil;
import testes_api.utils.GeneretePostsUtil;
import testes_api.utils.JsonUtil;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Create Posts")
public class ApiTests extends ApiTestBase {

    Faker faker = new Faker();


    @Test
    @Description("Test to create on file a posts using POST route /posts")
    @Severity(SeverityLevel.NORMAL)
    void testPostRequest() throws IOException {

        // Gerar novo Post
        GeneretePostsUtil.generatePost();

        // Corpo da requisição em JSON
        String requestBodyString = JsonUtil.readJsonString(ConfigUtil.get("requestBodyPath"));
        Map<String, Object> requestBodyMap = JsonUtil.readJsonMap(ConfigUtil.get("requestBodyPath"));

        // Enviar requisição POST
        Response response = ApiHelper.post(ConfigUtil.get("routePosts"), requestBodyString);

        // Validar código de status
        assertEquals(201, response.getStatusCode());

        // Validar conteúdo da resposta
        assertEquals(requestBodyMap.get("title"), response.jsonPath().getString("title"), "O título não corresponde ao enviado");
        assertEquals(requestBodyMap.get("body"), response.jsonPath().getString("body"), "O body não corresponde ao enviado");
        assertEquals(requestBodyMap.get("userId"), Integer.valueOf(response.jsonPath().getString("userId")), "O userId não corresponde ao enviado");
    }

    @Test
    @Description("Test to create on file partial posts using POST route /posts")
    @Severity(SeverityLevel.NORMAL)
    void testPartialPostRequest() throws IOException {

        // Gerar novo Post
        GeneretePostsUtil.generatePartialPost();

        // Corpo da requisição em JSON
        String requestBodyString = JsonUtil.readJsonString(ConfigUtil.get("requestBodyPath"));
        Map<String, Object> requestBodyMap = JsonUtil.readJsonMap(ConfigUtil.get("requestBodyPath"));

        // Enviar requisição POST
        Response response = ApiHelper.post(ConfigUtil.get("routePosts"), requestBodyString);

        // Validar código de status
        assertEquals(201, response.getStatusCode());

        // Validar conteúdo da resposta
        assertEquals(requestBodyMap.get("title"), response.jsonPath().getString("title"), "O título não corresponde ao enviado");
        assertEquals(requestBodyMap.get("body"), response.jsonPath().getString("body"), "O body não corresponde ao enviado");
        assertEquals(requestBodyMap.get("userId"), Integer.valueOf(response.jsonPath().getString("userId")), "O userId não corresponde ao enviado");
    }

    @Test
    @Description("Test to create on object a posts using POST route /posts")
    @Severity(SeverityLevel.NORMAL)
    void testPostObjectRequest() throws IOException {

        // Gerar novo Post
        Post newPost = new Post();
        newPost.setTitle(faker.lorem().word());
        newPost.setBody(faker.lorem().paragraph());
        newPost.setUserId(faker.number().randomDigit());

        // Enviar requisição POST
        Response response = ApiHelper.post(ConfigUtil.get("routePosts"), newPost);

        // Validar código de status
        assertEquals(201, response.getStatusCode());

        // Validar conteúdo da resposta
        Post createdPost = response.as(Post.class);
        assertEquals(newPost.getTitle(), createdPost.getTitle(), "O título não corresponde ao enviado");
        assertEquals(newPost.getBody(), createdPost.getBody(), "O body não corresponde ao enviado");
        assertEquals(newPost.getUserId(), createdPost.getUserId(), "O userId não corresponde ao enviado");
    }

    @Test
    @Description("Test to create on object partial posts using POST route /posts")
    @Severity(SeverityLevel.NORMAL)
    void testPartialPostObjectRequest() throws IOException {

        // Gerar novo Post
        Post newPost = new Post();
        newPost.setTitle(faker.lorem().word());
        newPost.setUserId(faker.number().randomDigit());

        // Enviar requisição POST
        Response response = ApiHelper.post(ConfigUtil.get("routePosts"), newPost);

        // Validar código de status
        assertEquals(201, response.getStatusCode());

        // Validar conteúdo da resposta
        Post createdPost = response.as(Post.class);
        assertEquals(newPost.getTitle(), createdPost.getTitle(), "O título não corresponde ao enviado");
        assertEquals(newPost.getUserId(), createdPost.getUserId(), "O userId não corresponde ao enviado");
    }

}
