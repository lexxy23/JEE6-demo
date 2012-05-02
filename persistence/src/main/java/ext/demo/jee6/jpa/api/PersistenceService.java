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
package ext.demo.jee6.jpa.api;


import java.util.List;

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
    
//    List<? extends Persistable> findAll(Class<? extends Persistable> c);
}
