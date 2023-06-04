package com.app.mit.du.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomNumberGenerator {
    public String generateRandomAlphabetic(int length) {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public String generateRandomAlphanumeric(int length) {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
