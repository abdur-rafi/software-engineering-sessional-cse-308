package QMS.Controllers;

public class ControllerFactory {
    private static ControllerFactory factory = new ControllerFactory();
    private ControllerFactory(){

    }
    public static ControllerFactory getFactory(){
        return factory;
    }

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
