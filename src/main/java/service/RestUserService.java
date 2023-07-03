package service;

import dto.User;
import io.restassured.response.Response;
import utils.RestUtil;

import java.util.Arrays;
import java.util.List;

import static constants.EndPoints.*;

public class RestUserService {
    public Response getListUserResponse() {
        return RestUtil.getNoParams(USERS);
    }

    public List<User> getUserList() {
        return Arrays.asList(getListUserResponse().getBody().as(User[].class));
    }

    public Response getUserResponse(String userId) {
        return RestUtil.getNoParams(String.format(GET_USER, userId));
    }

    public User getUser(String userId) {
        return getUserResponse(userId).as(User.class);
    }
}