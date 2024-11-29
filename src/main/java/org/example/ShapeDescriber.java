package org.example;

class ShapeDescriber {

    public void describe(Shape shape) {
        shape.print(); // Wyświetla nazwę figury
        System.out.println("Pole: " + shape.getArea());
        System.out.println("Obwód: " + shape.getPerimeter());
    }
}
