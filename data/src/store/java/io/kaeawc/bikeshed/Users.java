package io.kaeawc.bikeshed;

import java.util.Arrays;
import java.util.List;

import io.kaeawc.bikeshed.data.models.User;

public class Users {

    public List<User> getAll() {
        return Arrays.asList(
                new User(),
                new User(),
                new User()
        );
    }
}
