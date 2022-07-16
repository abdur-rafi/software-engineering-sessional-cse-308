package QMS;

import QMS.CommunicationSystem.CommunicationSystemFactoryQMS;
import QMS.Controllers.ControllerFactoryQMS;
import QMS.DisplayUnit.DisplayUnitFactoryQMS;

public class FactoryProducer {
    private static QMSAbstractFactory commFactory = new CommunicationSystemFactoryQMS();
    private static QMSAbstractFactory controllerFactory = new ControllerFactoryQMS();
    private static QMSAbstractFactory displayFactory = new DisplayUnitFactoryQMS();

    public static QMSAbstractFactory getFactory(String type){
        if(type.equalsIgnoreCase("communication")){
            return commFactory;
        }
        else if(type.equalsIgnoreCase("controller")){
            return controllerFactory;
        }
        else if(type.equalsIgnoreCase("display")){
            return displayFactory;
        }
        return null;
    }


}
