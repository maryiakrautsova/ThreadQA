package api.reqres.tests;

import api.reqres.registration.Register;
import api.reqres.registration.UnSuccessRegistration;
import api.reqres.spec.Specifications;
import api.reqres.urls.Urls;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserNotFoundTest {
    @Test
    @Owner("Maria Kravtsova")
    @Description("1. Используя сервис https://reqres.in/ протестировать неуспешный поиск пользователя в системе.")
    @TmsLink("api-test-7")
    public void userNotFoundTest() {
        Specifications.installSpecs(Specifications.requestSpec(Urls.URL), Specifications.responseSpec404Error());

        Response response = given().
                get("api/users/23").
                then().log().all().body(equalTo("{}")).extract().response();
    }
}
