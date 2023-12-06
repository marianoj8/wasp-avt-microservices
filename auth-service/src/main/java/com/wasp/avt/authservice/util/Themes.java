package com.wasp.avt.authservice.util;

public enum Themes {
    LIGHT("light-theme"),
    DARK("dark-theme");

    private final String theme;

    Themes(String theme) {
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return theme;
    }
}
