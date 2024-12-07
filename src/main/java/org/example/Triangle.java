package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "triangles")
public class Triangle extends Shape {
    private double a, b, c;

    // Konstruktor bezargumentowy (dla Hibernate)
    public Triangle() {}

    // Konstruktor z argumentami
    public Triangle(double a, double b, double c, Color color) {
        super(color); // Wywołanie konstruktora klasy Shape
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public void print() {
        System.out.println("Trójkąt o kolorze: " + getColorDescription());
    }
}
