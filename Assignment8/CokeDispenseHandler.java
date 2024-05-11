package Assignment8;

public class CokeDispenseHandler extends SnackDispenseHandler {

    public CokeDispenseHandler(SnackDispenseHandler handler){
        super(handler);
    }

    @Override
    public void dispenseSnack(Snack snack, int quantity){
        if(snack.getSnackName().equalsIgnoreCase("coke")){
            System.out.printf("This is your %s%n", snack.getSnackName());
            System.out.printf("Thank you for your order. See you soon.\n");
            snack.setSnackQuantity(snack.getSnackQuantity() - quantity);
        }else{
            super.dispenseSnack(snack, quantity);
        }
    }
}
