package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ShapeDAO {
    private final SessionFactory sessionFactory;

    // Konstruktor inicjalizujący Hibernate SessionFactory
    public ShapeDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    // Zapis obiektu Shape do bazy danych
    public void save(Shape shape) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(shape);
            transaction.commit();
        }
    }

    // Pobranie wszystkich obiektów danego typu (Rectangle/Triangle)
    public <T extends Shape> List<T> getAll(Class<T> shapeType) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from " + shapeType.getSimpleName(), shapeType).list();
        }
    }

    // Usuwanie obiektu z bazy danych
    public void delete(Shape shape) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(shape);
            transaction.commit();
        }
    }

    // Zamknięcie SessionFactory
    public void close() {
        sessionFactory.close();
    }
}
