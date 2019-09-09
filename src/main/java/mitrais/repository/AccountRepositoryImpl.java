package mitrais.repository;

import mitrais.model.Account;

import java.util.HashMap;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    private static HashMap<String, Account> accountList;

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
        if (!account.getPin().equals(pin)) return null;
        return account;
    }
}
