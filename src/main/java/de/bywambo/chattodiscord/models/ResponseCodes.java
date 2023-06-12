package de.bywambo.chattodiscord.models;

/**
 * Important Discord status codes from
 * <a href="https://discord.com/developers/docs/topics/opcodes-and-status-codes#http">discord.com</a>
 */
public final class ResponseCodes {

    public static final int OK_NO_CONTENT = 204;
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int TOO_MANY_REQUESTS = 429;
    public static final int GATEWAY_UNAVAILABLE = 502;

    private ResponseCodes() {
        throw new IllegalStateException("Utility class");
    }
}
