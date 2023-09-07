package api.reqres.registration;

public class SuccessRegistration extends Register{
    private Integer id;
    private String token;

    public SuccessRegistration() {
        super();
    }

    public SuccessRegistration(String email,
                          String password,
                          Integer id,
                          String token) {
        super(email,password);
        this.id = id;
        this.token = token;

    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
