package org.example;

import jakarta.persistence.Embeddable;

@Embeddable
public class Color {
    private int red;
    private int green;
    private int blue;

    public Color() {}

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
