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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ext.demo.jee6.jpa.api.PulseService;

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
//    @Schedule(
//        hour = "*",
//        minute = "*",
//        second = "*/20",
//        info = TIMER_NAME,
//        persistent = false
//    )
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
