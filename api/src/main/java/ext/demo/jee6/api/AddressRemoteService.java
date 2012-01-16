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
package ext.demo.jee6.api;


import java.util.List;

import javax.ejb.Local;

import ext.demo.jee6.api.xml.AddressXml;

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
