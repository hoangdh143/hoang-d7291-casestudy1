package mitrais;

import mitrais.repository.AccountRepoFactory;
import mitrais.repository.AccountRepositoryImpl;
import mitrais.viewhandler.FrontController;
import mitrais.viewhandler.FrontControllerImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AccountRepoFactory.setAccountRepository(new AccountRepositoryImpl());
        FrontController frontController = new FrontControllerImpl();
        frontController.goToView("WELCOME");
    }
}
