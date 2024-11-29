import org.example.Color;
import org.example.Rectangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testRectangleArea() {
        Rectangle rectangle = new Rectangle(4.0, 5.0, new Color(255, 0, 0));
        assertEquals(20.0, rectangle.getArea());
    }

    @Test
    void testRectanglePerimeter() {
        Rectangle rectangle = new Rectangle(4.0, 5.0, new Color(255, 0, 0));
        assertEquals(18.0, rectangle.getPerimeter());
    }

    @Test
    void testRectangleColor() {
        Rectangle rectangle = new Rectangle(4.0, 5.0, new Color(255, 0, 0));
        assertEquals("Czerwony: 255, Zielony: 0, Niebieski: 0", rectangle.getColorDescription());
    }
}
