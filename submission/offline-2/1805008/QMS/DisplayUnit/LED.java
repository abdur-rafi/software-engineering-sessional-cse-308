package QMS.DisplayUnit;

public class LED implements DisplayUnit {
    @Override
    public String describe() {
        return "Display Unit: LED";
    }

    @Override
    public int getCost() {
        return 5;
    }

}
