/**
 *
 */
package ext.demo.jee6.jpa.api;


import javax.ejb.Local;

import ext.demo.jee6.api.Persistable;

/**
 * @author  dstrauss
 */
@Local
public interface PersistenceService {

    /**
     * Stores an object into the database.
     *
     * @param   <E>  the persistable type
     * @param   obj  the object to store
     *
     * @return  the created entity
     */
    <E extends Persistable> E store(E obj);

    /**
     * Finds an entity using the given id.
     *
     * @param   <E>  the type of the entity
     * @param   c    the class of the entity
     * @param   id   the id of the entity
     *
     * @return  the entity, or null if not found
     */
    <E extends Persistable> E getById(Class<E> c, long id);

    /**
     * Deletes the given entity.
     *
     * @param  <E>  the type of the entity
     * @param  e    the entity to delete.
     */
    <E extends Persistable> void delete(E e);

    /**
     * Updates a given entity.
     *
     * @param   <E>  the type of the entity.
     * @param   e    the entity which contains changed entries.
     *
     * @return  the updated entity
     */
    <E extends Persistable> E updateEntity(E e);
}
