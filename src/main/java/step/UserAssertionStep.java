package step;

import dto.User;
import io.restassured.response.Response;
import org.testng.Assert;
import service.RestUserService;
import utils.RestUserUtil;

import java.util.List;

public class UserAssertionStep extends AbstractAssertionStep {
    private RestUserService restUserService;

    public UserAssertionStep(Response response) {
        super(response);
        this.restUserService = new RestUserService();
    }

    public void assertGetUsersList(User expectedUser) {
        assertResponseStatusOK();
        assertResponseInJsonFormat();
        List<User> userList = restUserService.getUserList();
        User actualUser = RestUserUtil.getUserById(userList, expectedUser.getId());
        Assert.assertEquals(actualUser, expectedUser, "User info doesn't match");
    }

    public void assertGetUser(User expectedUser) {
        assertResponseStatusOK();
        User actualUser = restUserService.getUser(expectedUser.getId());
        Assert.assertEquals(actualUser, expectedUser, "Users don't match");
    }
}
