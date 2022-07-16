package QMS.Controllers;

import QMS.QMSAbstractFactory;

public class ControllerFactoryQMS extends QMSAbstractFactory {

    @Override
    public Controller getController(String type){
        if(type.equalsIgnoreCase("Atmega")){
            return new ATMega32();
        }
        else if(type.equalsIgnoreCase("Arduino")){
            return new Arduino();
        }
        else if(type.equalsIgnoreCase("Raspberry")){
            return new RaspberryPi();
        }
        return null;
    }
}
