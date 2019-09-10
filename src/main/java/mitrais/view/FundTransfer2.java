package mitrais.view;

import mitrais.model.Account;
import mitrais.model.TransferConfirmation;

import java.util.Scanner;

public class FundTransfer2 implements Screen {
    private TransferConfirmation transferConfirmation;
    private Screen previousScreen;

    public FundTransfer2(Screen previousScreen, TransferConfirmation transferConfirmation) {
        this.transferConfirmation = transferConfirmation;
        this.previousScreen = previousScreen;
    }

    @Override
    public void display() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter transfer amount and \n" +
                "press enter to continue or \n" +
                "press enter to go back to Transaction: ");
        String input = in.next();
        if (input.equals("")) {
            previousScreen.display();
        } else {
            transferConfirmation.setTransferAmount(input);
            new FundTransfer3(this, transferConfirmation).display();
        };
    }

    public Screen getPreviousScreen() {
        return previousScreen;
    }

    public void setPreviousScreen(Screen previousScreen) {
        this.previousScreen = previousScreen;
    }
}
