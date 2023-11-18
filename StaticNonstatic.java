// static methods
public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}

int result = MathUtils.add(5, 3);

// static fields
public class Counter {
    private static int count = 0;

    public Counter() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

Counter obj1 = new Counter();
Counter obj2 = new Counter();
int totalCount = Counter.getCount(); 

// non-static methods
public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void bark() {
        System.out.println(name + " says Woof!");
    }
}

Dog myDog = new Dog("Buddy");
myDog.bark(); 

// non-static fields
public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void displayModel() {
        System.out.println("Car model: " + model);
    }
}

// Usage
Car car1 = new Car("Toyota");
Car car2 = new Car("Honda");

car1.displayModel(); 
car2.displayModel();



