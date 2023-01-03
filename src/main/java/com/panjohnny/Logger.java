package com.panjohnny;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.ResourceBundle;

@SuppressWarnings("unused")
public class Logger implements System.Logger {

    private final String name;
    private LogFormat format = LogFormat.BLANK;
    private PrintStream stream = System.out;
    private LoggerMode mode = LoggerMode.NEW_LINE;

    public Logger(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isLoggable(Level level) {
        return true;
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
        if (isLoggable(level)) {

            stream.print("[" + getName() + "/" + level.getName() + "] ");

            switch (level) {
                case ERROR:
                     print(err(msg));
                    break;
                case WARNING:
                     print(warn(msg));
                    break;
                case DEBUG:
                     print(debug(msg));
                    break;
                case INFO:
                    print(info(msg));
                    break;
                default:
                     print(msg);
            }

            stream.print(Ansi.generateCode(Attribute.RED_TEXT()));
            thrown.printStackTrace(stream);
            stream.print(Ansi.generateCode(Attribute.REVERSE()));
        }
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String format, Object... params) {
        if (isLoggable(level)) {
            String msg = MessageFormat.format(format, params);

            stream.print("[" + getName() + "/" + level.getName() + "] ");

            switch (level) {
                case ERROR:
                     print(err(msg));
                    break;
                case WARNING:
                     print(warn(msg));
                    break;
                case DEBUG:
                     print(debug(msg));
                    break;
                case INFO:
                    print(info(msg));
                    break;
                default:
                     print(msg);
            }
        }
    }

    private String err(String msg) {
        return Ansi.colorize(msg, Attribute.RED_TEXT());
    }

    private String warn(String msg) {
        return Ansi.colorize(msg, Attribute.YELLOW_TEXT());
    }

    private String debug(String msg) {
        return Ansi.colorize(msg, Attribute.TEXT_COLOR(135, 135, 135));
    }

    private String info(String msg) {
        return Ansi.colorize(msg, Attribute.TEXT_COLOR(255, 255, 255));
    }

    private void print(String msg) {
        stream.print(format.format() + msg + mode.getValue());
    }

    public Logger setFormat(LogFormat format) {
        this.format = format;
        return this;
    }

    public Logger setStream(PrintStream stream) {
        this.stream = stream;
        return this;
    }

    public Logger setMode(LoggerMode mode) {
        this.mode = mode;
        return this;
    }

    public LogFormat getFormat() {
        return format;
    }

    public LoggerMode getMode() {
        return mode;
    }

    public PrintStream getStream() {
        return stream;
    }
}
