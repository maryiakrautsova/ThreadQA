package api.reqres.tests;

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

public class unSuccessUserRegistrationTest {
    @Test
    @Owner("Maria Kravtsova")
    @Description("1. Используя сервис https://reqres.in/ протестировать неуспешную регистрацию пользователя в системе.")
    @TmsLink("api-test-3")
    public void unSuccessUserRegistrationTest() {
        Specifications.installSpecs(Specifications.requestSpec(Urls.URL), Specifications.responseSpec400Error());

        Register user = new Register("peter@klaven", "");
        UnSuccessRegistration registration = given().
                body(user).
                post("api/register").
                then().log().all().
                extract().as(UnSuccessRegistration.class);

        Assertions.assertEquals("Missing password", registration.getError());
    }
}
