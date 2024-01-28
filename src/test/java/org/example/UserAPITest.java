package org.example;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import org.example.model.UserWithoutRequiredFields;
import org.example.model.ValidUser;
import org.example.model.UserWithoutJob;
import org.example.model.UserWithoutName;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class UserAPITest {

    Properties props = new Properties();
    FileInputStream file = new FileInputStream("./src/test/resources/config.properties");

    public UserAPITest() throws IOException {
        props.load(file);
        RestAssured.baseURI = props.getProperty("baseUrl");
    }

    public void shouldCreateUserSuccessfullyWithPostMethod(ValidUser validUser) {
        given()
                .body(validUser)
                .when()
                .post("/api/user")
                .then()
                .assertThat().statusCode(201);
    }

    public void testShouldNotCreateUserWithoutRequiredFields(UserWithoutRequiredFields userWithoutRequiredFields) {
        given()
                .body(userWithoutRequiredFields)
                .when()
                .post("/api/user")
                .then()
                .assertThat().statusCode(400);
    }

    public void testShouldNotCreateUserWithoutName(UserWithoutName userWithoutName)  {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();
        given()
                .body(userWithoutName)
                .when()
                .post("/api/user")
                .then()
                .assertThat().statusCode(400);
    }

    public  void testShouldNotCreateUserWithoutJob(UserWithoutJob userWithoutJob) {
        given()
                .body(userWithoutJob)
                .when()
                .post("/api/user")
                .then()
                .assertThat().statusCode(400);
    }

    public  void verifyCreateUserWithAllRequiredFieldsInResponseBodyWithJsonSchemaValidator(ValidUser validUser) {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();
        given()
                .body(validUser)
                .when()
                .post("/api/user")
                .then()
                .assertThat().statusCode(201).body(matchesJsonSchemaInClasspath("response-user-schema.json").using(jsonSchemaFactory));
    }

}