package QMS.Builders;

import QMS.Application.Application;
import QMS.Booth;
import QMS.FactoryProducer;

public class DeluxeBuilder implements IBuilder {
    private String connectionType;
    private int numberOfDisplayUnits;
    private Booth product;


    public DeluxeBuilder(String connectionType, int numberOfDisplayUnits) {
        this.connectionType = connectionType;
        this.numberOfDisplayUnits = numberOfDisplayUnits;
        product = new Booth();
    }

    @Override
    public void AddController() {
        product.addPart(FactoryProducer.getFactory("controller").getController("raspberry"));
    }

    @Override
    public void AddDisplayUnit() {
        for (int i = 0; i < numberOfDisplayUnits; ++i){
            product.addPart(FactoryProducer.getFactory("display").getDisplayUnit("lcd"));
        }
    }

    @Override
    public void CreateApplication() {
        product.addPart(new Application());
    }

    @Override
    public void AddCommunicationSystem() {
        product.addPart(FactoryProducer.getFactory("communication").getCommunicationSystem(connectionType));
    }

    @Override
    public void setYearlyCost() {
        product.setYearlyCost(200);
    }

    @Override
    public Booth getProduct() {
        return product;
    }
}
