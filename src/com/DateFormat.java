package com;

public enum DateFormat {
    DMY("DMY"),
    MY("MY"),
    Y("Y");

    private String date;

    DateFormat(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}