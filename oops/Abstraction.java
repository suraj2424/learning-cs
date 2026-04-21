package oops;

abstract class Shape {
    
    // Shape() {
    //     System.out.println("I am Shape.");
    // } 
    
    abstract void area();

    void display() {
        System.out.println("This is a shape");
    }

}

class Circle extends Shape {
    double radius;
    Circle(double r) {
        this.radius = r;
    }
    void area() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of circle: " + area);
    }

}

class Rectangle extends Shape {
    double length, width;
    Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }
    void area() {
        double area = length * width;
        System.out.println("Area of rectangle: " + area);
    }
}

public class Abstraction {
    public static void main(String[] args) {
        // Shape sh1 = new Shape();
        // ❌ Compile Time Error: Cannot Instantiate it.
        
        
        Shape s1 = new Circle(2);
        s1.area();

        Shape s2 = new Rectangle(2, 3);
        s2.area();

    }
}
