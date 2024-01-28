package org.example.fixture;

import org.example.model.UserWithoutJob;
import org.example.model.UserWithoutName;
import org.example.model.UserWithoutRequiredFields;
import org.example.model.ValidUser;

public class UserFixtureFactory {
    public static class UserFixture{
        public static ValidUser createValidUser() {
            return new ValidUser("morpheus", "leader");
        }

        public static UserWithoutRequiredFields createUserWithoutRequiredFields() {
            return new UserWithoutRequiredFields("{}");
        }

        public static UserWithoutName createUserWithoutName() {
            return new UserWithoutName("leader");
        }

        public static UserWithoutJob createUserWithoutJob() {
            return new UserWithoutJob("morpheus");
        }

    }

    public static ValidUser createValidUser() {
        return UserFixture.createValidUser();
    }

    public static UserWithoutRequiredFields createUserWithoutRequiredFields() {
        return UserFixture.createUserWithoutRequiredFields();
    }

    public static UserWithoutName createUserWithoutName() {
        return UserFixture.createUserWithoutName();
    }

    public static UserWithoutJob createUserWithoutJob() {
        return UserFixture.createUserWithoutJob();
    }

}