package BankingSystem.Employees;

import BankingSystem.CustomExceptions.Unauthorized;

public class Officer extends Employee {
    public Officer(String name) {
        super(name);
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
