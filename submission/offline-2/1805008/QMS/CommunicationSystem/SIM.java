package QMS.CommunicationSystem;

public class SIM implements CommunicationSystem {
    @Override
    public String describe() {
        return "Communication system: SIM";
    }

    @Override
    public int getCost() {
        return 30;
    }
}
