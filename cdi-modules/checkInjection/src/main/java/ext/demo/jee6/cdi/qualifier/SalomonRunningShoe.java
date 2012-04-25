package ext.demo.jee6.cdi.qualifier;

@TrailShoe
public class SalomonRunningShoe implements RunningShoe {

	@Override
	public String getLatestModel() {
		return "Salomon Speedcross 3";
	}
}
