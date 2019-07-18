package com.clubproject.config.security.jwt;

public class JWTSecurityConstants {
	public static final String SECRET = "olW556rWvlzWqtHqyXXKwkWjNaBUKmpC2yCbL9Os1ekcqs42ucTpU2PtAfG233Rk";
	public static final long EXPIRATION_NINE_HOURS = 32_400_000; // 9 hs
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String TOKEN_STRING = "token";
}