package com.jmb.email.dictionaries;

public enum Pages {

    HOME("index"),
    INBOX_FOLDERS("inbox-page");

    String page;

    Pages(String page) {
        this.page = page;
    }

    public final String getPage() {
        return page;
    }
}
