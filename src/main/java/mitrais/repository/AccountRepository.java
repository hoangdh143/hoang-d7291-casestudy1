package mitrais.repository;

import mitrais.exception.*;
import mitrais.model.Account;
import mitrais.model.TransactionSummary;
import mitrais.model.TransferSummary;

public interface AccountRepository {
    Account save(Account account);
    Account update(Account account);
    Account get(String accountNumber, String pin);

    TransactionSummary deduct(Account account, int i) throws BalanceInsufficientException, MaximumAmountException, InvalidAmountException;

    TransferSummary transfer(String accountNumber, String destinationAccount, String transferAmount, String refNumber) throws
            InvalidAccountException, MaximumAmountException, MinimumAmountException, InvalidAmountException,
            BalanceInsufficientException, InvalidRefNumberException;
}