import java.util.*;

// Bogie class
class Bogie {
    private String type;
    private int capacity;

    // Constructor
    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    // Getter for capacity
    public int getCapacity() {
        return capacity;
    }

    // Display method
    public void display() {
        System.out.println("Type: " + type + ", Capacity: " + capacity);
    }
}

// Main class
public class TrainBogieSorting {
    public static void main(String[] args) {

        // Create list of bogies
        List<Bogie> bogieList = new ArrayList<>();

        // Add passenger bogies
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));

        // Sort bogies by capacity using Comparator and Lambda
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Display sorted bogies
        System.out.println("Bogies Sorted by Capacity (Ascending):");
        for (Bogie b : bogieList) {
            b.display();
        }
    }
}