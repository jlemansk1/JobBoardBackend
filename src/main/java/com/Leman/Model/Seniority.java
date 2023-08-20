package com.Leman.Model;

public enum Seniority {
    JUNIOR("Junior"),
    MID("Mid"),
    SENIOR("Senior");
    private final String value;

    Seniority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
