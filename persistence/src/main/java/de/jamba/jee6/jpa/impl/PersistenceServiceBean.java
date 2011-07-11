/**
 *
 */
package de.jamba.jee6.jpa.impl;

import de.jamba.jee6.api.Persistable;
import de.jamba.jee6.api.annotations.LogCall;
import de.jamba.jee6.jpa.api.PersistenceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Basic implementation of the persistence service.
 *
 * @author  dstrauss
 */
@Stateless
@LogCall
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersistenceServiceBean implements PersistenceService {

    /**
     * A logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(PersistenceServiceBean.class);

    /**
     * The entity manager.
     */
    @PersistenceContext(unitName = "jee6Test")
    private EntityManager em;

    /**
     * Inits the bean.
     */
    public PersistenceServiceBean() {
        // nothing special to do
    }

    /**
     * Some methods to start.
     */
    @PostConstruct
    public void onStart() {
        LOG.info("Checking for sequences to generate");
        Query q = em.createNativeQuery("create sequence if not exists seq_address start with 1 increment by 2");
        q.executeUpdate();
        q = em.createNativeQuery("create sequence if not exists seq_pulse start with 1 increment by 2");
        q.executeUpdate();

        LOG.info("Persistence Service is up and running");
    }

    /**
     * Finds a single entry of a persistable object in the database.
     *
     * @param   <E>  the type of the persistable object
     * @param   c    the class of the persistable object
     * @param   id   the primary key of the entry
     *
     * @return  the object, or null if an error occurred.
     */
    private <E extends Persistable> E findSingleEntry(Class<E> c, long id) {
        E rc = null;
        try {
            rc = em.find(c, id);
        } catch (EntityNotFoundException e) {
            LOG.info("No entity found!");
        } catch (NonUniqueResultException e) {
            LOG.warn("Entity exists in more than one way!");
        }
        return rc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Persistable> E store(E obj) {
        em.persist(obj);
        return obj;
    }

    @Override
    public <E extends Persistable> E getById(Class<E> c, long id) {
        E rc = findSingleEntry(c, id);
        return rc;
    }

    @Override
    public <E extends Persistable> void delete(E e) {
        if (e == null) {
            LOG.warn("No entity given to delete!");
            return;
        }
        em.remove(e);
    }

    @Override
    public <E extends Persistable> E updateEntity(E e) {
        if (e == null) {
            LOG.warn("No entity given to update!");
            return null;
        }
        return em.merge(e);
    }
}
