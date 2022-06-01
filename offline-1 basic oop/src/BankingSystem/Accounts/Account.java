package BankingSystem.Accounts;

import BankingSystem.CustomExceptions.InsufficientDeposit;
import BankingSystem.CustomExceptions.Invalid;
import BankingSystem.CustomExceptions.NotMature;
import BankingSystem.CustomExceptions.WithDrawLimitReached;

public abstract class Account {
    private final String name;
    private double amount;
    private double requestedLoanAmount;
    private boolean loanRequestPending;
    private double takenLoan;


    protected Account(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public void deposit(double amount) throws InsufficientDeposit, Invalid, NotMature {
        if(amount <= 0){
            throw new Invalid("Deposit amount must be positive\n");
        }
        this.amount += amount;
    }

    public void withDraw(double amount) throws InsufficientDeposit, WithDrawLimitReached, NotMature, Invalid {
        if(amount > this.amount){
            throw new InsufficientDeposit("Insufficient Deposit");
        }
        this.amount -= amount;
    }

    public void requestLoan(double amount) throws Invalid {
        if(loanRequestPending){
            throw new Invalid("A loan request is already pending");
        }
        else if(amount <= 0){
            throw new Invalid("Invalid amount");
        }

        loanRequestPending = true;
        requestedLoanAmount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public double getTakenLoan() {
        return takenLoan;
    }




    public String getName() {
        return name;
    }

    public boolean isLoanRequestPending() {
        return loanRequestPending;
    }

    public double getRequestedLoanAmount() {
        return requestedLoanAmount;
    }

    public void setRequestedLoanAmount(double requestedLoanAmount) {
        this.requestedLoanAmount = requestedLoanAmount;
    }

    public void setLoanRequestPending(boolean loanRequestPending) {
        this.loanRequestPending = loanRequestPending;
    }


    public void setTakenLoan(double takenLoan) {
        this.takenLoan = takenLoan;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
