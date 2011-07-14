/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.jamba.jee6.cdi;


import javax.inject.Named;

import ext.demo.jee6.api.Country;
import ext.demo.jee6.api.ServerConfiguration;

/**
 * @author  dstrauss
 */
@Named("default")
public class DeServerConfigImpl implements ServerConfiguration {

    @Override
    public Country getDefaultCountry() {
        return Country.DE;
    }
}
