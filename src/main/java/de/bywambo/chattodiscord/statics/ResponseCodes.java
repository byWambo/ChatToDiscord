package de.bywambo.chattodiscord.statics;

public class ResponseCodes {

    private ResponseCodes() {
        throw new IllegalStateException("Utility class");
    }

    // Important Discord status codes from
    // https://discord.com/developers/docs/topics/opcodes-and-status-codes#http
    public static final int OK_NO_CONTENT = 204;
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int TOO_MANY_REQUESTS = 429;
    public static final int GATEWAY_UNAVAILABLE = 502;
}
