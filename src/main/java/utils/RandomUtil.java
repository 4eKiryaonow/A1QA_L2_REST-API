package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtil {

    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, false);
    }
}