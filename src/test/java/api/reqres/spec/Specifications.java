package api.reqres.spec;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder().
                setBaseUri(url).
                setContentType(ContentType.JSON).
                build();
    }

    public static ResponseSpecification responseSpec200OK() {
        return new ResponseSpecBuilder().
                expectStatusCode(200).
                build();
    }

    public static ResponseSpecification responseSpec400Error() {
        return new ResponseSpecBuilder().
                expectStatusCode(400).
                build();
    }

    public static ResponseSpecification responseSpec404Error() {
        return new ResponseSpecBuilder().
                expectStatusCode(404).
                build();
    }

    public static void installSpecs(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

    public static ResponseSpecification responseSpecUnique(int status) {
        return new ResponseSpecBuilder().
                expectStatusCode(status).
                build();
    }
}
