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
package ext.demo.jee6.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ext.demo.jee6.api.Address;
import ext.demo.jee6.api.Country;

/**
 * The address entity.
 * 
 * @author dstrauss
 */
@Entity
@Table(name = "JE6_ADDRESS")
public class AddressEntity implements Address {
    
    /**
     * The svuid.
     */
    private static final long serialVersionUID = -8520613653165316757L;
    
    /**
     * The id of an entry.
     */
    @Id
    @SequenceGenerator(
        allocationSize = 2,
        initialValue = 1,
        name = "seq1",
        sequenceName = "seq_address")
    @GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
    private long id;
    
    /**
     * The country.
     */
    @Column(name = "country", length = 5)
    private Country country;
    
    /**
     * The city name.
     */
    @Column(name = "city", length = 200)
    private String city;
    
    /**
     * The zip code.
     */
    @Column(name = "zip", length = 5)
    private String zipCode;
    
    /**
     * The street name.
     */
    @Column(name = "street", length = 200)
    private String street;
    
    /**
     * The forename.
     */
    @Column(name = "forename", length = 100)
    private String forename;
    
    /**
     * The surename.
     */
    @Column(name = "surename", length = 100)
    private String surename;
    
    /**
     * Inits the empty address.
     */
    public AddressEntity() {
        // nothing special to do
    }
    
    /**
     * @return the id
     */
    @Override
    public synchronized long getId() {
        return id;
    }
    
    @Override
    public String getSurename() {
        return surename;
    }
    
    @Override
    public String getForename() {
        return forename;
    }
    
    @Override
    public String getStreet() {
        return street;
    }
    
    @Override
    public String getZipCode() {
        return zipCode;
    }
    
    @Override
    public String getCity() {
        return city;
    }
    
    @Override
    public Country getCountry() {
        return country;
    }
    
    @Override
    public void setId(long id) {
        this.id = id;
    }
}
