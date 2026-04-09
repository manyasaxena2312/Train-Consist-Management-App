import java.util.*;
public class HandleInvalidBoggie {
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        private String name;
        private int capacity;

        public PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
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

        List<PassengerBogie> bogieList = new ArrayList<>();

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie b2 = new PassengerBogie("AC Chair", 56);
            PassengerBogie b3 = new PassengerBogie("First Class", 0);

            bogieList.add(b1);
            bogieList.add(b2);
            bogieList.add(b3);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nValid Bogies in Train:");
        for (PassengerBogie b : bogieList) {
            b.display();
        }
    }
}