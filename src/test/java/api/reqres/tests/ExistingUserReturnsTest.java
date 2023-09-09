package api.reqres.tests;

import api.reqres.spec.Specifications;
import api.reqres.urls.Urls;
import api.reqres.users.UserData;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ExistingUserReturnsTest {
    @Test
    @Owner("Maria Kravtsova")
    @Description("1. Получить существующего в системе пользователя со 2ой страницы на сайте https://reqres.in/.")
    @TmsLink("api-test-8")
    public void existingInTheSystemUserCanBeFoundTest() {
        Specifications.installSpecs(Specifications.requestSpec(Urls.URL), Specifications.responseSpec200OK());
        UserData user = given().
                when().
                get("api/users/2").
                then().log().all().
                extract().jsonPath().getObject("data", UserData.class);
        Integer id = user.getId();

        Assertions.assertEquals("2", id.toString());
    }
}
