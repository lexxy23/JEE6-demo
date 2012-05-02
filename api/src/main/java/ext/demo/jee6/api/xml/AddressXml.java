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
/**
 *
 */
package ext.demo.jee6.api.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import ext.demo.jee6.api.Address;
import ext.demo.jee6.api.Country;

/**
 * The xml version of an address.
 * 
 * @author dstrauss
 */
@XmlType
@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressXml implements Address {
    
    /**
     * The svuid.
     */
    private static final long serialVersionUID = 8700641212685623966L;
    
    /**
     * The city name.
     */
    @XmlElement
    private String city;
    
    /**
     * The country.
     */
    @XmlElement
    private String country;
    
    /**
     * The forename of the user.
     */
    @XmlElement
    private String forename;
    
    /**
     * The id of the address.
     */
    @XmlElement
    private long id;
    
    /**
     * The street name and number.
     */
    @XmlElement
    private String street;
    
    /**
     * The surename.
     */
    @XmlElement
    private String surename;
    
    /**
     * The city zipcode.
     */
    @XmlElement
    private String zipCode;
    
    /**
     * Inits the xml object.
     */
    public AddressXml() {
        // nothing to do
    }
    
    /**
     * Inits the address with the given address.
     * 
     * @param a
     *            the address to copy values from
     */
    public AddressXml(final Address a) {
        this();
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
    public String getCountry() {
        return country;
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
     * {@inheritDoc}
     */
    @Override
    @XmlTransient
    public Long getId() {
        return id;
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
    public String getSurename() {
        return surename;
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
     * @param city
     *            the city to set
     */
    public synchronized void setCity(final String city) {
        this.city = city;
    }
    
    /**
     * @param forename
     *            the forename to set
     */
    public synchronized void setForename(final String forename) {
        this.forename = forename;
    }
    
    /**
     * @param id
     *            the id to set
     */
    @Override
    public synchronized void setId(final Long id) {
        this.id = id;
    }
    
    /**
     * @param street
     *            the street to set
     */
    public synchronized void setStreet(final String street) {
        this.street = street;
    }
    
    /**
     * @param surename
     *            the surename to set
     */
    public synchronized void setSurename(final String surename) {
        this.surename = surename;
    }
    
    /**
     * @param zipCode
     *            the zipCode to set
     */
    public synchronized void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }
}
