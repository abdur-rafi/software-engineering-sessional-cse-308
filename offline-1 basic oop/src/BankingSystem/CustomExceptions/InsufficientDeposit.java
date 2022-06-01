package BankingSystem.CustomExceptions;

public class InsufficientDeposit extends Exception {

    public InsufficientDeposit(String message) {
        super(message);
    }
}
