import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StarWarsAPITests {

    @Test
    void LukeTest() {
        Response response =
                given()
                        .when()
                        .get("https://swapi.dev/api/people/1/")
                        .then()
                        .contentType(ContentType.JSON)
                        .extract().response();

        assertEquals(response.getStatusCode(), 200);
        String name = response.path("name");
        assertEquals(name, "Luke Skywalker");
    }

    @Test
    void NotFoundTest() {
        Response response = given()
                .when()
                .get("https://swapi.dev/api/people/darth-vader")
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
    }
}