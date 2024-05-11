package Assignment8;


public class SnickersDispenseHandler extends SnackDispenseHandler {

    public SnickersDispenseHandler(SnackDispenseHandler handler){
        super(handler);
    }

    @Override
    public void dispenseSnack(Snack snack, int quantity){
        if(snack.getSnackName().equalsIgnoreCase("snickers")){
            System.out.printf("This is your %s%n", snack.getSnackName());
            System.out.printf("Thank you for your order. See you soon.\n");
            snack.setSnackQuantity(snack.getSnackQuantity() - quantity);
        }else{
            super.dispenseSnack(snack, quantity);
        }
    }
}

