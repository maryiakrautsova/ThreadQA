package api.reqres.login;

public class SuccessLogin extends Login {
    private String token;

    public SuccessLogin() {
    }

    public SuccessLogin(String token) {
        this.token = token;
    }

    public SuccessLogin(String email, String password, String token) {
        super(email, password);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
