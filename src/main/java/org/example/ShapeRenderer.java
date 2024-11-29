package org.example;

import java.util.List;

class ShapeRenderer {

    public void render(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println("Rysuję figurę: " + shape.getClass().getSimpleName());
            System.out.println("Kolor: " + shape.getColorDescription());

            // Polimorficzne rysowanie w zależności od typu figury
            if (shape instanceof Rectangle) {
                drawRectangle((Rectangle) shape);
            } else if (shape instanceof Triangle) {
                drawTriangle((Triangle) shape);
            } else {
                System.out.println("Nieobsługiwany typ figury!");
            }
            System.out.println(); // Oddzielenie kształtów
        }
    }

    private void drawRectangle(Rectangle rectangle) {
        int height = (int) rectangle.getHeight(); // Użycie rzeczywistej wysokości
        int width = (int) rectangle.getWidth();   // Użycie rzeczywistej szerokości

        for (int i = 0; i < height; i++) {
            System.out.println("*".repeat(width));
        }
    }


    private void drawTriangle(Triangle triangle) {
        int base = 10; // Przykładowa szerokość podstawy
        for (int i = 1; i <= base; i++) {
            System.out.println(" ".repeat(base - i) + "*".repeat(2 * i - 1));
        }
    }
}
