package com.panjohnny;

@SuppressWarnings("unused")
public enum LoggerMode {
    NEW_LINE("\n"),
    ONE_LINE("");

    private final String value;

    LoggerMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
