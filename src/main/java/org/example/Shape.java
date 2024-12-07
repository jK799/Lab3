package org.example;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Color color;

    // Konstruktor bezargumentowy wymagany przez Hibernate
    public Shape() {}

    // Konstruktor z argumentami
    public Shape(Color color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public String getColorDescription() {
        return "Czerwony: " + color.getRed() + ", Zielony: " + color.getGreen() + ", Niebieski: " + color.getBlue();
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void print();
}
