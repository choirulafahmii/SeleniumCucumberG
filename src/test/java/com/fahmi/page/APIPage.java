package com.fahmi.page;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class APIPage {

    @Test
    public void getUserTest(){
        given().when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("per_page", Matchers.equalTo(6))
                .assertThat().body("page", Matchers.equalTo(2));
    }


    @Test
    public void postCreateUser(){

        String valueName = "Mobby Ami";
        String valueJob = "QA Engineer";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", valueName);
        bodyObj.put("job", valueJob);

        given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .body(bodyObj.toString())
                .when()
                .post("https://reqres.in/api/users")
                .then().log().all()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(valueName));
    }


    @Test
    public void putUser(){

        RestAssured.baseURI = "https://reqres.in/";

        int userId = 2;
        String newName = "Mobbyami";
        String newName2 = "Radiant";

        String fname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.first_name");
        String lname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.last_name");
        String avatar = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.avatar");
        String email = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.email");
        System.out.println("name before = "+lname +fname);

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", userId);
        bodyMap.put("email", email);
        bodyMap.put("first_name", newName);
        bodyMap.put("last_name", newName2);
        bodyMap.put("avatar", avatar);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-type", "application/json")
                .body(jsonObject.toString())
                .put("api/users/"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));

    }

    @Test
    public void patchUser(){
        RestAssured.baseURI = "https://reqres.in/";

        int userId = 3;
        String newName = "Cabina";

        String fname = given().when().get("api/users/"+userId)
                .getBody().jsonPath().get("data.first_name");
        System.out.println("name before = "+fname);

        HashMap<String, String> bodyMap = new HashMap<>();
        bodyMap.put("first_name", newName);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-type", "application/json")
                .body(jsonObject.toString())
                .patch("api/users/"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));
    }

    @Test
    public void deleteUser(){
        RestAssured.baseURI = "https://reqres.in/";

        int userToDelete = 4;

        given().log().all()
                .when().delete("api/users/"+ userToDelete)
                .then()
                .log().all()
                .assertThat().statusCode(204);

    }
    @Test
    public void testValidateJsonSchemaGetSingleUser(){

        RestAssured.baseURI = "https://reqres.in/";

        int userToGet = 7;

        File file = new File("src/test/resources/GetSingleUserSchema.json");

        given().log().all()
                .when().get("api/users/" + userToGet)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
    }

    @Test
    public void testValidateJsonSchemaGetUserEdgeCases(){

        RestAssured.baseURI = "https://reqres.in/";

        int[] testUserIds = {-1, 0, 8, 100, 9999999}; // ID batas

        File file = new File("src/test/resources/GetSingleUserSchema.json");

        for (int userToGet : testUserIds) {
            given().log().all()
                    .when().get("api/users/" + userToGet)
                    .then().log().all()
                    .assertThat()
                    .statusCode(userToGet == 8 ? 200 : 404); // Hanya ID 1 yang valid
        }
    }

}

