/**
 *
 */
package de.jamba.jee6.api.xml;

import de.jamba.jee6.api.Address;
import de.jamba.jee6.api.Country;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * The xml version of an address.
 *
 * @author  dstrauss
 */
@XmlType
public class AddressXml implements Address {

    /**
     * The svuid.
     */
    private static final long serialVersionUID = 8700641212685623966L;

    /**
     * The id of the address.
     */
    @XmlElement
    private long id;

    /**
     * The city name.
     */
    @XmlElement
    private String city;

    /**
     * The city zipcode.
     */
    @XmlElement
    private String zipCode;

    /**
     * The street name and number.
     */
    @XmlElement
    private String street;

    /**
     * The forename of the user.
     */
    @XmlElement
    private String forename;

    /**
     * The surename.
     */
    @XmlElement
    private String surename;

    /**
     * The country.
     */
    @XmlElement
    private Country country;

    /**
     * Inits the xml object.
     */
    public AddressXml() {
        // nothing to do
    }

    /**
     * Inits the address with the given address.
     *
     * @param  a  the address to copy values from
     */
    public AddressXml(Address a) {
        this();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @XmlTransient
    public long getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @XmlTransient
    public String getSurename() {
        return surename;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @XmlTransient
    public String getForename() {
        return forename;
    }

    /**
     * @param  id  the id to set
     */
    public synchronized void setId(long id) {
        this.id = id;
    }

    /**
     * @param  city  the city to set
     */
    public synchronized void setCity(String city) {
        this.city = city;
    }

    /**
     * @param  zipCode  the zipCode to set
     */
    public synchronized void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @param  street  the street to set
     */
    public synchronized void setStreet(String street) {
        this.street = street;
    }

    /**
     * @param  forename  the forename to set
     */
    public synchronized void setForename(String forename) {
        this.forename = forename;
    }

    /**
     * @param  surename  the surename to set
     */
    public synchronized void setSurename(String surename) {
        this.surename = surename;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @XmlTransient
    public String getStreet() {
        return street;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @XmlTransient
    public String getZipCode() {
        return zipCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @XmlTransient
    public String getCity() {
        return city;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @XmlTransient
    public Country getCountry() {
        return country;
    }
}
