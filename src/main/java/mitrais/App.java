package mitrais;

import mitrais.model.Account;
import mitrais.repository.AccountRepoFactory;
import mitrais.repository.AccountRepository;
import mitrais.repository.AccountRepositoryImpl;
import mitrais.view.Welcome;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AccountRepository accountRepository = new AccountRepositoryImpl();
        accountRepository.save(new Account("John Doe", "012108", 100, "112233"));
        accountRepository.save(new Account("Jane Doe","932012", 30, "112244"));
        AccountRepoFactory.setAccountRepository(accountRepository);

        new Welcome().display();
    }
}
