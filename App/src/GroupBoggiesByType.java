import java.util.*;
import java.util.stream.Collectors;

public class GroupBoggiesByType {
    // Inner Bogie class
    static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        public void display() {
            System.out.println(name + " Bogie - Capacity: " + capacity);
        }
    }

    public static void main(String[] args) {

        // Reuse bogie list
        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("Sleeper", 72));   // duplicate for grouping test
        bogieList.add(new Bogie("AC Chair", 56));  // duplicate

        // 🔹 Group bogies by type (name)
        Map<String, List<Bogie>> groupedBogies =
                bogieList.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        // Display grouped result
        System.out.println("Grouped Bogies by Type:\n");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                b.display();
            }
            System.out.println();
        }

        // 🔹 Verify original list unchanged
        System.out.println("Original Bogie List:");
        for (Bogie b : bogieList) {
            b.display();
        }
    }
}