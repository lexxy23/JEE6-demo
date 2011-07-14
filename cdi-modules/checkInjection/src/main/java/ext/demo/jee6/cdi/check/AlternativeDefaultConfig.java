/**
 *
 */
package ext.demo.jee6.cdi.check;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

import ext.demo.jee6.api.Country;
import ext.demo.jee6.api.ServerConfiguration;

/**
 * @author dstrauss
 *
 */
@Alternative
@Named("default")
public class AlternativeDefaultConfig implements ServerConfiguration {

	/**
	 *
	 */
	public AlternativeDefaultConfig() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Country getDefaultCountry() {
		return Country.DE;
	}

}
