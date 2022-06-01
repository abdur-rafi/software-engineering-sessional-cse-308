package BankingSystem.Employees;

import BankingSystem.Accounts.Account;
import BankingSystem.CustomExceptions.Invalid;
import BankingSystem.CustomExceptions.Unauthorized;

public abstract class Employee {
    private String name;

    protected Employee(String name) {
        this.name = name;
    }

    public double LookUp(Account acc){
        return acc.getAmount();
    }

    public void ApproveLoan(Account acc) throws Unauthorized {
        acc.setLoanRequestPending(false);
        acc.setTakenLoan(acc.getTakenLoan() + acc.getRequestedLoanAmount());
        acc.setRequestedLoanAmount(0);
    }

    public abstract void changeInterestRequest(double rate, String accountType) throws Unauthorized, Invalid;

    public String getName() {
        return name;
    }

    public double LookUpLoan(Account acc){
        return acc.getTakenLoan();
    }

    public abstract double seeInternalFund() throws Unauthorized;
}
