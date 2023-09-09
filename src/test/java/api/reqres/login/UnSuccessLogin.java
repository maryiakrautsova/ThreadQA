package api.reqres.login;

public class UnSuccessLogin extends Login {
    private String error;

    public UnSuccessLogin() {
    }

    public UnSuccessLogin(String error) {
        this.error = error;
    }

    public UnSuccessLogin(String email, String password, String error) {
        super(email, password);
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
