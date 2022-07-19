package com.estsoft.pilot.domain.jwt.constant;

public enum TokenType {
    ACCESS, REFRESH;

    public static boolean isAccessToken(String type) {
        return ACCESS == TokenType.from(type);
    }

    public static TokenType from(String tokenType) {
        return TokenType.valueOf(tokenType.toUpperCase());
    }
}