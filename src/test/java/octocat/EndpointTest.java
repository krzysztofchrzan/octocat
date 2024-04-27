package octocat;

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
    public void verifyStatusCode() {
        int expectedStatusCode = 200;
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
    }

    @Test(priority = 2)
    public void verifyContentType() {
        String expectedContentType = "application/json; charset=utf-8";
        Assert.assertEquals(
                response.contentType(),
                expectedContentType,
                "Content-Type is not application/json"
        );
    }

    @Test(priority = 3)
    public void verifyPerformance() {
        long actualResponseTime = response.getTime();
        long expectedResponseTime = 300;
        Assert.assertTrue(
                actualResponseTime <= expectedResponseTime,
                "Response time is greater than " + expectedResponseTime + " milliseconds");
    }

    @Test(priority = 4)
    public void verifyFieldLogin() {
        String expectedLogin = "octocat";
        Assert.assertEquals(response.jsonPath().get("login"),
                expectedLogin,
                "Login is different than expected");
    }

    @Test(priority = 5)
    public void verifyFieldId() {
        int actualID = response.jsonPath().getInt("id");
        int expectedID = 583231;
        Assert.assertEquals(
                actualID,
                expectedID,
                "Id is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldNodeId() {
        String expectedNodeId = "MDQ6VXNlcjU4MzIzMQ==";
        Assert.assertEquals(
                response.jsonPath().get("node_id"),
                expectedNodeId,
                "Node Id is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldAvatarUrl() {
        String expectedAvatar = "https://avatars.githubusercontent.com/u/583231?v=4";
        Assert.assertEquals(
                response.jsonPath().get("avatar_url"),
                expectedAvatar,
                "Avatar URL is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldGravatar_id() {
        String expectedGravatar = "";
        Assert.assertEquals(
                response.jsonPath().get("gravatar_id"),
                expectedGravatar,
                "Gravatar ID is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldUrl() {
        Assert.assertEquals(
                response.jsonPath().get("url"),
                BASE_URL,
                "Base URL is different");
    }

    @Test(priority = 10)
    public void verifyFieldHtmlUrl() {
        String expectedUrl = "https://github.com/octocat";
        Assert.assertEquals(
                response.jsonPath().get("html_url"),
                expectedUrl,
                "HTML URL is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldFollowersUrl() {
        String expectedFollowersUrl = BASE_URL + "/followers";
        Assert.assertEquals(
                response.jsonPath().get("followers_url"),
                expectedFollowersUrl,
                "Followers URL is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldFollowingUrl() {
        String expectedFollowingUrl = BASE_URL + "/following{/other_user}";
        Assert.assertEquals(
                response.jsonPath().get("following_url"),
                expectedFollowingUrl,
                "Following URL is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldGists() {
        String expectedGists = BASE_URL + "/gists{/gist_id}";
        Assert.assertEquals(
                response.jsonPath().get("gists_url"),
                expectedGists,
                "Gists is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldStarred() {
        String expectedStarred = BASE_URL + "/starred{/owner}{/repo}";
        Assert.assertEquals(
                response.jsonPath().get("starred_url"),
                expectedStarred,
                "Starred is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldSubscriptions() {
        String expectedSubscriptions = BASE_URL + "/subscriptions";
        Assert.assertEquals(
                response.jsonPath().get("subscriptions_url"),
                expectedSubscriptions,
                "Subscriptions URL is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldOrganizations() {
        String expectedOrganizations = BASE_URL + "/orgs";
        Assert.assertEquals(
                response.jsonPath().get("organizations_url"),
                expectedOrganizations,
                "Organization URL is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldRepos() {
        String expectedRepos = BASE_URL + "/repos";
        Assert.assertEquals(
                response.jsonPath().get("repos_url"),
                expectedRepos, "Repos URL is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldEvents() {
        String expectedEvents = BASE_URL + "/events{/privacy}";
        Assert.assertEquals(
                response.jsonPath().get("events_url"),
                expectedEvents,
                "Events URL is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldReceivedEventsUrl() {
        String expectedReceivedEvents = BASE_URL + "/received_events";
        Assert.assertEquals(
                response.jsonPath().get("received_events_url"),
                expectedReceivedEvents,
                "Received Events URL is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldType() {
        String expectedType = "User";
        Assert.assertEquals(
                response.jsonPath().get("type"),
                expectedType,
                "Type of user is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldSiteAdmin() {
        boolean actualSiteAdmin = response.jsonPath().get("site_admin");
        boolean expectedSiteAdmin = false;
        Assert.assertEquals(
                actualSiteAdmin,
                expectedSiteAdmin,
                "Site Admin type is not " + expectedSiteAdmin);
    }

    @Test(priority = 10)
    public void verifyFieldName() {
        String expectedName = "The Octocat";
        Assert.assertEquals(
                response.jsonPath().get("name"),
                expectedName,
                "User Name is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldCompany() {
        String expectedCompany = "@github";
        Assert.assertEquals(
                response.jsonPath().get("company"),
                expectedCompany,
                "Company is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldBlog() {
        String expectedBlog = "https://github.blog";
        Assert.assertEquals(
                response.jsonPath().get("blog"),
                expectedBlog,
                "Company is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldLocation() {
        String expectedLocation = "San Francisco";
        Assert.assertEquals(
                response.jsonPath().get("location"),
                expectedLocation,
                "Location is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldEmail() {
        Object expectedEmail = null;
        Assert.assertEquals(
                response.jsonPath().get("email"),
                expectedEmail,
                "Email value is not " + expectedEmail);
    }

    @Test(priority = 10)
    public void verifyFieldHireable() {
        Object expectedHireable = null;
        Assert.assertEquals(
                response.jsonPath().get("hireable"),
                expectedHireable,
                "Hireable value is not " + expectedHireable);
    }

    @Test(priority = 10)
    public void verifyFieldBio() {
        Object expectedBio = null;
        Assert.assertEquals(
                response.jsonPath().get("bio"),
                expectedBio,
                "Bio value is not " + expectedBio);
    }

    @Test(priority = 10)
    public void verifyFieldTwitter() {
        Object expectedTwitter = null;
        Assert.assertEquals(
                response.jsonPath().get("twitter_username"),
                expectedTwitter,
                "Twitter value is not " + expectedTwitter);
    }

    @Test(priority = 10)
    public void verifyFieldPublicRepos() {
        int actualReposCount = response.jsonPath().getInt("public_repos");
        Assert.assertTrue(actualReposCount >= 0 && actualReposCount <= 100);
    }

    @Test(priority = 10)
    public void verifyFieldPublicGists() {
        int actualGistsCount = response.jsonPath().getInt("public_gists");
        Assert.assertTrue(actualGistsCount >= 0 && actualGistsCount <= 100);
    }

    @Test(priority = 10)
    public void verifyFieldFollowers() {
        int actualFollowersCount = response.jsonPath().getInt("followers");
        Assert.assertTrue(actualFollowersCount >= 0 && actualFollowersCount <= 100000);
    }

    @Test(priority = 10)
    public void verifyFieldFollowing() {
        int actualFollowingCount = response.jsonPath().getInt("following");
        Assert.assertTrue(actualFollowingCount >= 0 && actualFollowingCount <= 100000);
    }

    @Test(priority = 10)
    public void verifyFieldCreatedAt() {
        String expectedCreatedAt = "2011-01-25T18:44:36Z";
        Assert.assertEquals(
                response.jsonPath().get("created_at"),
                expectedCreatedAt,
                "The creation date is different than expected");
    }

    @Test(priority = 10)
    public void verifyFieldUpdated() {
        String actualDateValue = response.jsonPath().get("updated_at");
        String expectedFormatRegex = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z";
        Assert.assertTrue(
                actualDateValue.matches(expectedFormatRegex),
                "Date format does not match expected format"
        );
    }
}
