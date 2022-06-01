package BankingSystem.Accounts;

import BankingSystem.CustomExceptions.InsufficientDeposit;
import BankingSystem.CustomExceptions.Invalid;
import BankingSystem.CustomExceptions.NotMature;
import BankingSystem.CustomExceptions.WithDrawLimitReached;

public class Loan extends Account {
    public Loan(String name, double amount) {
        super(name, amount);
    }

    @Override
    public void deposit(double amount) throws InsufficientDeposit, Invalid, NotMature {
        super.deposit(-amount);
    }

    @Override
    public void withDraw(double amount) throws InsufficientDeposit, WithDrawLimitReached, NotMature, Invalid {
        throw new Invalid("Cannot withdraw from Loan account\n");
    }

    @Override
    public void requestLoan(double amount) throws Invalid {
        if(amount > .05 * amount){
            throw new Invalid("Requested loan amount for loan account cannot be higher than 5% of current loan amount");
        }
        super.requestLoan(amount);
    }
}
