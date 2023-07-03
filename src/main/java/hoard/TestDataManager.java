package hoard;

import utils.RandomUtil;

import static constants.KeyDataConstants.*;
import static constants.PathConstants.PATH_TEST_DATA;

public class TestDataManager {
    public static String getPostValidId() {
        return JsonReader.getValue(PATH_TEST_DATA, VALID_POST_ID_KEY);
    }

    public static String getPostUserId() {
        return JsonReader.getValue(PATH_TEST_DATA, VALID_POST_USER_ID_KEY);
    }

    public static String getPostInvalidId() {
        return JsonReader.getValue(PATH_TEST_DATA, INVALID_POST_ID_KEY);
    }

    public static String getUserIdToCreatePost() {
        return JsonReader.getValue(PATH_TEST_DATA, USER_ID_TO_CREATE_POST_KEY);
    }

    public static int getLengthRandomString() {
        return Integer.parseInt(JsonReader.getValue(PATH_TEST_DATA, LENGTH_STRING_KEY));
    }

    public static String getInvalidPostResponse() {
        return JsonReader.getValue(PATH_TEST_DATA, INVALID_POST_RESPONSE_BODY_KEY);
    }

    public static String getRandomString() {
        return RandomUtil.getRandomString(getLengthRandomString());
    }
}