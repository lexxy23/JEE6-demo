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

/**
 * A simple addressbook service.
 * 
 * @author dstrauss
 */
@Local
public interface AddressService {
    
    /**
     * Creates an entry.
     * 
     * @param fn
     *            the forename
     * @param sn
     *            the surename
     * @param str
     *            the street
     * @param zc
     *            the zip code
     * @param city
     *            the city
     * @param c
     *            the country
     * 
     * @return the address
     */
    Address createEntry(String fn, String sn, String str, String zc,
        String city, String c);
    
    /**
     * Deletes the addressbook entry with the given id.
     * 
     * @param id
     *            the id of the entry
     */
    void deleteAddress(long id);
    
    /**
     * Finds all users with the given name part.
     * 
     * @param namepart
     *            the part of the name
     * 
     * @return a list of matching users.
     */
    List<Address> findByName(String namepart);
    
   
    
    /**
     * Returns the address with the given id.
     * 
     * @param id
     *            the id
     * 
     * @return the address, or null if not found
     */
    Address getById(long id);
    
    /**
     * Updates the address of a user.
     * 
     * @param oldAddressId
     *            the id of the old address
     * @param newAddress
     *            the new entries for this address
     * 
     * @return the updated address
     */
    Address updateAddress(long oldAddressId, Address newAddress);
    
    List<Address> findAllAddresses();
    
    String sayHello();
}
