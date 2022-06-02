package QMS.CommunicationSystem;

public class CommunicationSystemFactory {

    private static CommunicationSystemFactory factory = new CommunicationSystemFactory();

    public static CommunicationSystemFactory getFactory(){
        return factory;
    }

    private CommunicationSystemFactory(){

    }

    public CommunicationSystem getCommunicationSystem(String type){
        if(type.equalsIgnoreCase("sim")){
            return new SIM();
        }
        else if(type.equalsIgnoreCase("wifi"))
            return new WiFi();
        return null;
    }
}
