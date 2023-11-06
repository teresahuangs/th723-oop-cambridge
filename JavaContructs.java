public class JavaConstructsExample {
    public static void main(String[] args) {
        // Primitives
        int age = 30;           // Integer primitive
        double salary = 50000.0; // Double primitive
        boolean isStudent = true; // Boolean primitive
        char grade = 'A';        // Character primitive

        // References
        String name = "Alice"; // Reference to a String object
        ArrayList<Integer> numbers = new ArrayList<>(); // Reference to an ArrayList object
        MyCustomClass customObject = new MyCustomClass(); // Reference to an instance of a custom class

        // Classes
        class Person {
            String name;
            int age;
        }

        // Objects
        Person person1 = new Person(); 
        person1.name = "Bob";
        person1.age = 25;

    // Custom class example
    static class MyCustomClass {
    }
}
