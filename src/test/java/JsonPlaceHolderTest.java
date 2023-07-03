import dto.Post;
import dto.User;
import hoard.TestDataManager;
import org.testng.annotations.Test;
import step.PostAssertionStep;
import step.UserAssertionStep;
import utils.InfoLogger;

import java.util.List;

public class JsonPlaceHolderTest extends BaseTest {

    @Test
    public void getAllPostsTest() {
        InfoLogger.info("Send GET Request to get all posts (/posts)");
        response = restPostService.getPostsResponse();
        postAssertionStep = new PostAssertionStep(response);
        postAssertionStep.assertGetAllPosts();
    }

    @Test
    public void getPostValidIdTest() {
        InfoLogger.info(String.format("Send GET request to get post with id=%s (/posts/id)", TestDataManager.getPostValidId()));
        response = restPostService.getPostResponse(TestDataManager.getPostValidId());
        postAssertionStep = new PostAssertionStep(response);
        postAssertionStep.assertGetPostIsValid(TestDataManager.getPostValidId(),TestDataManager.getPostUserId());
    }

    @Test
    public void getPostInvalidIdTest() {
        InfoLogger.info(String.format("Send GET request to get post with id=%s (/posts/id)", TestDataManager.getPostInvalidId()));
        response = restPostService.getPostResponse(TestDataManager.getPostInvalidId());
        postAssertionStep = new PostAssertionStep(response);
        postAssertionStep.assertGetPostInvalidId(TestDataManager.getInvalidPostResponse());
    }

    @Test
    public void createPostTest() {
        InfoLogger.info(String.format("Send POST request to create post with userId=%s and random body and random title (/posts).", TestDataManager.getUserIdToCreatePost()));
        Post expectedPost = new Post();
        expectedPost.setUserId(TestDataManager.getUserIdToCreatePost());
        expectedPost.setTitle(TestDataManager.getRandomString());
        expectedPost.setBody(TestDataManager.getRandomString());
        response = restPostService.postNewPostResponse(expectedPost);
        postAssertionStep = new PostAssertionStep(response);
        postAssertionStep.assertCreatePost(expectedPost);
    }

    @Test(dataProvider = "User data", dataProviderClass = TestDataProvider.class)
    public void getUsersListTest(User user) {
        InfoLogger.info("Send GET request to get users (/users)");
        response = restUserService.getListUserResponse();
        userAssertionStep = new UserAssertionStep(response);
        userAssertionStep.assertGetUsersList(user);
    }

    @Test(dataProvider = "User data", dataProviderClass = TestDataProvider.class)
    public void getUserTest(User user) {
        InfoLogger.info(String.format("Send GET request to get user with id=%s (/users/id).", user.getId()));
        response = restUserService.getUserResponse(user.getId());
        userAssertionStep = new UserAssertionStep(response);
        userAssertionStep.assertGetUser(user);
    }
}