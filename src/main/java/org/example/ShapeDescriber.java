package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ShapeDescriber {
    private static final Logger logger = LoggerFactory.getLogger(ShapeDescriber.class);

    public void describe(Shape shape) {
        // Logowanie podstawowych informacji o figurze
        logger.info("Opis figury: {}", shape.getClass().getSimpleName());
        logger.info("Kolor: {}", shape.getColorDescription());
        logger.info("Pole: {}", shape.getArea());
        logger.info("Obwód: {}", shape.getPerimeter());

        // Wywołanie metody print (opcjonalne)
        shape.print();
    }
}
