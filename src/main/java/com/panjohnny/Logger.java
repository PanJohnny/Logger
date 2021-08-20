package com.panjohnny;

import java.io.PrintStream;

public class Logger {
    private Logger() {}
    private static LogFormat format = LogFormat.BLANK;
    private static PrintStream stream = System.out;
    private static LoggerMode mode = LoggerMode.NEW_LINE;
    private static PrintStream errorStream = System.err;
    private static boolean first = true;
    private static long millis;
    /**
     * Logs in console message with default set LogFormat
     * @param message message that would be logged
     * @see LogFormat
     */
    public static void log(String message) {
        log(message, format);
    }

    /**
     * Logs in console message with specific LogFormat
     * @param message message that would be logged
     * @param format format that you want
     * @see LogFormat
     */
    public static void log(String message, LogFormat format) {
        switch (mode) {
            case NEW_LINE -> stream.println(format.format() + message);
            case ONE_LINE -> stream.print(format.format() + message);
            default -> stream.println("WARNING: LoggerMode is undefined\n"+format.format() + message);
        }
        checkFirst();
    }

    /**
     * Logs error in console with default set LogFormat
     * @param message message that would be logged
     * @see LogFormat
     */
    public static void error(String message) {
        error(message, format);
    }

    /**
     * Logs error in console with specific LogFormat
     * @param message message that would be logged
     * @param format format that you want
     * @see LogFormat
     */
    public static void error(String message, LogFormat format) {
        switch (mode) {
            case NEW_LINE -> errorStream.println(format.format() + message);
            case ONE_LINE -> errorStream.print(format.format() + message);
            default -> errorStream.println("WARNING: LoggerMode is undefined\n"+format.format() + message);
        }
        checkFirst();
    }

    private static void checkFirst() {
        if(first) {
            millis = System.currentTimeMillis();
            first=false;
        }
    }

    public static LogFormat getFormat() {
        return format;
    }

    public static void setFormat(LogFormat format) {
        Logger.format = format;
    }

    public static PrintStream getStream() {
        return stream;
    }

    public static void setStream(PrintStream stream) {
        Logger.stream = stream;
    }

    public static LoggerMode getMode() {
        return mode;
    }

    public static void setMode(LoggerMode mode) {
        Logger.mode = mode;
    }

    public static PrintStream getErrorStream() {
        return errorStream;
    }

    public static void setErrorStream(PrintStream errorStream) {
        Logger.errorStream = errorStream;
    }

    public static long getFirstLogTime() {
        return millis;
    }

    public enum LoggerMode {
        NEW_LINE,
        ONE_LINE;
    }
}
