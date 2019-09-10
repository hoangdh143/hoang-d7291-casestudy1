package mitrais.repository;

import mitrais.exception.*;
import mitrais.model.Account;
import mitrais.model.TransactionSummary;
import mitrais.model.TransferSummary;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    private static HashMap<String, Account> accountList = new HashMap<>();

    @Override
    public Account save(Account account) {
       accountList.put(account.getAccountNumber(), account);
       return account;
    }

    @Override
    public Account update(Account account) {
        accountList.put(account.getAccountNumber(), account);
        return account;
    }

    @Override
    public Account get(String accountNumber, String pin) {
        Account account = accountList.get(accountNumber);
        if (account == null) return null;
        if (!account.getPin().equals(pin)) return null;
        return account;
    }

    @Override
    public TransactionSummary deduct(Account account, int i) throws BalanceInsufficientException, MaximumAmountException, InvalidAmountException {
        if (i % 10 != 0) throw new InvalidAmountException("Invalid ammount");
        if (i > 1000) throw new MaximumAmountException("Maximum amount to withdraw is $1000");
        Account accoundDb = accountList.get(account.getAccountNumber());
        if (accoundDb != null) {
            if (i > accoundDb.getBalance()) throw new BalanceInsufficientException("Insufficient balance $" + i);
            accoundDb.setBalance(accoundDb.getBalance() - i);
            accountList.put(accoundDb.getAccountNumber(), accoundDb);
        }
        return new TransactionSummary(new Date(), i, accoundDb.getBalance());
    }

    @Override
    public TransferSummary transfer(String accountNumber, String destinationAccount, String transferAmount, String refNumber) throws InvalidAccountException, MaximumAmountException, MinimumAmountException, InvalidAmountException, BalanceInsufficientException, InvalidRefNumberException {
        try {Integer.parseInt(accountNumber);} catch (NumberFormatException e) {throw new InvalidAccountException("Invalid account");}
        try {Integer.parseInt(destinationAccount);} catch (NumberFormatException e) {throw new InvalidAccountException("Invalid account");}

        Account sourceAccount = accountList.get(accountNumber);
        Account destAccount = accountList.get(destinationAccount);

        if (sourceAccount == null) throw new InvalidAccountException("Invalid account");
        if (destAccount == null) throw new InvalidAccountException("Invalid account");

        int amount;
        try {amount = Integer.parseInt(transferAmount);} catch (NumberFormatException e) {throw new InvalidAccountException("Invalid amount");}
        if (amount > 1000) throw new MaximumAmountException("Maximum amount to withdraw is $1000");
        if (amount < 0) throw new MinimumAmountException("Minimum amount to withdraw is $1");
        if (amount > sourceAccount.getBalance()) throw new BalanceInsufficientException("Insufficient balance $ " + amount);
        try {Integer.parseInt(refNumber);} catch (NumberFormatException e) {throw new InvalidRefNumberException("Invalid Reference Number");}

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        accountList.put(sourceAccount.getAccountNumber(), sourceAccount);
        accountList.put(destAccount.getAccountNumber(), destAccount);

        return new TransferSummary(destinationAccount, amount, refNumber, sourceAccount.getBalance());
    }
}
