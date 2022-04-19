package com.jmb.email.dictionaries;

/**
 * Enum dictionary class contains common or default folder names.
 *
 * @author JuanMBruno
 */
public enum Folders {

    INBOX("Inbox", "white"),
    SENT("Sent", "blue"),
    IMPORTANT("Important", "green");

    String name;
    String color;

    Folders(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}

