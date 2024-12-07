package org.example;

import jakarta.persistence.Embeddable;

@Embeddable
public record Color(int Red, int Green, int Blue) {

    public Color {
        if (Red < 0 || Red > 255 || Green < 0 || Green > 255 || Blue < 0 || Blue > 255) {
            throw new IllegalArgumentException("Prosze podać wartość z przedziału 0 do 255");
        }
    }
}
