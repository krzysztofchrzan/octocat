package octocat;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndpointNegativeTest {
    private final String BASE_URL = "https://api.github.com/users";
    private Response response = null;
    RequestSpecification requestSpecification = null;

    @BeforeMethod
    public void setUp() {
        requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
    }

    @Test(priority = 1)
    public void verifyPutMethod() {
        response = requestSpecification.get(BASE_URL + "/octocat");
        String responseBody = response.getBody().asString();
        JSONObject requestJSON;
        // changing value in body request
        try {
            requestJSON = new JSONObject(responseBody);
            requestJSON.put("location", "Warszawa");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        requestSpecification.body(requestJSON.toString());
        response = requestSpecification.put(BASE_URL);
        int expectedStatusCode = 404;
        Assert.assertEquals(
                response.statusCode(),
                404,
                "Status Code is " + response.statusCode() + " but should be: " + expectedStatusCode);
    }

    @Test(priority = 2)
    public void verifyPostMethod() {
        response = requestSpecification.get(BASE_URL + "/octocat");
        String responseBody = response.getBody().asString();
        JSONObject requestJSON;
        try {
            requestJSON = new JSONObject(responseBody);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        requestSpecification.body(requestJSON.toString());
        response = requestSpecification.post(BASE_URL);
        int expectedStatusCode = 404;
        Assert.assertEquals(
                response.statusCode(),
                404,
                "Status Code is " + response.statusCode() + " but should be: " + expectedStatusCode);
    }

    @Test(priority = 3)
    public void verifyDeleteStatusCode() {
        response = requestSpecification.delete(BASE_URL + "/octocat");
        int expectedStatusCode = 404;
        Assert.assertEquals(
                response.statusCode(),
                404,
                "Status Code is " + response.statusCode() + " but should be: " + expectedStatusCode);
    }
}
