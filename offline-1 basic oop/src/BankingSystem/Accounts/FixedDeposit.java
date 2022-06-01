package BankingSystem.Accounts;

import BankingSystem.CustomExceptions.InsufficientDeposit;
import BankingSystem.CustomExceptions.Invalid;
import BankingSystem.CustomExceptions.NotMature;
import BankingSystem.CustomExceptions.WithDrawLimitReached;

public class FixedDeposit extends Account {
    boolean matured;
    public FixedDeposit(String name, double deposit) throws InsufficientDeposit {
        super(name, deposit);
        if(deposit < 100000){
            throw new InsufficientDeposit("Initial deposit amount for fixed deposit account must be 100,000$ at least\n");
        }
        matured = false;
    }

    public void setMatured(boolean matured) {
        this.matured = matured;
    }

    public boolean isMatured() {
        return matured;
    }

    @Override
    public void deposit(double amount) throws InsufficientDeposit, Invalid, NotMature {
        if(amount < 50000){
            throw new InsufficientDeposit("Deposit amount must be 50,000$ at least\n");
        }
        if(!matured){
            throw new NotMature("Account not matured\n");
        }
        super.deposit(amount);
    }

    @Override
    public void withDraw(double amount) throws InsufficientDeposit, WithDrawLimitReached, NotMature, Invalid {
        if(!matured) throw new NotMature("Maturity period not reached yet\n");
        super.withDraw(amount);
    }

    @Override
    public void requestLoan(double amount) throws Invalid {
        if(amount > 100000){
            throw new Invalid("Loan amount for fixed deposit account cannot be higher than 100000$");
        }
        super.requestLoan(amount);
    }
}
