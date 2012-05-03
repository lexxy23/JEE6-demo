/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */
package ext.demo.jee6.ejb.impl;

import ext.demo.jee6.api.Address;
import ext.demo.jee6.api.AddressService;
import ext.demo.jee6.api.Country;
import ext.demo.jee6.jpa.api.PersistenceService;
import ext.demo.jee6.jpa.model.AddressEntity;

import java.util.List;
import java.util.logging.Level;
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
    @EJB
    private PersistenceService svc;

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
        LOG.log(Level.INFO, "Using env {0}", env);
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
        AddressEntity e = new AddressEntity();
        Address a = svc.store(e);
        return a;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Address> findByName(@NotNull
            String namepart) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Address getById(@Max(100)
            @Min(0)
            long id) {
        return svc.getById(AddressEntity.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Address updateAddress(long oldAddressId, @NotNull
            Address newAddress) {
        return svc.updateEntity(newAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAddress(long id) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Address> getAllAddresses() {
        return null;
    }
}
