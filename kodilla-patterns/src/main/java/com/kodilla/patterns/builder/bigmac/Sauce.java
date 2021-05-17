package com.kodilla.patterns.builder.bigmac;

public class Sauce {
    public static final String STANDARD = "STANDARD";
    public static final String THOUSANDISLANDDRESSING = "THOUSAND ISLAND DRESSING";
    public static final String BARBACUE = "BARBACUE";
    private final String sauce;

    public Sauce(String sauce) {
        if(sauce.equals(STANDARD) ||
                sauce.equals(THOUSANDISLANDDRESSING) ||
                sauce.equals(BARBACUE)) {
            this.sauce = sauce;
        } else {
            throw new IllegalStateException("Please choose correct type of sauce");
        }
    }

    public String getSauce() {
        return sauce;
    }
}
