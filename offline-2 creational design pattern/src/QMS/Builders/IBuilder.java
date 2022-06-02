package QMS.Builders;

import QMS.Booth;

public interface IBuilder {
    public void AddController();
    public void AddDisplayUnit();
    public void CreateApplication();
    public void AddCommunicationSystem();
    public void setYearlyCost();
    public Booth getProduct();
}
