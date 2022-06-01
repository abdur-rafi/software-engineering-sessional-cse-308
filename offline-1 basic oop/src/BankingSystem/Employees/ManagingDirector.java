package BankingSystem.Employees;

import BankingSystem.Bank;
import BankingSystem.CustomExceptions.Invalid;

public class ManagingDirector extends Employee {
    public ManagingDirector(String name) {
        super(name);
    }



    @Override
    public void changeInterestRequest(double rate, String accountType) throws Invalid {
        if(rate < 0) throw new Invalid("Interest rate cannot be negative");
        Bank.getBank().changeInterestRate(rate, accountType);
    }

    @Override
    public double seeInternalFund() {
        return Bank.getBank().getInternalFund();
    }
}
