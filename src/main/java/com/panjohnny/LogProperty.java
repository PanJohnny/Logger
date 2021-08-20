package com.panjohnny;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogProperty {
    public static final LogProperty DATE_TIME = new LogProperty(() -> {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd' T:'HH:mm:ssZ");
        format.setTimeZone(Calendar.getInstance().getTimeZone());
        return format.format(new Date(System.currentTimeMillis()));
    });

    public static final LogProperty THREAD_NAME = new LogProperty(() -> Thread.currentThread().getName());

    public static final LogProperty BLANK = new LogProperty(() -> "");

    public static final LogProperty TIME_FROM_FIRST_LOG = new LogProperty(() -> {
        long first = Logger.getFirstLogTime();
        long time = System.currentTimeMillis() - first;
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        format.setTimeZone(Calendar.getInstance().getTimeZone());
        return format.format(new Date(time));
    });

    private LogProperty.Action action;
    public LogProperty(LogProperty.Action action) {
        this.action=action;
    }

    /**
     * @return value of action
     */
    public String get() {
        return action.parse();
    }

    public interface Action {
        /**
         * Do not include brackets so return: Thread-Name
         * @return Parsed action
         */
        String parse();
    }
}
