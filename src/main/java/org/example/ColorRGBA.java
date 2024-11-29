package org.example;

public record ColorRGBA(int red, int green, int blue, int alpha) {
    public ColorRGBA {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255 || alpha < 0 || alpha > 255) {
            throw new IllegalArgumentException("Prosze podać wartość z przedziału 0 do 255");
        }
    }

    public ColorRGBA(int red, int green, int blue) {
        this(red, green, blue, 0);
    }
}
