package Assignment8;

public class DispensingState implements StateOfVendingMachine{

    private VendingMachine vendingMachine;
    private SnackDispenseHandler snackDispenseHandler;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        snackDispenseHandler = new CokeDispenseHandler(
                new PepsiDispenseHandler(new CheetosDispenseHandler(
                        new DoritosDispenseHandler(new KitKatDispenseHandler(new SnickersDispenseHandler(null))))));
    }

    @Override
    public void selectSnack(String snackName, int quantity) {
        System.out.println("You can't pick another snack until you receive your previous snack.");
    }

    @Override
    public void insertCoin(double userPaidAmount) {
        System.out.println("You can't insert another coin until you receive your snack.");
    }

    @Override
    public void dispenseSnack() {
        Snack selectedSnack = vendingMachine.getSelectedSnack();
        int quantity = vendingMachine.getSelectedSnackQuantity();
        if (selectedSnack.getSnackQuantity() >= quantity) {
            snackDispenseHandler.dispenseSnack(selectedSnack, quantity);
            vendingMachine.setState(new IdleState(vendingMachine));
        } else {
            System.out.println("Insufficient stock to fulfill your order. Please try a different snack or quantity.");
            vendingMachine.setState(new IdleState(vendingMachine));
        }
    }


}
