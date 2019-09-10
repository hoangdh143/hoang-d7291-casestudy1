package mitrais.view;

import mitrais.model.Account;
import mitrais.model.TransferConfirmation;

import java.util.Scanner;

public class FundTransfer implements Screen {
    private Account account;
    private Screen previousScreen;

    public FundTransfer(Screen previousScreen, Account account) {
        setAccount(account);
        setPreviousScreen(previousScreen);
    }

    @Override
    public void display() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter destination account and press enter to continue or \n" +
                "press enter to go back to Transaction: ");
        String accountNumber = in.next();
        if (accountNumber.equals("")) {
            previousScreen.display();
        } else {
            TransferConfirmation transferConfirmation = new TransferConfirmation(account, accountNumber, "");
            new FundTransfer2(previousScreen, transferConfirmation).display();
        };
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Screen getPreviousScreen() {
        return previousScreen;
    }

    public void setPreviousScreen(Screen previousScreen) {
        this.previousScreen = previousScreen;
    }
}
