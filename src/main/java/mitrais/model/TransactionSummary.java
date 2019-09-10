package mitrais.model;

import java.util.Date;

public class TransactionSummary {
    Date date;
    Integer withDraw;
    Integer balance;

    public TransactionSummary(Date date, Integer withDraw, Integer balance) {
        this.date = date;
        this.withDraw = withDraw;
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getWithDraw() {
        return withDraw;
    }

    public void setWithDraw(Integer withDraw) {
        this.withDraw = withDraw;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
