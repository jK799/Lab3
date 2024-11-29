package org.example;

public class Main {
    public static void main(String[] args) {
        // Tworzenie kolorów
        Color red = new Color(255, 0, 0);
        Color blue = new Color(0, 0, 255);

        // Tworzenie figur
        Shape rectangle = new Rectangle(4.0, 5.0, red);
        Shape triangle = new Triangle(3.0, 4.0, 5.0, blue);

        // Opis figur
        ShapeDescriber describer = new ShapeDescriber();

        
        System.out.println("Prostokąt:");
        describer.describe(rectangle);

        System.out.println("\nTrójkąt:");
        describer.describe(triangle);
    }
}
