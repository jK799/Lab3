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

        // Inicjalizacja DAO
        ShapeDAO shapeDAO = new ShapeDAO();

        // Zapis figur do bazy danych
        shapeDAO.save(prostokat);
        shapeDAO.save(trojkat);
        shapeDAO.save(duzyProstokat);
        System.out.println("Figury zapisano do bazy danych.");

        // Odczyt prostokątów z bazy danych
        List<Rectangle> rectangles = shapeDAO.getAll(Rectangle.class);
        System.out.println("Prostokąty odczytane z bazy danych:");
        for (Rectangle rectangle : rectangles) {
            opisFigur.describe(rectangle);
        }

        // Odczyt trójkątów z bazy danych
        List<Triangle> triangles = shapeDAO.getAll(Triangle.class);
        System.out.println("Trójkąty odczytane z bazy danych:");
        for (Triangle triangle : triangles) {
            opisFigur.describe(triangle);
        }

        // Zamknięcie DAO
        shapeDAO.close();
    }
}
