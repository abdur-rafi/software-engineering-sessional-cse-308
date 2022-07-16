package QMS.CommunicationSystem;

import QMS.QMSAbstractFactory;

public class CommunicationSystemFactoryQMS extends QMSAbstractFactory {

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
