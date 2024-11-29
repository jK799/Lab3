package org.example;

abstract class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getColorDescription() {
        return "Red: " + color.Red() + ", Green: " + color.Green() + ", Blue: " + color.Blue();
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void print();
}
