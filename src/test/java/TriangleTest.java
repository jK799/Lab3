import org.example.Color;
import org.example.Triangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void testTriangleArea() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, new Color(0, 0, 255));
        assertEquals(6.0, triangle.getArea(), 0.001);
    }

    @Test
    void testTrianglePerimeter() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, new Color(0, 0, 255));
        assertEquals(12.0, triangle.getPerimeter());
    }

    @Test
    void testTriangleColor() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, new Color(0, 0, 255));
        assertEquals("Czerwony: 0, Zielony: 0, Niebieski: 255", triangle.getColorDescription());
    }
}
