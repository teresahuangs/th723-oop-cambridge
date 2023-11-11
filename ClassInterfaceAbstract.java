// Example of a  class
public class Car {
    String model;
    int year;

    // Constructor
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    // Method
    public void start() {
        System.out.println("The car is starting.");
    }
}

// Example of an abstract class
public abstract class Shape {
    // Fields
    String color;

    // Constructor
    public Shape(String color) {
        this.color = color;
    }

    // Abstract method
    public abstract double calculateArea();
}

// Concrete subclass
public class Circle extends Shape {
    double radius;

    // Constructor
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // Implementation of abstract method
    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

// Example of an interface
public interface Animal {
    // Abstract method
    void makeSound();

    default void sleep() {
        System.out.println("Zzzz...");
    }
}

// Implementing the interface in a class
public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
