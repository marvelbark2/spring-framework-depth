package ws.prospeak.personal.spring.depth.appcontext;

public class Users {
    private final Long id;
    private final String username;
    private final String password;

    public Users(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
