package mitrais.view;

import lombok.Data;
import mitrais.model.Account;
import mitrais.repository.AccountRepoFactory;
import mitrais.repository.AccountRepository;
import mitrais.validator.AccountValidationContext;
import mitrais.validator.AccountValidationStrategy;
import mitrais.validator.ValidationStrategy;
import mitrais.viewhandler.Dispatcher;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

@Data
public class Welcome implements View {
    private Dispatcher dispatcher;
    private AccountRepository accountRepository = AccountRepoFactory.getAccountRepository();

    public Welcome() {
    }

    @Override
    public void display() {
        Set<ValidationStrategy> strategies = new LinkedHashSet<ValidationStrategy>();
        strategies.add(AccountValidationStrategy.ACCOUNT_NUMBER);
        strategies.add(AccountValidationStrategy.PIN);

        AccountValidationContext context = new AccountValidationContext(strategies);
        Account account = new Account();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNumber = in.nextLine();
        account.setAccountNumber(accountNumber);
        validate(account, context, this);

        System.out.print("Enter PIN: ");
        String pin = in.nextLine();
        account.setPin(pin);
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
