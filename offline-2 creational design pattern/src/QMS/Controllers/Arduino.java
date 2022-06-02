package QMS.Controllers;

public class Arduino  implements Controller{
    @Override
    public String describe() {
        return "Controller: Arduino";
    }

    @Override
    public int getCost() {
        return 0;
    }
}
