package api.reqres.tests;

import api.reqres.spec.Specifications;
import api.reqres.urls.Urls;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTest {

    @Test
    @Owner("Maria Kravtsova")
    @Description("1. Используя сервис https://reqres.in/ убедиться, что юзера можно удалить.")
    @TmsLink("api-test-5")
    public void deleteUserTest() {
        Specifications.installSpecs(Specifications.requestSpec(Urls.URL), Specifications.responseSpecUnique(204));

        given().when().delete("api/users/2").then().log().all();
    }
}
