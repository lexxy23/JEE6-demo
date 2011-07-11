/**
 *
 */
package de.jamba.jee6.ejb.impl;

import de.jamba.jee6.api.Address;
import de.jamba.jee6.api.AddressService;
import de.jamba.jee6.api.Country;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Implementation for the AddressService.
 *
 * @author  dstrauss
 */
@Stateless
@DependsOn("EnvSnooperBean")
@EJB(
    name = "java:global/AddressService",
    beanInterface = AddressService.class
)
public class AddressServiceBean implements AddressService {

    /**
     * A logger.
     */
    private static final Logger LOG = Logger.getLogger(AddressServiceBean.class.getName());

    /**
     * The environment to use.
     */
    @Resource(mappedName = "jee6/env")
    private String env;

    /**
     * Inits the bean.
     */
    public AddressServiceBean() {
        // nothing special to do
    }

    /**
     * Performs some startup config.
     */
    @PostConstruct
    public void startup() {
        LOG.info("Using env " + env);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Address createEntry(@NotNull
            String fn, @NotNull
            String sn, @NotNull
            String str, @NotNull
            String zc, @NotNull
            String city, Country c) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Address> findByName(@NotNull
            String namepart) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Address getById(@Max(100)
            @Min(0)
            long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Address updateAddress(long oldAddressId, @NotNull
            Address newAddress) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAddress(long id) {
        // TODO Auto-generated method stub
    }
}
