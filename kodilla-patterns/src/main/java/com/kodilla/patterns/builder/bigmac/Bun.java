package com.kodilla.patterns.builder.bigmac;

public class Bun {
    public static final String SEASAM = "SEASAM";
    public static final String NOSEASAM ="NO SEASAM";
    private final String bunType;

    public Bun(String bunType) {

        if(bunType.equals(SEASAM) || bunType.equals(NOSEASAM)) {
            this.bunType = bunType;
        } else {
            throw new IllegalStateException("Please choose correct type of bun");
        }
    }

    public String getBunType() {
        return bunType;
    }
}
