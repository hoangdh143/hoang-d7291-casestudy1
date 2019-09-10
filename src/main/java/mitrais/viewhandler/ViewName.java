package mitrais.viewhandler;

import mitrais.view.*;

public enum ViewName {
    WELCOME(new Welcome()),
    TRANSACTION(new Transaction()),
    WITHDRAW(new Withdraw()),
    OTHERWITHDRAW(new OtherWithdraw()),
    SUMMARY(new Summary()),
    FUNDTRANSFER(new FundTransfer()),
    FUNDTRANSFER2(new FundTransfer2()),
    FUNDTRANSFER3(new FundTransfer3()),
    FUNDTRANSFER4(new FundTransfer4()),
    TRANSSUMMARY(new TransSummary());

    private View view;

    ViewName(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
