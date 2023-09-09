package api.reqres.tests;

import api.reqres.login.Login;
import api.reqres.login.SuccessLogin;
import api.reqres.spec.Specifications;
import api.reqres.urls.Urls;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SuccessUserLoginTest {

    @Test
    @Owner("Maria Kravtsova")
    @Description("1. Используя сервис https://reqres.in/ проверить, что операция LOGIN - SUCCESSFUL возвращает токен" +
            "после того, как логин выролнен.")
    @TmsLink("api-test-10")
    public void successUserLoginTest() {
        Specifications.installSpecs(Specifications.requestSpec(Urls.URL), Specifications.responseSpec200OK());

        String token = "QpwL5tke4Pnpja7X4";

        Login user = new Login("eve.holt@reqres.in", "cityslicka");

        SuccessLogin successLogin = given().
                body(user).
                when().
                post("api/login").
                then().log().all().extract().as(SuccessLogin.class);

        Assertions.assertNotNull(successLogin.getToken());
        Assertions.assertEquals(token, successLogin.getToken());

    }
}
