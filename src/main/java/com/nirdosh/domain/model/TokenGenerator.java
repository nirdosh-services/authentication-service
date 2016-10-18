package com.nirdosh.domain.model;

import java.math.BigInteger;
import java.security.SecureRandom;

public class TokenGenerator {
    private static SecureRandom random = new SecureRandom();

    public static Token nextToken() {
        return new Token(new BigInteger(130, random).toString(32));
    }
}
