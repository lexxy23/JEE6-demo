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
package ext.demo.jee6.ejb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ejb.Stateless;

import ext.demo.jee6.api.Persistable;
import ext.demo.jee6.jpa.api.PersistenceService;

/**
 * @author dstrauss
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
     * @param c
     *            the class of the entity.
     * @param id
     *            the id of the entity
     * 
     * @return a map key, or null if an error occurred.
     */
    private String createMapKey(Class<?> c, long id) {
        if (c == null) {
            return null;
        }
        return createMapKey(c.getSimpleName(), id);
    }
    
    /**
     * Creates a map key for the given simple class name and the id of the
     * entry.
     * 
     * @param simpleClassName
     *            the simple class name
     * @param id
     *            the id of the entry.
     * 
     * @return a map key, or null in case of an error.
     */
    private String createMapKey(String simpleClassName, long id) {
        StringBuffer sb = new StringBuffer();
        sb.append(simpleClassName);
        sb.append(id);
        return sb.toString();
    }
    
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

//	@Override
//	public List<? extends Persistable> findAll(Class<? extends Persistable> c) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	


}
