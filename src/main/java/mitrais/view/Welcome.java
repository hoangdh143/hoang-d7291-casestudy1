package mitrais.view;

import lombok.Data;
import mitrais.model.Account;
import mitrais.repository.AccountRepoFactory;
import mitrais.repository.AccountRepository;
import mitrais.validator.AccountValidationContext;
import mitrais.validator.AccountValidationStrategy;
import mitrais.viewhandler.Dispatcher;

import java.util.Scanner;

@Data
public class Welcome implements View {
    private Dispatcher dispatcher;
    private AccountRepository accountRepository = AccountRepoFactory.getAccountRepository();

    public Welcome() {
    }

    @Override
    public void display() {
        AccountValidationContext context = new AccountValidationContext();
        Account account = new Account();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNumber = in.nextLine();
        account.setAccountNumber(accountNumber);
        context.addStrategy(AccountValidationStrategy.ACCOUNT_NUMBER);
        validate(account, context, this);

        System.out.print("Enter PIN: ");
        String pin = in.nextLine();
        account.setPin(pin);
        context.addStrategy(AccountValidationStrategy.PIN);
        validate(account, context, this);

        Account accountDb = accountRepository.get(account.getAccountNumber(), account.getPin());

        if (accountDb == null) {
            System.out.println("Invalid Account Number/PIN");
            this.display();
        }

        dispatcher.setAccount(accountDb);
        dispatcher.dispatch("TRANSACTION");
    }

    private void validate(Account account, AccountValidationContext context, View view) {
        String errorCode = context.execute(account);
        if (errorCode != null) {
            System.out.println(errorCode);
            view.display();
        }
    }
}
