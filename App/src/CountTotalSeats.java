import java.util.*;
public class CountTotalSeats {
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

        // Create bogie list
        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("Sleeper", 72)); // extra

        // 🔹 Stream pipeline: map + reduce
        int totalSeats = bogieList.stream()
                .map(b -> b.getCapacity())        // extract capacity
                .reduce(0, Integer::sum);         // sum all values

        // Display total seating capacity
        System.out.println("Total Seating Capacity of Train: " + totalSeats);

        // 🔹 Verify original list unchanged
        System.out.println("\nOriginal Bogie List:");
        for (Bogie b : bogieList) {
            b.display();
        }
    }
}