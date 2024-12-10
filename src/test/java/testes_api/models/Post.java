package testes_api.models;

public class Post {
    private int id;
    private String title;
    private String body;
    private Integer userId;

    // Construtor vazio para permitir campos opcionais
    public Post() {}

    // Construtor para casos em que todos os campos são usados
    public Post(String title, String body, Integer userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
