package mitrais.model;

public class TransferConfirmation {
    private Account account;
    private String destinationAccount;
    private String transferAmount;
    private String referenceNumber;

    public TransferConfirmation(Account account, String destinationAccount, String referenceNumber) {
        this.account = account;
        this.destinationAccount = destinationAccount;
        this.referenceNumber = referenceNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
