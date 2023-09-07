package api.reqres.tests;

import api.reqres.registration.Register;
import api.reqres.registration.SuccessRegistration;
import api.reqres.spec.Specifications;
import api.reqres.urls.Urls;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SuccessUserRegistrationTest {

    @Test
    @Owner("Maria Kravtsova")
    @Description("1. Используя сервис https://reqres.in/ протестировать успешную регистрацию пользователя в системе.")
    @TmsLink("api-test-2")
    public void successUserRegistrationTest() {
        Specifications.installSpecs(Specifications.requestSpec(Urls.URL), Specifications.responseSpec200OK());

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");

        SuccessRegistration successRegistration = given().
                body(user).
                when().
                post("api/register").
                then().
                log().all().
                extract().as(SuccessRegistration.class);

        Assertions.assertNotNull(successRegistration.getId());
        Assertions.assertNotNull(successRegistration.getToken());
        Assertions.assertEquals(id, successRegistration.getId());
        Assertions.assertEquals(token, successRegistration.getToken());
    }
}
