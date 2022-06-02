package QMS.CommunicationSystem;

public class WiFi implements CommunicationSystem {
    @Override
    public String describe() {
        return "Communication system: WIFI";
    }

    @Override
    public int getCost() {
        return 0;
    }

}
