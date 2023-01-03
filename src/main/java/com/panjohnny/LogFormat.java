package com.panjohnny;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class LogFormat {
    private final String format;
    private final char propertyRegex;
    private final LogProperty[] properties;
    private final List<Integer> indexes = new ArrayList<>();
    
    public static final LogFormat BLANK = new LogFormat("", '0', LogProperty.BLANK);
    /**
     * Creates new log format you can do something like [%] \<%\>: etc.
     * @param format format of the log replace every property with propertyRegex
     * @param properties all properties in order
     * @param propertyRegex regex of property such as % so
     */
    public LogFormat(String format, char propertyRegex, LogProperty... properties) {
        this.format=format;
        this.properties = properties;
        this.propertyRegex = propertyRegex;
        for (int i = 0; i < format.length(); i++) {
            if(format.charAt(i)==propertyRegex) indexes.add(i);
            if(indexes.size()>properties.length) break;
        }
    }

    /**
     * Formats all properties
     * @return yes
     */
    public String format() {
        StringBuilder result = new StringBuilder();
        if(properties[0] == LogProperty.BLANK) return getFormat();
        int propertyNum = 0;
        for (int i = 0; i < format.length(); i++) {
            if(indexes.contains(i) && propertyNum < properties.length) {
                LogProperty p = properties[propertyNum];
                result.append(p.get());
                propertyNum++;
            } else {
                result.append(format.charAt(i));
            }
        }
        return result.toString();
    }

    public String getFormat() {
        return format;
    }

    public char getPropertyRegex() {
        return propertyRegex;
    }

    public LogProperty[] getProperties() {
        return properties;
    }
}
