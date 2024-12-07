import org.example.Color;
import org.example.Rectangle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShapeDAOTest {
    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    static void setup() {
        // Ustawienie fabryki sesji Hibernate
        sessionFactory = new Configuration().configure("hibernate-test.cfg.xml").buildSessionFactory();
    }

    @BeforeEach
    void openSession() {
        // Otwieranie sesji przed każdym testem
        session = sessionFactory.openSession();
    }

    @AfterEach
    void closeSession() {
        // Zamknięcie sesji po każdym teście
        if (session != null) {
            session.close();
        }
    }

    @AfterAll
    static void teardown() {
        // Zamknięcie fabryki sesji po wszystkich testach
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    void testTableCreation() {
        // Sprawdzenie, czy tabela została poprawnie utworzona
        Transaction transaction = session.beginTransaction();
        Rectangle rectangle = new Rectangle(4.0, 5.0, new Color(255, 0, 0));
        session.save(rectangle);
        transaction.commit();

        List<Rectangle> rectangles = session.createQuery("from Rectangle", Rectangle.class).list();
        assertFalse(rectangles.isEmpty(), "Tabela rectangles nie została poprawnie utworzona.");
    }

    @Test
    void testInsertAndRetrieve() {
        Transaction transaction = session.beginTransaction();
        Rectangle rectangle = new Rectangle(4.0, 5.0, new Color(0, 255, 0));
        session.save(rectangle);
        transaction.commit();

        List<Rectangle> rectangles = session.createQuery("from Rectangle", Rectangle.class).list();
        assertEquals(1, rectangles.size(), "Nie zapisano obiektu do tabeli.");
        assertEquals(4.0, rectangles.get(0).getWidth());
    }

    @Test
    void testUpdate() {
        Transaction transaction = session.beginTransaction();
        Rectangle rectangle = new Rectangle(4.0, 5.0, new Color(0, 0, 255));
        session.save(rectangle);
        transaction.commit();

        transaction = session.beginTransaction();
        rectangle.setWidth(10.0);
        session.update(rectangle);
        transaction.commit();

        Rectangle updatedRectangle = session.get(Rectangle.class, rectangle.getId());
        assertEquals(10.0, updatedRectangle.getWidth(), "Aktualizacja obiektu nie powiodła się.");
    }

    @Test
    void testDelete() {
        Transaction transaction = session.beginTransaction();
        Rectangle rectangle = new Rectangle(4.0, 5.0, new Color(255, 255, 0));
        session.save(rectangle);
        transaction.commit();

        transaction = session.beginTransaction();
        session.delete(rectangle);
        transaction.commit();

        Rectangle deletedRectangle = session.get(Rectangle.class, rectangle.getId());
        assertNull(deletedRectangle, "Usunięcie obiektu z tabeli nie powiodło się.");
    }
}
