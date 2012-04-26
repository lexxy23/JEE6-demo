package ext.demo.jee6.cdi.qualifier;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class PricingFactory {

	double basePrice = 50.0;
	
	@Produces
	@StandardPrice
	public double calculatePriceStandard (InjectionPoint point) {
		
		// hard-coded
		Integer size = 45; 
		
		double multiplier = 1.0;
		
		if (size < 40) {
			// base price
			multiplier = 1.0;
		} else if (size >= 40 && size < 45) {
			multiplier = 1.2;
		} else if (size >= 45) {
			// special model
			multiplier = 1.5;
		}
		
		return multiplier * basePrice;
	}
	
	@Produces
	@TrailPrice
	public double calculatePriceTrail (InjectionPoint point) {
		// hard-coded
		Integer size = 42; 
		
		double multiplier = 1.0;
		
		if (size < 40) {
			// base price
			multiplier = 1.1;
		} else if (size >= 40 && size < 45) {
			multiplier = 1.4;
		} else if (size >= 45) {
			// special model
			multiplier = 1.8;
		}
		
		return multiplier * basePrice;
	}
}
