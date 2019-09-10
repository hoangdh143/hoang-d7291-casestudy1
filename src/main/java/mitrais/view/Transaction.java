package mitrais.view;

import mitrais.model.Account;

import java.util.Scanner;

public class Transaction implements Screen {
    private Account account;
    private Welcome welcome;

    public Transaction(Welcome welcome, Account account) {
        setAccount(account);
        setWelcome(welcome);
    }

    public Transaction() {
    }

    @Override
    public void display() {
        Scanner in = new Scanner(System.in);

        System.out.print("1. Withdraw\n" +
                "2. Fund Transfer\n" +
                "3. Exit\n" +
                "Please choose option[3]:");
        int option = in.nextInt();
        switch (option) {
            case 1:
                new Withdraw(this, account).display();
                break;
            case 2:
                new FundTransfer(this, account).display();
                break;
            case 3:
                welcome.display();
                break;
            default:
                this.display();
        }
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Welcome getWelcome() {
        return welcome;
    }

    public void setWelcome(Welcome welcome) {
        this.welcome = welcome;
    }
}
