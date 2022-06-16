package QMS.CommunicationSystem;

import QMS.AbstractFactory;

public class CommunicationSystemFactory extends AbstractFactory {

    @Override
    public CommunicationSystem getCommunicationSystem(String type){
        if(type.equalsIgnoreCase("sim")){
            return new SIM();
        }
        else if(type.equalsIgnoreCase("wifi"))
            return new WiFi();
        return null;
    }
}
