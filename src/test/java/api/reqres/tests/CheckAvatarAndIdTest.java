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


public class CheckAvatarAndIdTest {

    @Test
    @Owner("Maria Kravtsova")
    @Description("1. Получить список пользователей со второй страница на сайте https://reqres.in/;" +
            "2. Убедиться что id пользователей содержаться в их avatar;" +
            "3. Убедиться, что email пользователей имеет окончание reqres.in;")
    @TmsLink("api-test-1")
    public void checkAvatarAndIdTest() {
        Specifications.installSpecs(Specifications.requestSpec(Urls.URL), Specifications.responseSpec200OK());
        List<UserData> users = given().
                when().
                get("/api/users?page=2").
                then().log().all().
                extract().body().jsonPath().getList("data", UserData.class);

        users.forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));

        Assertions.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }
}
