package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

public class ShapeCollectorTestSuite {
    @BeforeAll
    public static void beforeTests(){
        System.out.println("This is begining of tests");
    }
    @AfterAll
    public static void afterTests(){
        System.out.println("Tests finished");
    }

    @Nested
    @DisplayName("Tests for Circle")
    class TestCircle{

        @Test
        void testAddFigure(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Circle circle = new Circle(2.5);
            //When
            shapes.addFigure(circle);
            //Then
            Assertions.assertEquals(1,shapes.getFigures().size());
        }

        @Test
        void testRemoveFigure(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Circle circle = new Circle(2.5);
            shapes.addFigure(circle);
            //When
            boolean result = shapes.removeFigure(circle);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0,shapes.getFigures().size());
        }
        @Test
        void testGetFigure(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Circle circle = new Circle(2.5);
            shapes.addFigure(circle);
            //When
            Circle circle1 = (Circle) shapes.getFigure(0);
            //Then
            Assertions.assertEquals(circle1,circle);
        }
        @Test
        void testShowFigures(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Circle circle = new Circle(2.5);
            shapes.addFigure(circle);
            //When
            String figures = shapes.showFigures();
            String figureCircle = circle.getShape() +" with field : "+ circle.getField()+", ";
            //Then
            Assertions.assertEquals(figureCircle,figures);
        }
    }

    @Nested
    @DisplayName("Tests for Square")
    class TestSquare{

        @Test
        void testAddFigure(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Square square = new Square(2);
            //When
            shapes.addFigure(square);
            //Then
            Assertions.assertEquals(1,shapes.getFigures().size());
        }

        @Test
        void testRemoveFigure(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Square square = new Square(2);
            shapes.addFigure(square);
            //When
            boolean result = shapes.removeFigure(square);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0,shapes.getFigures().size());
        }
        @Test
        void testGetFigure(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Square square = new Square(2);
            shapes.addFigure(square);
            //When
            Square square1 = (Square) shapes.getFigure(0);
            //Then
            Assertions.assertEquals(square1,square);
        }
        @Test
        void testShowFigures(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Square square = new Square(2);
            shapes.addFigure(square);
            //When
            String figures = shapes.showFigures();
            String figureSquare = square.getShape()+" with field : "+ square.getField()+", ";
            //Then
            Assertions.assertEquals(figureSquare,figures);
        }
    }

    @Nested
    @DisplayName("Tests for Triangle")
    class TestTraingle{

        @Test
        void testAddFigure(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Triangle triangle = new Triangle(2.3, 5);
            //When
            shapes.addFigure(triangle);
            //Then
            Assertions.assertEquals(1,shapes.getFigures().size());
        }

        @Test
        void testRemoveFigure(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Triangle triangle = new Triangle(2.3,5);
            shapes.addFigure(triangle);
            //When
            boolean result = shapes.removeFigure(triangle);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0,shapes.getFigures().size());
        }
        @Test
        void testGetFigure(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Triangle triangle = new Triangle(2.3,5);
            shapes.addFigure(triangle);
            //When
            Triangle triangle1 = (Triangle) shapes.getFigure(0);
            //Then
            Assertions.assertEquals(triangle1,triangle);
        }
        @Test
        void testShowFigures(){
            //Given
            ShapeCollector shapes = new ShapeCollector();
            Triangle triangle = new Triangle(2.3,5);
            shapes.addFigure(triangle);
            //When
            String figures = shapes.showFigures();
            String figureTriangle = triangle.getShape()+" with field : "+ triangle.getField()+", ";
            //Then
            Assertions.assertEquals(figureTriangle,figures);
        }
    }
}
