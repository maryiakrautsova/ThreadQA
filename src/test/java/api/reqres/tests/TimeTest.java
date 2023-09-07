package api.reqres.tests;

import api.reqres.spec.Specifications;
import api.reqres.urls.Urls;
import api.reqres.users.UserTime;
import api.reqres.users.UserTimeResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;

import static io.restassured.RestAssured.given;


public class TimeTest {
    @Test
    @Owner("Maria Kravtsova")
    @Description("Используя сервис https://reqres.in/ обновить информацию о пользователе и сравнить дату обновления " +
            "с текущей датой на машине.")
    @TmsLink("api-test-6")
    public void checkServerAndPcDateTest() {
        Specifications.installSpecs(Specifications.requestSpec(Urls.URL), Specifications.responseSpec200OK());

        UserTime user = new UserTime("morpheus", "zion resident");
        UserTimeResponse userTimeResponse = given().
                body(user).
                when().
                put("api/users/2").
                then().log().all().
                extract().as(UserTimeResponse.class);

        String regex1 = "(.{8})$";
        String regex2 = "(.{5})$";

        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex1, "");
        String responseTime = userTimeResponse.getUpdatedAt().replaceAll(regex2, "");

        Assertions.assertEquals(currentTime, responseTime);
    }
}
