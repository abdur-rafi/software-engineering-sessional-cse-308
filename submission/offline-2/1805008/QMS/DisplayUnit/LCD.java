package QMS.DisplayUnit;

public class LCD implements DisplayUnit {
    @Override
    public String describe() {
        return "Display Unit: LCD";
    }

    @Override
    public int getCost() {
        return 10;
    }

}
