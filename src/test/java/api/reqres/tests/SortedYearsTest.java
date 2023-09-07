package api.reqres.tests;

import api.reqres.colors.Data;
import api.reqres.spec.Specifications;
import api.reqres.urls.Urls;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class SortedYearsTest {
    @Test
    @Owner("Maria Kravtsova")
    @Description("1. Используя сервис https://reqres.in/ убедиться, что операция LIST <RESOURCE> возвращает данные" +
            "отсортированные по годам.")
    @TmsLink("api-test-4")
    public void sortedYearsTest() {
        Specifications.installSpecs(Specifications.requestSpec(Urls.URL), Specifications.responseSpec200OK());

        List<Data> colorsData = given().
                when().
                get("api/unknown").
                then().
                log().all().
                extract().body().jsonPath().getList("data", Data.class);

        List<Integer> years = colorsData.stream().map(Data::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());

        Assertions.assertEquals(sortedYears, years);
    }
}
