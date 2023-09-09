package api.reqres.tests;

import api.reqres.colors.Data;
import api.reqres.spec.Specifications;
import api.reqres.urls.Urls;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpecifiedColorReturnsTest {
    @Test
    @Owner("Maria Kravtsova")
    @Description("1. Используя сервис https://reqres.in/ убедиться, что операция SINGLE <RESOURCE> возвращает данные" +
            "о цвете." +
            "2. id = 2 и name = fuchsia rose.")
    @TmsLink("api-test-9")
    public void specifiedColorCanBeFoundTest() {
        Specifications.installSpecs(Specifications.requestSpec(Urls.URL), Specifications.responseSpec200OK());

        Data color = given().
                when().
                get("api/unknown/2").
                then().log().all().
                extract().jsonPath().getObject("data", Data.class);

        Assertions.assertEquals("2", color.getId().toString());
        Assertions.assertEquals("fuchsia rose", color.getName());
    }
}
