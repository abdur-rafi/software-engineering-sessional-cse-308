package QMS.DisplayUnit;

import QMS.QMSAbstractFactory;

public class DisplayUnitFactoryQMS extends QMSAbstractFactory {

    @Override
    public DisplayUnit getDisplayUnit(String type){
        if(type.equalsIgnoreCase("lcd"))
            return new LCD();
        else if(type.equalsIgnoreCase("led"))
            return new LED();
        return null;
    }
}
