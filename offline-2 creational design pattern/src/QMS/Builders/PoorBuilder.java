package QMS.Builders;

import QMS.Application.Application;
import QMS.Booth;
import QMS.CommunicationSystem.CommunicationSystemFactory;
import QMS.Controllers.ControllerFactory;
import QMS.DisplayUnit.DisplayUnitFactory;

public class PoorBuilder implements IBuilder {

    private String connectionType;
    private int numberOfDisplayUnits;
    private Booth product;


    public PoorBuilder(String connectionType, int numberOfDisplayUnits) {
        this.connectionType = connectionType;
        this.numberOfDisplayUnits = numberOfDisplayUnits;
        product = new Booth();
    }

    @Override
    public void AddController() {
        product.addPart(ControllerFactory.getFactory().getController("atmega"));
    }

    @Override
    public void AddDisplayUnit() {
        for (int i = 0; i < numberOfDisplayUnits; ++i){
            product.addPart(DisplayUnitFactory.getFactory().getDisplayUnit("led"));
        }
    }

    @Override
    public void CreateApplication() {
        product.addPart(new Application());
    }

    @Override
    public void AddCommunicationSystem() {
        product.addPart(CommunicationSystemFactory.getFactory().getCommunicationSystem(connectionType));
    }
    public void setYearlyCost() {
        product.setYearlyCost(0);
    }
    @Override
    public Booth getProduct() {
        return product;
    }
}
