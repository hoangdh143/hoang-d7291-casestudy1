package mitrais.view;

import mitrais.model.Account;
import mitrais.repository.AccountRepoFactory;
import mitrais.repository.AccountRepository;
import mitrais.validator.AccountValidationContext;
import mitrais.validator.AccountValidationStrategy;
import mitrais.validator.ValidationStrategy;
import mitrais.validator.ValidationType;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import static jdk.nashorn.internal.runtime.regexp.RegExpFactory.validate;

public class Welcome implements Screen {
    private AccountRepository accountRepository = AccountRepoFactory.getAccountRepository();

    public Welcome() {
    }

    @Override
    public void display() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNumber = in.next();

        System.out.print("Enter PIN: ");
        String pin = in.next();

        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setPin(pin);

        Set<ValidationStrategy> strategies = new LinkedHashSet<ValidationStrategy>();
        strategies.add(AccountValidationStrategy.ACCOUNT_NUMBER);
        strategies.add(AccountValidationStrategy.PIN);

        AccountValidationContext context = new AccountValidationContext(strategies);
        String errorCode = context.execute(account);
        if (errorCode != null) {
            System.out.println(errorCode);
            this.display();
        } else {
            Account accountDb = accountRepository.get(account.getAccountNumber(), account.getPin());
            if (accountDb == null) {
                System.out.println("Invalid Account Number/PIN");
                this.display();
            }
            new Transaction(this, accountDb).display();
        }
    }
}
