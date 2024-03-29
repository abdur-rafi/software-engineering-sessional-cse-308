package QMS;

import QMS.Builders.DeluxeBuilder;
import QMS.Builders.IBuilder;
import QMS.Builders.OptimalBuilder;
import QMS.Builders.PoorBuilder;

public class BuilderFactory {

    public IBuilder getBuilder(String type, String commChannelType, int noOfDisplayUnits){
        if(type.equalsIgnoreCase("deluxe")){
            return new DeluxeBuilder(commChannelType, noOfDisplayUnits);
        }
        else if(type.equalsIgnoreCase("optimal")){
            return new OptimalBuilder(commChannelType, noOfDisplayUnits);
        }
        else if(type.equalsIgnoreCase("poor")){
            return new PoorBuilder(commChannelType, noOfDisplayUnits);
        }
        return null;
    }
}
