package com.topcv.topcvserver.dto;

/**
 * Wrapper class for API responses.
 */
public class Response {
    private final boolean success; // Success status
    private final Object result;   // Data for success cases
    private final String message;  // Error message for failure cases

    // Private constructor to enforce controlled creation
    private Response(boolean success, Object result, String message) {
        this.success = success;
        this.result = result;
        this.message = message;
    }

    /**
     * Factory method for success responses.
     */
    public static Response success(Object result) {
        return new Response(true, result, null);
    }

    /**
     * Factory method for error responses.
     */
    public static Response error(String message) {
        return new Response(false, null, message);
    }

    // Getters
    @SuppressWarnings("unused")
    public boolean isSuccess() {
        return success;
    }

    @SuppressWarnings("unused")
    public Object getResult() {
        return result;
    }

    @SuppressWarnings("unused")
    public String getMessage() {
        return message;
    }
}
