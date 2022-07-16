package BankingSystem.Employees;

import BankingSystem.Accounts.Account;
import BankingSystem.CustomExceptions.Unauthorized;

public class Cashier extends Employee {
    public Cashier(String name) {
        super(name);
    }

    @Override
    public void ApproveLoan(Account acc) throws Unauthorized {
        throw new Unauthorized("You are not authorized for this operation\n");
    }

    @Override
    public void changeInterestRequest(double rate, String accountType) throws Unauthorized {
        throw new Unauthorized("You are not authorized for this operation\n");
    }

    @Override
    public double seeInternalFund() throws Unauthorized {
        throw new Unauthorized("You are not authorized for this operation\n");
    }
}
