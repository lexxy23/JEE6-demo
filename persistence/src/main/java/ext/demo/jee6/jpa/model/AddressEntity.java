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
