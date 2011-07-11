/**
 *
 */
package de.jamba.jee6.ejb.impl;

import de.jamba.jee6.api.Persistable;
import de.jamba.jee6.jpa.api.PersistenceService;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ejb.Stateless;

/**
 * @author  dstrauss
 */
@Stateless
@Singleton
public class PersistenceTestBean implements PersistenceService {

    private Map<String, Persistable> m = null;
    private long seqId;

    /**
     */
    public PersistenceTestBean() {
        m = new HashMap<String, Persistable>();
        seqId = 1;
    }

    /* (non-Javadoc)
     * @see de.jamba.jee6.jpa.api.PersistenceService#store(de.jamba.jee6.api.Persistable)
     */
    @Override
    public <E extends Persistable> E store(E obj) {
        obj.setId(seqId++);
        String key = createMapKey(obj);
        m.put(key, obj);
        return (E) m.get(key);
    }

    private <E extends Persistable> String createMapKey(E e) {
        if (e == null) {
            return null;
        }
        return createMapKey(e.getClass().getSimpleName(), e.getId());
    }

    /**
     * Creates a map key for the given class and entry id.
     *
     * @param   c   the class of the entity.
     * @param   id  the id of the entity
     *
     * @return  a map key, or null if an error occurred.
     */
    private String createMapKey(Class<?> c, long id) {
        if (c == null) {
            return null;
        }
        return createMapKey(c.getSimpleName(), id);
    }

    /**
     * Creates a map key for the given simple class name and the id of the entry.
     *
     * @param   simpleClassName  the simple class name
     * @param   id               the id of the entry.
     *
     * @return  a map key, or null in case of an error.
     */
    private String createMapKey(String simpleClassName, long id) {
        StringBuffer sb = new StringBuffer();
        sb.append(simpleClassName);
        sb.append(id);
        return sb.toString();
    }

    /* (non-Javadoc)
     * @see de.jamba.jee6.jpa.api.PersistenceService#getById(java.lang.Class, long)
     */
    @Override
    public <E extends Persistable> E getById(Class<E> c, long id) {
        String key = createMapKey(c, id);
        return (E) m.get(key);
    }

    @Override
    public <E extends Persistable> void delete(E e) {
        // TODO Auto-generated method stub
    }

    @Override
    public <E extends Persistable> E updateEntity(E e) {
        // TODO Auto-generated method stub
        return null;
    }
}
