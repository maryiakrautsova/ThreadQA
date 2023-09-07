package api.reqres.registration;

public class UnSuccessRegistration extends Register {
    private String error;

    public UnSuccessRegistration(String error,
                                 String email,
                                 String password) {
        super(email, password);
        this.error = error;
    }

    public UnSuccessRegistration() {
    }

    public String getError() {
        return error;
    }

    public String getEmail() {
        return super.getEmail();
    }

    public String getPassword() {
        return super.getPassword();
    }
}
