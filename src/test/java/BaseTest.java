import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import service.*;
import step.PostAssertionStep;
import step.UserAssertionStep;

public abstract class BaseTest {
    protected RestPostService restPostService;
    protected Response response;
    protected RestUserService restUserService;
    protected PostAssertionStep postAssertionStep;
    protected UserAssertionStep userAssertionStep;
    @BeforeMethod
    public void setUp() {
        restPostService = new RestPostService();
        restUserService = new RestUserService();
    }
}