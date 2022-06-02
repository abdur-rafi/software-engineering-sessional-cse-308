package QMS.DisplayUnit;

public class DisplayUnitFactory {

    private static DisplayUnitFactory factory = new DisplayUnitFactory();
    private DisplayUnitFactory(){

    }
    public static DisplayUnitFactory getFactory(){
        return factory;
    }

    public DisplayUnit getDisplayUnit(String type){
        if(type.equalsIgnoreCase("lcd"))
            return new LCD();
        else if(type.equalsIgnoreCase("led"))
            return new LED();
        return null;
    }
}
