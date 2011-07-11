/**
 *
 */
package de.jamba.jee6.ejb.impl;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import de.jamba.jee6.api.Country;
import de.jamba.jee6.api.ServerConfiguration;
import de.jamba.jee6.api.annotations.DefaultCountry;

/**
 * @author dstrauss
 *
 */
@Named("default")
@Alternative
public class TestConf1 implements ServerConfiguration {

	/**
	 *
	 */
	public TestConf1() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.jamba.jee6.api.ServerConfiguration#getDefaultCountry()
	 */
	@Override
	@Produces
	@DefaultCountry
	public Country getDefaultCountry() {
		return Country.US;
	}

}
