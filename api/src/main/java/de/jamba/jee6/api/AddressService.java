/**
 *
 */
package de.jamba.jee6.api;

import java.util.List;

import javax.ejb.Local;

/**
 * A simple addressbook service.
 *
 * @author  dstrauss
 */
@Local
public interface AddressService {

    /**
     * Creates an entry.
     *
     * @param   fn    the forename
     * @param   sn    the surename
     * @param   str   the street
     * @param   zc    the zip code
     * @param   city  the city
     * @param   c     the country
     *
     * @return  the address
     */
    Address createEntry(String fn, String sn, String str, String zc, String city, Country c);

    /**
     * Finds all users with the given name part.
     *
     * @param   namepart  the part of the name
     *
     * @return  a list of matching users.
     */
    List<Address> findByName(String namepart);

    /**
     * Returns the address with the given id.
     *
     * @param   id  the id
     *
     * @return  the address, or null if not found
     */
    Address getById(long id);

    /**
     * Updates the address of a user.
     *
     * @param   oldAddressId  the id of the old address
     * @param   newAddress    the new entries for this address
     *
     * @return  the updated address
     */
    Address updateAddress(long oldAddressId, Address newAddress);

    /**
     * Deletes the addressbook entry with the given id.
     *
     * @param  id  the id of the entry
     */
    void deleteAddress(long id);
}
