package mitrais.view;

import mitrais.model.Account;
import mitrais.model.TransactionSummary;
import mitrais.repository.AccountRepoFactory;
import mitrais.repository.AccountRepository;

import java.util.Scanner;

public class Summary implements Screen {
    private TransactionSummary transactionSummary;
    private Screen previousScreen;

    public Summary(Screen previousScreen, TransactionSummary transactionSummary) {
        setTransactionSummary(transactionSummary);
        setPreviousScreen(previousScreen);
    }

    @Override
    public void display() {
        Scanner in = new Scanner(System.in);
        String summary = String.format("Summary\n" +
                "Date : %s\n" +
                "Withdraw : %d\n" +
                "Balance : %d\n" +
                "\n" +
                "1. Transaction \n" +
                "2. Exit\n" +
                "Choose option[2]:",
                transactionSummary.getDate(),
                transactionSummary.getWithDraw(),
                transactionSummary.getBalance());
        System.out.println(summary);
        int option = in.nextInt();
        switch (option) {
            case 1:
                previousScreen.display();
                break;
            case 2:
                new Welcome().display();
                break;
            default:
                new Welcome().display();
                break;
        }
    }

    public TransactionSummary getTransactionSummary() {
        return transactionSummary;
    }

    public void setTransactionSummary(TransactionSummary transactionSummary) {
        this.transactionSummary = transactionSummary;
    }

    public Screen getPreviousScreen() {
        return previousScreen;
    }

    public void setPreviousScreen(Screen previousScreen) {
        this.previousScreen = previousScreen;
    }
}
