/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ext.demo.jee6.ejb.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ext.demo.jee6.api.Address;
import ext.demo.jee6.api.AddressService;
import ext.demo.jee6.api.Country;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;

import javax.naming.NamingException;

/**
 * @author  dstrauss
 */
public class AddressServiceBeanTest {

    /**
     * A logger.
     */
    private static final Logger LOG = Logger.getLogger(AddressServiceBeanTest.class.getName());

    /**
     * The ejb container.
     */
    private static EJBContainer ejbC;

    /**
     * The service to test.
     */
    private AddressService svc = null;

    /**
     * Inits the test class.
     */
    public AddressServiceBeanTest() {
        // nothing special to do
    }

    /**
     * Sets up the container.
     *
     * @throws  Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.setProperty("env", "test");
        Map<String, Object> properties = new HashMap<String, Object>();
        File gfInstDir = new File("target", "gfInstDir");
        LOG.info("Instance root will be " + gfInstDir.getAbsolutePath());
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", gfInstDir.getAbsolutePath());
        properties.put("org.glassfish.ejb.embedded.glassfish.instance.root", gfInstDir.getAbsolutePath());

        // properties.put("org.glassfish.ejb.embedded.glassfish.web.http.port",
        // "80");
        // properties.put("org.glassfish.ejb.embedded.glassfish.configuration.file",
        // "test-resources/domain.xml");
        // properties.put(EJBContainer.MODULES, new File("target/classes"));
        // properties.put(EJBContainer.MODULES, new File[] { new
        // File("dist.ejb.jar")});
        ejbC = EJBContainer.createEJBContainer(properties);
    }

    /**
     * Actions to perform at the end of the unit test.
     *
     * @throws  Exception  if an error occurred.
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
        ejbC.close();
    }

    /**
     * Sets up a single test run.
     *
     * @throws  NamingException  if the bean could not be found.
     */
    @Before
    public void setUp() throws NamingException {
        svc = (AddressService) ejbC.getContext().lookup("java:global/AddressService");
        assertNotNull(svc);
    }

    /**
     * Actions to perform at the end of a single test run.
     */
    @After
    public void tearDown() {
        // Nothing. Everything is fine.
    }

    /**
     * Test of createEntry method, of class AddressServiceBean.
     *
     * @throws  Exception  If an error occurred.
     */
    @Test
    public void testCreateEntry() throws Exception {
        LOG.info("createEntry");
        String fn = "";
        String sn = "";
        String str = "";
        String zc = "";
        String city = "";
        Country c = null;
        Address expResult = null;
        Address result = svc.createEntry(fn, sn, str, zc, city, c);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByName method, of class AddressServiceBean.
     *
     * @throws  Exception  if an error occurred
     */
    @Test
    public void testFindByName() throws Exception {
        LOG.info("findByName");
        String namepart = "";
        List<Address> expResult = null;
        List<Address> result = svc.findByName(namepart);
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class AddressServiceBean.
     *
     * @throws  Exception  if an error occurred.
     */
    @Test
    public void testGetById() throws Exception {
        LOG.info("getById");
        long id = 0L;
        Address expResult = null;
        Address result = svc.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateAddress method, of class AddressServiceBean.
     *
     * @throws  Exception  if an error occurred.
     */
    @Test
    public void testUpdateAddress() throws Exception {
        LOG.info("updateAddress");
        long oldAddressId = 0L;
        Address newAddress = null;
        Address expResult = null;
        Address result = svc.updateAddress(oldAddressId, newAddress);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteAddress method, of class AddressServiceBean.
     *
     * @throws  Exception  if an error occurred.
     */
    @Test
    public void testDeleteAddress() throws Exception {
        LOG.info("deleteAddress");
        long id = 0L;
        svc.deleteAddress(id);
    }
}
