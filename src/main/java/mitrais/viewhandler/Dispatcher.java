package mitrais.viewhandler;

import mitrais.model.Account;
import mitrais.model.TransactionSummary;
import mitrais.model.TransferConfirmation;
import mitrais.model.TransferSummary;

public interface Dispatcher {
    void dispatch(String viewName);

    Account getAccount();
    void setAccount(Account account);

    TransactionSummary getTransactionSummary();
    void setTransactionSummary(TransactionSummary transactionSummary);

    TransferConfirmation getTransferConfirmation();
    void setTransferConfirmation(TransferConfirmation transferConfirmation);

    TransferSummary getTransferSummary();
    void setTransferSummary(TransferSummary transferSummary);
}
