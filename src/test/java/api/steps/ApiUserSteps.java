package api.steps;

import api.helpers.ApiHelper;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

public class ApiUserSteps {
    private Response response;
    private String createdId;

    @When("I get list of tags")
    public void getTags(){
        response = ApiHelper.givenAuth().when().get("/tag");
    }

    @Then("tags response is ok")
    public void tagsOk(){
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertTrue(response.jsonPath().getList("data").size() >= 0);
    }

    @When("I create user with firstName {string} and email {string}")
    public void createUser(String firstName, String email){
        String body = String.format("{\"firstName\":\"%s\",\"lastName\":\"Test\",\"email\":\"%s\"}", firstName, email);
        response = ApiHelper.givenAuth().body(body).when().post("/user/create");
        if (response.getStatusCode() == 200 || response.getStatusCode() == 201){
            createdId = response.jsonPath().getString("id");
        }
    }

    @Then("create should be successful")
    public void createSuccess(){
        Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 201);
        Assert.assertNotNull(createdId);
    }

    @When("I get user by created id")
    public void getUserByCreated(){
        response = ApiHelper.givenAuth().when().get("/user/" + createdId);
    }

    @Then("get user should return ok")
    public void getUserOk(){
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(createdId, response.jsonPath().getString("id"));
    }

    @When("I delete user by created id")
    public void deleteUser(){
        response = ApiHelper.givenAuth().when().delete("/user/" + createdId);
    }

    @Then("delete should be successful")
    public void deleteOk(){
        Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 204);
    }

    // Negative: get invalid id
    @When("I get user by invalid id {string}")
    public void getInvalid(String id){
        response = ApiHelper.givenAuth().when().get("/user/" + id);
    }

    @Then("response should be not found")
    public void notFound(){
        Assert.assertTrue(response.getStatusCode() == 404 || response.getStatusCode() == 400);
    }
}
