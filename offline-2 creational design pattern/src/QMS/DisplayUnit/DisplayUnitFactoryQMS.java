package QMS.DisplayUnit;

import QMS.AbstractFactory;

public class DisplayUnitFactory extends AbstractFactory {

    @Override
    public DisplayUnit getDisplayUnit(String type){
        if(type.equalsIgnoreCase("lcd"))
            return new LCD();
        else if(type.equalsIgnoreCase("led"))
            return new LED();
        return null;
    }
}
