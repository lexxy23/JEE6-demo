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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ext.demo.jee6.jpa.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ext.demo.jee6.api.annotations.LogCall;
import ext.demo.jee6.jpa.api.PersistenceService;
import ext.demo.jee6.jpa.api.PulseService;
import ext.demo.jee6.jpa.model.PulseEntity;

import javax.annotation.PreDestroy;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * The pulse service implementation.
 *
 * @author  foxmobile
 */
@Singleton
@LogCall
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PulseServiceBean implements PulseService {

    /**
     * A logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(PulseServiceBean.class);

    /**
     * The pk for the pulse.
     */
    private long pulseId = 0;

    /**
     * The persistence service.
     */
    @EJB
    private PersistenceService svc;

    /**
     * Actions to perform on end of the bean.
     */
    @PreDestroy
    public void onEnd() {
        PulseEntity pulse = svc.getById(PulseEntity.class, pulseId);
        if (pulse != null) {
            svc.delete(pulse);
            LOG.info("deleted pulse " + pulseId);
        }
    }

    @Override
    public void resetPulse() {
        PulseEntity pulse = svc.getById(PulseEntity.class, pulseId);
        if (pulse == null) {
            LOG.info("No pulse found. Exiting.");
            return;
        }
        pulse.setPulse(0);
        svc.updateEntity(pulse);
    }

    @Override
    public long getPulse() {
        PulseEntity pulse = svc.getById(PulseEntity.class, pulseId);
        if (pulse == null) {
            return -1;
        }
        return pulse.getPulse();
    }

    @Override
    public long pulse() {
        PulseEntity pulse = svc.getById(PulseEntity.class, pulseId);
        if (pulse == null) {
            pulse = new PulseEntity();
            svc.store(pulse);
            LOG.info("pulse created: " + pulse);
            pulseId = pulse.getId();
        }
        pulse.incrementPulse();
        svc.updateEntity(pulse);
        return pulse.getPulse();
    }
}
