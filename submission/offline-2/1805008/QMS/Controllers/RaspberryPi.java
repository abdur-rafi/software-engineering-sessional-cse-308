package QMS.Controllers;

public class RaspberryPi implements Controller{
    @Override
    public String describe() {
        return "Controller: Raspberry Pi";
    }

    @Override
    public int getCost() {
        return 70;
    }
}
