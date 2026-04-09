
import java.util.*;

public class SaveCargo {
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        private String type;
        private String cargo;

        public GoodsBogie(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        public void assignCargo(String cargo) {
            try {
                if (type.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe: Petroleum cannot be assigned to Rectangular bogie");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully: " + cargo + " to " + type + " bogie");

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo assignment attempt completed for " + type + " bogie\n");
            }
        }
    }

    public static void main(String[] args) {

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        b1.assignCargo("Petroleum");
        b2.assignCargo("Petroleum");
        b2.assignCargo("Coal");

        System.out.println("Program continues safely...");
    }
}
