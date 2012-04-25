package ext.demo.jee6.cdi.qualifier;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MareksRunningShoeBean {

  private String streetShoe;
  private String trailShoe;
  private RunningShoe streetModel;
  private RunningShoe trailModel;

  
  @Inject
  @StandardPrice
  private double standardPrice;
  
  @Inject
  @TrailPrice
  private double trailPrice;
  
  @Inject
  public MareksRunningShoeBean (@StreetShoe RunningShoe streetModel, @TrailShoe RunningShoe trailModel) {
        this.streetModel = streetModel;
        this.trailModel = trailModel;
    }
  
    public String getTrailShoe() {
        this.trailShoe = trailModel.getLatestModel();
        return this.trailShoe + " (price: " + trailPrice + ")";
    }
    
    public String getStreetShoe() {
    	this.streetShoe = streetModel.getLatestModel();
    	return this.streetShoe + " (price: " + standardPrice + ")";
    }
}
