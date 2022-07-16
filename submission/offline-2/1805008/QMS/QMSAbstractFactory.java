package QMS;

import QMS.CommunicationSystem.CommunicationSystem;
import QMS.Controllers.Controller;
import QMS.DisplayUnit.DisplayUnit;

public abstract class QMSAbstractFactory {
    public CommunicationSystem getCommunicationSystem(String type){
        return null;
    }
    public Controller getController(String type){
        return null;
    }
    public DisplayUnit getDisplayUnit(String type){
        return null;
    }



}
