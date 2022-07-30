abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {

    double side1;
    double side2;
    double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * ((halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3)));
    }

}

class Rectangle extends Shape {

    double side1;
    double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    double getPerimeter() {
        return (side1 * 2) + (side2 * 2);
    }

    @Override
    double getArea() {
        return side1 * side2;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double getArea() {
        return Math.PI * (radius * radius);
    }

}