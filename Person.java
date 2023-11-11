public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Override the toString() method to change the output
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName;
    }

}

public class Main {
    public void testOutput() {
        Person p = new Person("Joe", "Bloggs");
        System.out.println("Person details: " + p);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.testOutput();
    }
}
