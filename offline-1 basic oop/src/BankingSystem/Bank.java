package BankingSystem;

import BankingSystem.Accounts.*;
import BankingSystem.CustomExceptions.*;
import BankingSystem.Employees.Cashier;
import BankingSystem.Employees.Employee;
import BankingSystem.Employees.ManagingDirector;
import BankingSystem.Employees.Officer;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private double internalFund = 1000000;
    private int clock = 0;
    private static final Bank bank = new Bank();
    private ArrayList<Account> accounts;
    private ArrayList<Employee> employees;
    private double interestRateOfSavings;
    private double interestRateOfStudents;
    private final double interestRateOfLoan = .1;
    private double interestRateOfFixedDeposit;


    public double getInternalFund(){
        return internalFund;
    }

    public static Bank getBank(){
        return bank;
    }
    private Bank(){
        accounts = new ArrayList<>();
        employees = new ArrayList<>();
        employees.add(new ManagingDirector("MD"));
        employees.add(new Officer("O1"));
        employees.add(new Officer("O2"));
        employees.add(new Cashier("C1"));
        employees.add(new Cashier("C2"));
        employees.add(new Cashier("C3"));
        employees.add(new Cashier("C4"));
        employees.add(new Cashier("C5"));
        System.out.println("Bank Created; MD, O1, O2, C1, C2, C3, C4, C5 created\n");
        interestRateOfFixedDeposit = .15;
        interestRateOfSavings = .1;
        interestRateOfStudents = .05;
    }

     public void changeInterestRate(double rate, String accountType) throws Invalid {
        if(accountType.equalsIgnoreCase("Student")){
            interestRateOfStudents = rate;
        }
        else if(accountType.equalsIgnoreCase("Savings")){
            interestRateOfSavings = rate;
        }
        else if(accountType.equalsIgnoreCase("FixedDeposit")){
            interestRateOfFixedDeposit = rate;
        }
        else throw new Invalid("Invalid account type");
    }

    private Employee FindEmployee(String name){
        for(Employee emp : employees){
            if(emp.getName().equalsIgnoreCase(name))
                return emp;
        }
        return null;
    }

    private Account FindAccount(String name ){
        for(Account acc : accounts){
            if(acc.getName().equalsIgnoreCase(name)){
                return acc;
            }
        }
        return null;
    }

    private Account createAccount(String name, String type, double amount) throws InsufficientDeposit, Invalid {
        if(FindAccount(name) != null || FindEmployee(name) != null){
            throw new Invalid("Account with the given name already exists");
        }
        Account acc;
        if(type.equalsIgnoreCase("Student")){
            acc = new Student(name, amount);
        }
        else if(type.equalsIgnoreCase("Savings")){
            acc = new Savings(name, amount);
        }
        else if(type.equalsIgnoreCase("Loan")){
            if(internalFund < amount){
                throw new Invalid(String.format("Not enough fund to approve %f$ loan", amount));
            }
            acc = new Loan(name, amount);
        }
        else if(type.equalsIgnoreCase("FixedDeposit")){
            acc = new FixedDeposit(name, amount);
        }
        else{
            throw new Invalid("Invalid Account Type");
        }
        accounts.add(acc);
        if(type.equalsIgnoreCase("Loan")){
            internalFund -= amount;
        }
        else{
            internalFund += amount;
        }
        return acc;
    }

    private void deposit(Account acc, double amount) throws Invalid, InsufficientDeposit, NotMature {

        acc.deposit(amount);
        internalFund += amount;
    }

    private void withdraw(Account acc, double amount) throws NotMature, Invalid, InsufficientDeposit, WithDrawLimitReached {
        acc.withDraw(amount);
        internalFund -= amount;
    }

    private ArrayList<Account> loanRequestFromAccounts(){
        ArrayList<Account> arr = new ArrayList<>();
        for(Account acc : accounts){
            if(acc.isLoanRequestPending()){
                arr.add(acc);
            }
        }
        return arr;
    }

    private void approveLoan(Account acc, Employee emp) throws Invalid, Unauthorized {
        if(acc.getRequestedLoanAmount() > internalFund){
            throw new Invalid("Insufficient fund ");
        }
        emp.ApproveLoan(acc);
        System.out.printf("loan approved for %s\n", acc.getName());
    }

    private void showLoanRequests(Employee currentEmployee){
        if(currentEmployee instanceof Cashier){
            System.out.println("You don't have permission for this operation");
        }
        else{
            ArrayList<Account> arr = loanRequestFromAccounts();
            for(Account acc : arr){
                System.out.printf("Account name : %s Loan amount: %f\n", acc.getName(), acc.getRequestedLoanAmount());
            }
        }
    }

    private void cutInterest() {
        for(Account acc : accounts){
            double intRate = interestRateOfLoan;
            if(acc instanceof Savings){
                intRate = interestRateOfSavings;
            }
            else if(acc instanceof Student){
                intRate = interestRateOfStudents;
            }
            else if(acc instanceof FixedDeposit){
                intRate = interestRateOfFixedDeposit;
            }
            double currAmount = acc.getAmount();
            double currLoan = acc.getTakenLoan();

            if(acc instanceof Loan){
                currAmount += currAmount * .1 + currLoan * 1;
            }
            else{
                currAmount += currAmount * intRate;
                currAmount -= currLoan * .1 + 500;
                currAmount = Math.max(currAmount, 0);
            }
            acc.setAmount(currAmount);
        }
    }

    public void Operate(){
        Scanner scanner = new Scanner(System.in);
        Employee currentEmployee = null;
        Account currentAccount = null;
        while(true){
            try {
                String command = scanner.next();
                if (command.equalsIgnoreCase("Create")) {
                    String name = scanner.next();
                    String type = scanner.next();
                    double amount = scanner.nextDouble();
                    try {
                        currentAccount = createAccount(name, type, amount);
                        System.out.println(type + " account for " + name + " Created; initial balance " + amount + "$\n");
                    } catch (Invalid | InsufficientDeposit e) {
                        System.out.println(e.getMessage());
                    }
                } else if (command.equalsIgnoreCase("Deposit") || command.equalsIgnoreCase("withdraw")) {
                    try {
                        double amount = scanner.nextDouble();
                        if (currentAccount == null) {
                            System.out.println("Please Login first\n");
                        } else {
                            if (command.equalsIgnoreCase("Deposit")) {
                                deposit(currentAccount, amount);
                                System.out.printf("%.2f$ deposited; current balance %.2f$%n", amount, currentAccount.getAmount());
                            } else {
                                withdraw(currentAccount, amount);
                                System.out.printf("%.2f$ withdrawn; current balance %.2f$%n", amount, currentAccount.getAmount());
                            }
                        }
                    } catch (InsufficientDeposit | Invalid | WithDrawLimitReached | NotMature e) {
                        System.out.println(e.getMessage());
                    }
                } else if (command.equalsIgnoreCase("query")) {
                    if (currentAccount == null) {
                        System.out.println("Please Login first");
                    } else {
                        System.out.printf("Current balance %.2f$ loan %.2f$\n", currentAccount.getAmount(), currentAccount.getTakenLoan());
                    }
                } else if (command.equalsIgnoreCase("request")) {
                    double amount = scanner.nextDouble();
                    if (currentAccount == null) {
                        System.out.println("Please Login first");
                    } else {
                        try {
                            currentAccount.requestLoan(amount);
                            System.out.println("Loan request successful, sent for approval");
                        } catch (Invalid invalid) {
                            System.out.println(invalid.getMessage());
                        }
                    }
                } else if (command.equalsIgnoreCase("close")) {
                    if (currentAccount != null) {
                        System.out.printf("Transaction closed for %s\n", currentAccount.getName());
                    } else if (currentEmployee != null) {
                        System.out.printf("Operations closed for %s\n", currentEmployee.getName());
                    } else {
                        System.out.println("Nothing active to close");
                    }
                    currentAccount = null;
                    currentEmployee = null;
                } else if (command.equalsIgnoreCase("open")) {
                    String name = scanner.next();
                    currentAccount = FindAccount(name);
                    if (currentAccount != null) {
                        System.out.printf("Welcome back, %s\n", currentAccount.getName());
                    } else {
                        currentEmployee = FindEmployee(name);
                        if (currentEmployee != null) {

                            System.out.printf("%s active.", name);
                            if (!(currentEmployee instanceof Cashier)) {
                                ArrayList<Account> arr = loanRequestFromAccounts();
                                if (arr.size() > 0) {
                                    System.out.println("There are loan approvals pending");
                                } else
                                    System.out.println();
                            }
                        } else {
                            System.out.println("Unknown name");
                        }
                    }
                } else if (command.equalsIgnoreCase("loan")) {
                    if (currentEmployee == null) {
                        System.out.println("Please Login first");
                    } else {
                        showLoanRequests(currentEmployee);
                    }
                } else if (command.equalsIgnoreCase("approve")) {
                    if (currentEmployee == null) {
                        System.out.println("Please Login first");
                        continue;
                    }
                    String nxt = scanner.next();
                    if (nxt.equalsIgnoreCase("loan")) {
                        String person = scanner.next();
                        Account acc = FindAccount(person);
                        if (acc == null) {
                            System.out.println("No user found");
                        } else if (!acc.isLoanRequestPending()) {
                            System.out.println("No loan request ");
                        } else {
                            try {
                                approveLoan(acc, currentEmployee);
                            } catch (Unauthorized | Invalid e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    } else {
                        System.out.println("Unknown command");
                    }
                } else if (command.equalsIgnoreCase("Lookup")) {
                    String name = scanner.next();
                    if (currentEmployee == null) {
                        System.out.println("Please Login first");
                    } else {
                        Account acc = FindAccount(name);
                        if (acc == null) {
                            System.out.println("No account found");
                        } else {
                            System.out.printf("%s's current balance is %.2f loan %.2f\n", name, currentEmployee.LookUp(acc), currentEmployee.LookUpLoan(acc));
                        }
                    }
                } else if (command.equalsIgnoreCase("change")) {
                    if (currentEmployee == null) {
                        System.out.println("Please Login first");
                    } else {
                        String type = scanner.next();
                        double rate = scanner.nextDouble();
                        try {
                            currentEmployee.changeInterestRequest(rate, type);
                            System.out.println("Interest rate of " + type + " account has been changed to " + rate);
                        } catch (Unauthorized | Invalid e) {
                            System.out.println(e.getMessage());
                        }

                    }
                } else if (command.equalsIgnoreCase("see")) {
                    if (currentEmployee == null) {
                        System.out.println("Please Login first");
                    } else {
                        try {
                            double fund = currentEmployee.seeInternalFund();
                            System.out.printf("Internal fund : %.2f\n", fund);
                        } catch (Unauthorized unauthorized) {
                            System.out.println(unauthorized.getMessage());
                        }

                    }
                } else if (command.equalsIgnoreCase("inc")) {
                    System.out.println("1 year passed");
                    cutInterest();

                }
                else{
                    System.out.println("unknown command");
                }


            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

}
