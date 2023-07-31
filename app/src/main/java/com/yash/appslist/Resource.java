package com.yash.appslist;

public abstract class Resource<T> {
    private T data;
    private String message;

    private Resource(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public static class Success<T> extends Resource<T> {
        public Success(T data) {
            super(data, null);
        }
    }

    public static class Error<T> extends Resource<T> {
        public Error(String message) {
            super(null, message);
        }
    }

    public static class Loading<T> extends Resource<T> {
        public Loading() {
            super(null, null);
        }
    }
}

