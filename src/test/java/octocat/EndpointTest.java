package octocat;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class EndpointTest {
    private final String BASE_URL = "https://api.github.com/users/octocat";
    private Response response = null;

    @BeforeClass
    public void setUp() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        response = requestSpecification.get(BASE_URL);
    }

    @Test(priority = 1)
    public void testStatusCode() {
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2)
    public void testContentType() {
        Assert.assertEquals(
                ContentType.JSON.toString(),
                "application/json",
                "Content-Type is not JSON"
        );
    }

    @Test(priority = 3)
    public void testPerformance() {
        long responseTime = response.getTime();
        Assert.assertTrue(
                responseTime <= 3000,
                "Response time is greater than 3000 milliseconds"
        );
    }

    @Test(priority = 4)
    public void testFieldLogin() {
        Assert.assertEquals(response.jsonPath().get("login"), "octocat", "Login differs");
    }

    @Test(priority = 5)
    public void testFieldId() {
        var actualValue = response.jsonPath().getInt("id");
        Assert.assertEquals(actualValue, 583231);
    }

    @Test(priority = 10)
    public void testFieldNodeId() {
        Assert.assertEquals(response.jsonPath().get("node_id"), "MDQ6VXNlcjU4MzIzMQ==");
    }

    @Test(priority = 10)
    public void testFieldAvatarUrl() {
        Assert.assertEquals(response.jsonPath().get("avatar_url"), "https://avatars.githubusercontent.com/u/583231?v=4");
    }

    @Test(priority = 10)
    public void testFieldGravatar_id() {
        Assert.assertEquals(response.jsonPath().get("gravatar_id"), "");
    }

    @Test(priority = 10)
    public void testFieldUrl() {
        Assert.assertEquals(response.jsonPath().get("url"), BASE_URL);
    }

    @Test(priority = 10)
    public void testFieldHtmlUrl() {
        Assert.assertEquals(response.jsonPath().get("html_url"), "https://github.com/octocat");
    }

    @Test(priority = 10)
    public void testFieldFollowersUrl() {
        Assert.assertEquals(response.jsonPath().get("followers_url"), BASE_URL + "/followers");
    }

    @Test(priority = 10)
    public void testFieldFollowingUrl() {
        Assert.assertEquals(response.jsonPath().get("following_url"), BASE_URL + "/following{/other_user}");
    }

    @Test(priority = 10)
    public void testFieldGists() {
        Assert.assertEquals(response.jsonPath().get("gists_url"), BASE_URL + "/gists{/gist_id}");
    }

    @Test(priority = 10)
    public void testFieldStarred() {
        Assert.assertEquals(response.jsonPath().get("starred_url"), BASE_URL + "/starred{/owner}{/repo}");
    }

    @Test(priority = 10)
    public void testFieldSubscriptions() {
        Assert.assertEquals(response.jsonPath().get("subscriptions_url"), BASE_URL + "/subscriptions");
    }

    @Test(priority = 10)
    public void testFieldOrganizations() {
        Assert.assertEquals(response.jsonPath().get("organizations_url"), BASE_URL + "/orgs");
    }

    @Test(priority = 10)
    public void testFieldRepos() {
        Assert.assertEquals(response.jsonPath().get("repos_url"), BASE_URL + "/repos");
    }

    @Test(priority = 10)
    public void testFieldEvents() {
        Assert.assertEquals(response.jsonPath().get("events_url"), BASE_URL + "/events{/privacy}");
    }

    @Test(priority = 10)
    public void testFieldReceivedEventsUrl() {
        Assert.assertEquals(response.jsonPath().get("received_events_url"), BASE_URL + "/received_events");
    }

    @Test(priority = 10)
    public void testFieldType() {
        Assert.assertEquals(response.jsonPath().get("type"), "User");
    }

    @Test(priority = 10)
    public void testFieldSiteAdmin() {
        boolean actualValue = response.jsonPath().get("site_admin");
        boolean expectedValue = false;
        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test(priority = 10)
    public void testFieldName() {
        Assert.assertEquals(response.jsonPath().get("name"), "The Octocat");
    }

    @Test(priority = 10)
    public void testFieldCompany() {
        Assert.assertEquals(response.jsonPath().get("company"), "@github");
    }

    @Test(priority = 10)
    public void testFieldBlog() {
        Assert.assertEquals(response.jsonPath().get("blog"), "https://github.blog");
    }

    @Test(priority = 10)
    public void testFieldLocation() {
        Assert.assertEquals(response.jsonPath().get("location"), "San Francisco");
    }

    @Test(priority = 10)
    public void testFieldEmail() {
        Object expectedEmail = null;
        Assert.assertEquals(response.jsonPath().get("email"), expectedEmail);
    }

    @Test(priority = 10)
    public void testFieldHireable() {
        Object expectedHireable = null;
        Assert.assertEquals(response.jsonPath().get("hireable"), expectedHireable);
    }

    @Test(priority = 10)
    public void testFieldBio() {
        Object expectedBio = null;
        Assert.assertEquals(response.jsonPath().get("bio"), expectedBio);
    }

    @Test(priority = 10)
    public void testFieldTwitter() {
        Object expectedTwitter = null;
        Assert.assertEquals(response.jsonPath().get("twitter_username"), expectedTwitter);
    }

    @Test(priority = 10)
    public void testFieldPublicRepos() {
        int actualValue = response.jsonPath().getInt("public_repos");
        Assert.assertTrue(actualValue >= 0 && actualValue <= 100);
    }

    @Test(priority = 10)
    public void testFieldPublicGists() {
        int actualValue = response.jsonPath().getInt("public_gists");
        Assert.assertTrue(actualValue >= 0 && actualValue <= 100);
    }

    @Test(priority = 10)
    public void testFieldFollowers() {
        int actualValue = response.jsonPath().getInt("followers");
        Assert.assertTrue(actualValue >= 0 && actualValue <= 100000);
    }

    @Test(priority = 10)
    public void testFieldFollowing() {
        int actualValue = response.jsonPath().getInt("following");
        Assert.assertTrue(actualValue >= 0 && actualValue <= 100000);
    }

    @Test(priority = 10)
    public void testFieldCreatedAt() {
        Assert.assertEquals(
                response.jsonPath().get("created_at"),
                "2011-01-25T18:44:36Z",
                "The creation date is different from expected");
    }

    @Test(priority = 10)
    public void testFieldUpdated() {
        String actualDateValue = response.jsonPath().get("updated_at");
        String expectedFormatRegex = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z";
        Assert.assertTrue(
                actualDateValue.matches(expectedFormatRegex),
                "Date format does not match expected format"
        );
    }
}
