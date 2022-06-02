package QMS.Controllers;

public class ATMega32 implements Controller {
    @Override
    public String describe() {
        return "Controller: ATMega 32";
    }

    @Override
    public int getCost() {
        return 0;
    }
}
