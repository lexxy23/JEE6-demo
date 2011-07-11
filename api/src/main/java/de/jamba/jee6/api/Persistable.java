/**
 *
 */
package de.jamba.jee6.api;

import java.io.Serializable;

/**
 * Contract for a persistable object.
 *
 * @author  dstrauss
 */
public interface Persistable extends Serializable {

    /**
     * Returns the id of the entry.
     *
     * @return  the id
     */
    long getId();

    /**
     * Sets the id of this entry. Usuallly, this method is meant for testing purpose, and should not
     * be used in production code.
     *
     * @param  id  the id of the entry.
     */
    void setId(long id);
}
