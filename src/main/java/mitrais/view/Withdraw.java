package mitrais.view;

import lombok.Data;
import mitrais.model.Account;
import mitrais.model.TransactionSummary;
import mitrais.repository.AccountRepoFactory;
import mitrais.repository.AccountRepository;
import mitrais.viewhandler.Dispatcher;

import java.util.Scanner;

@Data
public class Withdraw implements View {
    private Dispatcher dispatcher;
    private AccountRepository accountRepository = AccountRepoFactory.getAccountRepository();

    public Withdraw() {
    }

    @Override
    public void display() {
        Account account = dispatcher.getAccount();
        Scanner in = new Scanner(System.in);
        System.out.print("1. $10\n" +
                "2. $50\n" +
                "3. $100\n" +
                "4. Other\n" +
                "5. Back\n" +
                "Please choose option[5]:");
        String option = in.nextLine();
        try {
            TransactionSummary transactionSummary;
            switch (option) {
                case "1":
                    transactionSummary = accountRepository.deduct(account, 10);
                    dispatcher.setTransactionSummary(transactionSummary);
                    dispatcher.dispatch("SUMMARY");
                    break;
                case "2":
                    transactionSummary = accountRepository.deduct(account, 50);
                    dispatcher.setTransactionSummary(transactionSummary);
                    dispatcher.dispatch("SUMMARY");
                    break;
                case "3":
                    transactionSummary = accountRepository.deduct(account, 100);
                    dispatcher.setTransactionSummary(transactionSummary);
                    dispatcher.dispatch("SUMMARY");
                    break;
                case "4":
                    dispatcher.dispatch("OTHERWITHDRAW");
                    break;
                case "5":
                    dispatcher.dispatch("TRANSACTION");
                    break;
                default:
                    dispatcher.dispatch("TRANSACTION");
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.display();
        }
    }
}
