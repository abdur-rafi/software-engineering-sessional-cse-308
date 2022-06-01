package BankingSystem.CustomExceptions;

public class WithDrawLimitReached extends Exception {
    public WithDrawLimitReached(String message) {
        super(message);
    }
}
