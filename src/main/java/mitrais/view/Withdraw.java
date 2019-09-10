package mitrais.view;

import mitrais.model.Account;
import mitrais.model.TransactionSummary;
import mitrais.repository.AccountRepoFactory;
import mitrais.repository.AccountRepository;

import java.util.Scanner;

public class Withdraw implements Screen {
    private AccountRepository accountRepository = AccountRepoFactory.getAccountRepository();
    private Screen previousScreen;

    private Account account;
    public Withdraw(Screen previousScreen, Account account) {
        setAccount(account);
        setPreviousScreen(previousScreen);
    }

    @Override
    public void display() {
        Scanner in = new Scanner(System.in);
        System.out.print("1. $10\n" +
                "2. $50\n" +
                "3. $100\n" +
                "4. Other\n" +
                "5. Back\n" +
                "Please choose option[5]:");
        int option = in.nextInt();
        try {
            TransactionSummary transactionSummary;
            switch (option) {
                case 1:
                    transactionSummary = accountRepository.deduct(account, 10);
                    new Summary(this, transactionSummary).display();
                    break;
                case 2:
                    transactionSummary = accountRepository.deduct(account, 50);
                    new Summary(this, transactionSummary).display();
                    break;
                case 3:
                    transactionSummary = accountRepository.deduct(account, 100);
                    new Summary(this, transactionSummary).display();
                    break;
                case 4:
                    new OtherWithdraw().display();
                    break;
                case 5:
                    previousScreen.display();
                    break;
                default:
                    previousScreen.display();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.display();
        }
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
