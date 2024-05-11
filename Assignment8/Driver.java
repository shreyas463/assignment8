package Assignment8;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        Map<String, Snack> snacks = createSnacks();
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setSnacks(snacks);

        // Case 1: Successful transaction with change returned to customer
        executeScenario(vendingMachine, "Pepsi", 3, 10, "ENOUGH MONEY AND QUANTITY");

        // Case 2: Not enough money inserted inside the vending machine
        executeScenario(vendingMachine, "Doritos", 4, 2.55, "NOT ENOUGH MONEY");

        // Case 3: Successful transaction with exact amount
        executeScenario(vendingMachine, "Snickers", 4, 10, "QUANTITY HITS 0 WITH SNICKERS");

        // Case 3.1: Attempting to buy more than available in stock.
        executeScenario(vendingMachine, "Snickers", 5, 15, "NO MORE QUANTITY OF SNACK");
    }

    private static void executeScenario(VendingMachine vendingMachine, String snackName, int quantity, double coin, String caseDescription) {
        System.out.println("\n--------------------" + caseDescription + "--------------------");
        vendingMachine.selectSnack(snackName, quantity);
        vendingMachine.insertCoin(coin);
        vendingMachine.dispenseSnack();
    }

    public static Map<String, Snack> createSnacks() {
        Map<String, Snack> snacks = new HashMap<>();
        snacks.put("Pepsi", new Snack("Pepsi", 1.79, 6));
        snacks.put("Coke", new Snack("Coke", 1.89, 6));
        snacks.put("Cheetos", new Snack("Cheetos", 2.95, 6));
        snacks.put("Doritos", new Snack("Doritos", 3.00, 7));
        snacks.put("KitKat", new Snack("KitKat", 1.79, 3));
        snacks.put("Snickers", new Snack("Snickers", 1.89, 4));

        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Available Snacks:");
        for (Map.Entry<String, Snack> entry : snacks.entrySet()) {
            Snack snack = entry.getValue();
            System.out.printf("%-10s | Quantity: %-5d | Price: $%-5.2f each\n", snack.getSnackName(), snack.getSnackQuantity(), snack.getSnackPrice());
        }
        System.out.println();
        return snacks;
    }
}
