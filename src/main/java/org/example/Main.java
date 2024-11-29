package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tworzenie kolorów
        Color czerwony = new Color(255, 0, 0);
        Color zielony = new Color(0, 255, 0);
        Color niebieski = new Color(0, 0, 255);

        // Tworzenie figur
        Shape prostokat = new Rectangle(4.0, 5.0, czerwony);
        Shape trojkat = new Triangle(3.0, 4.0, 5.0, niebieski);
        Shape duzyProstokat = new Rectangle(10.0, 20.0, zielony);

        // Opis figur z logowaniem
        ShapeDescriber opisFigur = new ShapeDescriber();

        opisFigur.describe(prostokat);
        opisFigur.describe(trojkat);
        opisFigur.describe(duzyProstokat);

        // Dodanie figur do listy
        List<Shape> shapes = new ArrayList<>();
        shapes.add(prostokat);
        shapes.add(trojkat);
        shapes.add(duzyProstokat);

        // Renderowanie figur
        ShapeRenderer renderer = new ShapeRenderer();
        renderer.render(shapes);
    }
}
