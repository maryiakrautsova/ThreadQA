package api.reqres.tests;

import api.reqres.login.Login;
import api.reqres.login.UnSuccessLogin;
import api.reqres.registration.Register;
import api.reqres.registration.UnSuccessRegistration;
import api.reqres.spec.Specifications;
import api.reqres.urls.Urls;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UnSuccessUserLoginTest {
    @Test
    @Owner("Maria Kravtsova")
    @Description("1. Используя сервис https://reqres.in/ протестировать неуспешный логин пользователя в систему.")
    @TmsLink("api-test-11")
    public void unSuccessUserLoginTest() {
        Specifications.installSpecs(Specifications.requestSpec(Urls.URL), Specifications.responseSpec400Error());

        Login user = new Login("peter@klaven", "");
        UnSuccessLogin login = given().
                body(user).
                post("/api/login").
                then().log().all().
                extract().as(UnSuccessLogin.class);

        Assertions.assertEquals("Missing password", login.getError());
    }
}
