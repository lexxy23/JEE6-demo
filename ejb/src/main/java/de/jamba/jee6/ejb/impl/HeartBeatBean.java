/**
 *
 */
package de.jamba.jee6.ejb.impl;

import de.jamba.jee6.jpa.api.PulseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timeout;

/**
 * Simple heartbeat bean.
 *
 * @author  dstrauss
 */
@Singleton(name = "Jee6HeartBeat")
public class HeartBeatBean {

    /**
     * A logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(HeartBeatBean.class);

    /**
     * The timer name.
     */
    private static final String TIMER_NAME = "Jee6Demo Heartbeat Timer";

    /**
     * The persistence service.
     */
    @EJB
    private PulseService svc;

    /**
     * Inits the bean.
     */
    public HeartBeatBean() {
        // nothing special
    }

    /**
     * On start.
     */
    @PostConstruct
    public void onStart() {
        LOG.info("I\'m alive");
        svc.resetPulse();
    }

    /**
     * On stop or end.
     */
    @PreDestroy
    public void onStop() {
        LOG.info("Dieing ... with pulse = " + svc.getPulse());
    }

    /**
     * Prints out a info message on every minute.
     */
    @Schedule(
        hour = "*",
        minute = "*",
        second = "*/20",
        info = TIMER_NAME,
        persistent = false
    )
    public void beat() {
        LOG.info("Heart still going on: " + svc.pulse());
    }

    /**
     * Timeout operations. A timer can be scheduled but it is never guaranteed that it will start at
     * the given time.
     */
    @Timeout
    public void onTimeout() {
        LOG.warn("Timeout occurred??");
    }
}
