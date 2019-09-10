package mitrais.view;

import mitrais.model.TransferConfirmation;
import mitrais.model.TransferSummary;
import mitrais.repository.AccountRepoFactory;

import java.util.Scanner;

public class FundTransfer4 implements Screen {
    private TransferConfirmation transferConfirmation;

    public FundTransfer4(TransferConfirmation transferConfirmation) {
        this.transferConfirmation = transferConfirmation;
    }

    @Override
    public void display() {
        Scanner in = new Scanner(System.in);
        System.out.println(String.format("Transfer Confirmation\n" +
                "Destination Account : xxx-xxx-xxx-x\n" +
                "Transfer Amount     : $yy\n" +
                "Reference Number    : zzzzzzzzzzzzz\n" +
                "\n" +
                "1. Confirm Trx\n" +
                "2. Cancel Trx\n" +
                "Choose option[2]:",
                transferConfirmation.getDestinationAccount(),
                transferConfirmation.getTransferAmount(),
                transferConfirmation.getReferenceNumber()));
        int confirm = in.nextInt();
        switch (confirm) {
            case 1:
                try {
                TransferSummary transferSummary = AccountRepoFactory.getAccountRepository().transfer(
                        transferConfirmation.getAccount().getAccountNumber(),
                        transferConfirmation.getDestinationAccount(),
                        transferConfirmation.getTransferAmount(),
                        transferConfirmation.getReferenceNumber()
                );
                new TransSummary(transferSummary).display();
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
                break;
            case 2:
                break;
            default:
                this.display();
        }
    }
}
