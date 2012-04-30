package ext.demo.jee6.cdi.qualifier;

@StreetShoe
public class MizunoRunningShoe implements RunningShoe {
	
	@Override  
	public String getLatestModel() {
		return "Mizuno Waverider 3";
	}
}
