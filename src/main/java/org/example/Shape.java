package org.example;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Shape {
    @Embedded
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getColorDescription() {
        return "Czerwony: " + color.Red() + ", Zielony: " + color.Green() + ", Niebieski: " + color.Blue();
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void print();
}
