import java.util.Scanner;

class CyberPet {
    private String name;
    private int hunger;
    private int tiredness;

    public CyberPet(String name) {
        this.name = name;
        this.hunger = 0;
        this.tiredness = 0;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getTiredness() {
        return tiredness;
    }

    public void feed() {
        System.out.println(name + " is eating. Yummy!");
        hunger -= 10;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void play() {
        System.out.println(name + " is playing. Fun!");
        hunger += 5;
        tiredness += 10;
    }

    public void sleep() {
        System.out.println(name + " is sleeping. Zzz...");
        tiredness -= 15;
        if (tiredness < 0) {
            tiredness = 0;
        }
    }
}

public class CyberPetGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of your Cyber Pet: ");
        String petName = scanner.nextLine();

        CyberPet pet = new CyberPet(petName);

        while (true) {
            System.out.println("\n" + pet.getName() + "'s Stats:");
            System.out.println("Hunger: " + pet.getHunger());
            System.out.println("Tiredness: " + pet.getTiredness());

            System.out.println("\nActions:");
            System.out.println("1. Feed");
            System.out.println("2. Play");
            System.out.println("3. Sleep");
            System.out.println("4. Exit");

            System.out.print("Choose an action (1-4): ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        pet.feed();
                        break;
                    case 2:
                        pet.play();
                        break;
                    case 3:
                        pet.sleep();
                        break;
                    case 4:
                        System.out.println("Exiting the game. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please choose a number between 1 and 4.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Consume the newline character
            }
        }
    }
}
