package mitrais.repository;

import mitrais.model.Account;

public interface AccountRepository {
    Account save(Account account);
    Account update(Account account);
    Account get(String accountNumber, String pin);
}