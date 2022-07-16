package QMS.Application;

public class Application implements IApplication {
    @Override
    public String describe() {
        return "Controller Application";
    }

    @Override
    public int getCost() {
        return 100;
    }
}
