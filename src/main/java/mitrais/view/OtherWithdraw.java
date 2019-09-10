package mitrais.view;

import lombok.Data;
import mitrais.model.Account;
import mitrais.model.TransactionSummary;
import mitrais.repository.AccountRepoFactory;
import mitrais.repository.AccountRepository;
import mitrais.viewhandler.Dispatcher;

import java.util.Scanner;

@Data
public class OtherWithdraw implements View {
    private Dispatcher dispatcher;
    private AccountRepository accountRepository = AccountRepoFactory.getAccountRepository();

    @Override
    public void display() {
        Account account = dispatcher.getAccount();
        Scanner in = new Scanner(System.in);
        System.out.println("Other Withdraw\n" +
                "Enter amount to withdraw:");
        String input = in.nextLine();
        try {
            int amount = Integer.parseInt(input);
            TransactionSummary transactionSummary;
            transactionSummary = accountRepository.deduct(account, amount);
            dispatcher.setTransactionSummary(transactionSummary);
            dispatcher.dispatch("SUMMARY");
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount");
            this.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.display();
        }
    }
}
