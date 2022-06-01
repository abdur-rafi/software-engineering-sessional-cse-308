package BankingSystem.Accounts;

import BankingSystem.CustomExceptions.InsufficientDeposit;
import BankingSystem.CustomExceptions.Invalid;
import BankingSystem.CustomExceptions.NotMature;
import BankingSystem.CustomExceptions.WithDrawLimitReached;

public class Savings extends Account {
    public Savings(String name, double deposit) {
        super(name, deposit);
    }

    @Override
    public void withDraw(double amount) throws InsufficientDeposit, WithDrawLimitReached, NotMature, Invalid {
        if(super.getAmount() - amount < 1000){
            throw new InsufficientDeposit("Balance becomes less than 1000$\n");
        }
        super.withDraw(amount);
    }
    @Override
    public void requestLoan(double amount) throws Invalid {
        if(amount > 10000){
            throw new Invalid("Loan amount for savings account cannot be higher than 10000$");
        }
        super.requestLoan(amount);
    }
}
