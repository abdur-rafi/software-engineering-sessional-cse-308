package QMS;

import QMS.Builders.IBuilder;

public class Director {

    public void Construct(IBuilder builder){
        builder.AddController();
        builder.AddDisplayUnit();
        builder.CreateApplication();
        builder.AddCommunicationSystem();
        builder.setYearlyCost();
    }

}
