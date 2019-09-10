package mitrais.view;

import mitrais.model.TransferSummary;

import java.util.Scanner;

public class TransSummary implements Screen {
    private TransferSummary transferSummary;

    public TransSummary(TransferSummary transferSummary) {
        this.transferSummary = transferSummary;
    }

    @Override
    public void display() {
        Scanner in = new Scanner(System.in);
        System.out.println(String.format("Fund Transfer Summary\n" +
                "Destination Account : %s\n" +
                "Transfer Amount     : %s\n" +
                "Reference Number    : %s\n" +
                "Balance             : %s\n" +
                "\n" +
                "1. Transaction\n" +
                "2. Exit\n" +
                "Choose option[2]:", transferSummary.getDestinationAccount(), transferSummary.getTransferAmount(),
                transferSummary.getReferenceNumber(), transferSummary.getBalance()));
        int option = in.nextInt();
        switch (option) {
            case 1:
                new Transaction().display();
                break;
            case 2:
                new Welcome().display();
                break;
            default:
        }
    }
}
