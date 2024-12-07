package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "triangles")
public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c, Color color) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
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
