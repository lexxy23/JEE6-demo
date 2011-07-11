/**
 *
 */
package de.jamba.jee6.api;

/**
 * Contract for a simple address.
 *
 * @author  dstrauss
 */
public interface Address extends Persistable {

    /**
     * Returns the surename.
     *
     * @return  the surename
     */
    String getSurename();

    /**
     * Returns the forename.
     *
     * @return  the forename
     */
    String getForename();

    /**
     * Returns the street.
     *
     * @return  the street
     */
    String getStreet();

    /**
     * Returns the zipcode.
     *
     * @return  the zip code
     */
    String getZipCode();

    /**
     * Returns the city.
     *
     * @return  the city
     */
    String getCity();

    /**
     * Returns the country.
     *
     * @return  the country
     */
    Country getCountry();
}
