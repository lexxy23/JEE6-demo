/**
 *
 */
package de.jamba.jee6.api;

import de.jamba.jee6.api.xml.AddressXml;

import java.util.List;

import javax.ejb.Local;

/**
 * Service interface to remotely administer the address book.
 *
 * @author  dstrauss
 */
@Local
public interface AddressRemoteService {

    /**
     * Creates an addressbook entry.
     *
     * @param   fn    the forename
     * @param   sn    the surename
     * @param   str   the street
     * @param   zc    the zipcode
     * @param   city  the city
     * @param   c     the country
     *
     * @return  the generated address, or null if an error occurred.
     */
    AddressXml createEntry(String fn, String sn, String str, String zc, String city, Country c);

    /**
     * Returns the address by the given id.
     *
     * @param   id  the id of the address.
     *
     * @return  the address, or null if an error occurred.
     */
    AddressXml getById(long id);

    /**
     * Finds all addresses by the given name part.
     *
     * @param   namePart  the name part
     *
     * @return  the found addresses, or an empty list
     */
    List<AddressXml> findByName(String namePart);

    /**
     * Updates an addressbook entry.
     *
     * @param   oldAddressId  the id of the old entry of the address
     * @param   newAddress    the new values
     *
     * @return  the updated address
     */
    AddressXml updateAddress(long oldAddressId, AddressXml newAddress);

    /**
     * Deletes an address.
     *
     * @param  id  the id of the address to delete.
     */
    void deleteAddress(long id);
}
