public interface Workable {
    void work();
}

// Class representing an employee
public class Employee implements Workable {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println(name + " is working as an employee.");
    }

}

// Class representing a ninja
public class Ninja implements Workable {
    private String ninjaName;

    public Ninja(String ninjaName) {
        this.ninjaName = ninjaName;
    }

    @Override
    public void work() {
        System.out.println(ninjaName + " is performing ninja duties.");
    }

}

// Class representing an employee who is also a ninja
public class NinjaEmployee implements Workable {
    private Employee employee;
    private Ninja ninja;

    public NinjaEmployee(String name, String ninjaName) {
        this.employee = new Employee(name);
        this.ninja = new Ninja(ninjaName);
    }

    @Override
    public void work() {
        // Delegate work to both employee and ninja
        employee.work();
        ninja.work();
    }

}

public class Main {
    public static void main(String[] args) {
        // Create a NinjaEmployee
        NinjaEmployee ninjaEmployee = new NinjaEmployee("John Doe", "Shadow");

        // Call the common work method
        ninjaEmployee.work();
    }
}
