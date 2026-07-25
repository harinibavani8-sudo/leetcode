public class ShapeAreaCalculator {

    // Interface
    interface Shape {
        double area();
    }

    // Circle class
    static class Circle implements Shape {
        private double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        public double area() {
            return Math.PI * radius * radius;
        }
    }

    // Rectangle class
    static class Rectangle implements Shape {
        private double length, width;

        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double area() {
            return length * width;
        }
    }

    // Main method
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        System.out.println("Circle Area = " + circle.area());
        System.out.println("Rectangle Area = " + rectangle.area());
    }
}
