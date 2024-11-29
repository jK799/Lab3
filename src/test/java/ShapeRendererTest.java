import org.example.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class ShapeRendererTest {

    @Test
    void testShapeRenderer() {
        Shape rectangle = new Rectangle(4.0, 5.0, new Color(255, 0, 0));
        Shape triangle = new Triangle(3.0, 4.0, 5.0, new Color(0, 0, 255));
        ShapeRenderer renderer = new ShapeRenderer();

        renderer.render(List.of(rectangle, triangle));
        // Brak asercji, test weryfikuje brak wyjątków podczas renderowania
    }
}
