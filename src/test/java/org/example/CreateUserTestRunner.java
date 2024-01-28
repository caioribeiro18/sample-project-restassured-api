package org.example;

import io.qameta.allure.*;
import org.example.fixture.UserFixtureFactory;
import org.example.model.UserWithoutJob;
import org.example.model.UserWithoutName;
import org.example.model.UserWithoutRequiredFields;
import org.example.model.ValidUser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
@Epic("API Regression Testing with RestAssured and TestNG")
@Feature("Verify if the user creation API works correctly")
public class CreateUserTestRunner {

    UserAPITest userAPITest;

    @BeforeClass
    public void setupLoadTemplateFixtureBeforeClass() throws IOException {
        userAPITest = new UserAPITest();
    }

    @Story("POST Create user using POST method")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description : Verify successfully create user using POST method")
    @Test(priority = 0, description = "Shold successfully create user using POST method")
    public void createUserSuccessfullyWithPostMethod() {
        ValidUser validUser = UserFixtureFactory.createValidUser();
        userAPITest.shouldCreateUserSuccessfullyWithPostMethod(validUser);
    }

    @Story("POST Create user using POST method")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description : Verify should not create user without required fields ")
    @Test(priority = 1, description = "Should not create user without required fields")
    public void shouldNotCreateUserWithoutRequiredFields() {
        UserWithoutRequiredFields userWithoutRequiredFields = UserFixtureFactory.createUserWithoutRequiredFields();
        userAPITest.testShouldNotCreateUserWithoutRequiredFields(userWithoutRequiredFields);
    }

    @Story("POST Create user using POST method")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description : Verify should not create user without name")
    @Test(priority = 2, description = "Verify should not create user without name")
    public void shouldNotCreateUserWithoutName() {
        UserWithoutName userWithoutName = UserFixtureFactory.createUserWithoutName();
        userAPITest.testShouldNotCreateUserWithoutName(userWithoutName);
    }

    @Story("POST Create user using POST method")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description : Verify should not create user without job")
    @Test(priority = 3, description = "Verify should not create user without job")
    public void shouldNotCreateUserWithoutJob() {
        UserWithoutJob userWithoutJob = UserFixtureFactory.createUserWithoutJob();
        userAPITest.testShouldNotCreateUserWithoutJob(userWithoutJob);
    }

    @Story("POST Create user using POST method")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Ensure all required fields are present in the response body after creating a user.")
    @Test(priority = 4, description = "Test to ensure all required fields are present in the response body after creating a user.")
    public void createUserWithAllRequiredFieldsInResponseBody() {
        ValidUser validUser = UserFixtureFactory.createValidUser();
        userAPITest.verifyCreateUserWithAllRequiredFieldsInResponseBodyWithJsonSchemaValidator(validUser);
    }

}