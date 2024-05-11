package Assignment8;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class VendingMachineTests {

    private VendingMachine vendingMachine;

    @BeforeEach
    public void setUp() {
        vendingMachine = new VendingMachine();
        Map<String, Snack> snacks = Map.of(
                "Coke", new Snack("Coke", 1.50, 5)
        );
        vendingMachine.setSnacks(snacks);
    }

    @Test
    public void testDispenseWithSufficientFunds() {
        vendingMachine.selectSnack("Coke", 1);
        vendingMachine.insertCoin(2.00);
        vendingMachine.dispenseSnack();
        Snack coke = vendingMachine.getSnacks().get("Coke");
        assertEquals(4, coke.getSnackQuantity(), "Coke quantity should be reduced by one.");
    }

    @Test
    public void testDispenseWithInsufficientFunds() {
        vendingMachine.selectSnack("Coke", 1);
        vendingMachine.insertCoin(1.00); // Not enough for a Coke priced at $1.50
        vendingMachine.dispenseSnack();
        Snack coke = vendingMachine.getSnacks().get("Coke");
        assertEquals(5, coke.getSnackQuantity(), "Coke quantity should not change.");
    }
}
