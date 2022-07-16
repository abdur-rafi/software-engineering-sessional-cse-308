package customExceptions;

public class InvalidCredit extends Exception {
    public InvalidCredit(String message){
        super(message);
    }
}
