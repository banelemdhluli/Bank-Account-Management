import java.util.Scanner;

public abstract class BankAccountManagement {
    protected String accholderName;
    protected String accNumber;
    protected String cardPin;
    protected double balance = 0;

    public void setAccHolderName(String accholderName) {
        this.accholderName = accholderName;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    public String getAccHolderName() {
        return accholderName;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public String getCardPin() {
        return cardPin;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void performAction(Scanner input);
}

