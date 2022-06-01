package BankingSystem.Accounts;

import BankingSystem.CustomExceptions.InsufficientDeposit;
import BankingSystem.CustomExceptions.Invalid;
import BankingSystem.CustomExceptions.NotMature;
import BankingSystem.CustomExceptions.WithDrawLimitReached;

public class Student extends Account {


    public Student(String name, double deposit) {
        super(name, deposit);
    }

    @Override
    public void withDraw(double amount) throws InsufficientDeposit, WithDrawLimitReached, NotMature, Invalid {
        if(amount > 10000){
            throw new WithDrawLimitReached("Cannot withdraw more than 10,000$ from student account");
        }
        super.withDraw(amount);
    }

    @Override
    public void requestLoan(double amount) throws Invalid {
        if(amount > 1000){
            throw new Invalid("Loan amount for student account cannot be higher than 1000$");
        }
        super.requestLoan(amount);
    }
}
