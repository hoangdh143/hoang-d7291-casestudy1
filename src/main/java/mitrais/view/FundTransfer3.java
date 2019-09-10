package mitrais.view;

import mitrais.model.Account;
import mitrais.model.TransferConfirmation;

import java.util.Scanner;

public class FundTransfer3 implements Screen {
    private static String NUMERIC_STRING = "0123456789";
    private TransferConfirmation transferConfirmation;
    private Screen previousScreen;

    public FundTransfer3(Screen previousScreen, TransferConfirmation transferConfirmation) {
        this.previousScreen = previousScreen;
        this.transferConfirmation = transferConfirmation;
    }

    @Override
    public void display() {
        Scanner in = new Scanner(System.in);
        String refNumber = createRandomString();
        System.out.println(String.format("Reference Number: %s\n press enter to continue", refNumber));
        String accountNumber = in.nextLine();
        transferConfirmation.setReferenceNumber(refNumber);
        new FundTransfer4(transferConfirmation).display();
    }


    private String createRandomString() {
        int count = 6;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public Screen getPreviousScreen() {
        return previousScreen;
    }

    public void setPreviousScreen(Screen previousScreen) {
        this.previousScreen = previousScreen;
    }
}
