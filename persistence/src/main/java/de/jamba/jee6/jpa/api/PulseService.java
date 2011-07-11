/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jamba.jee6.jpa.api;

import javax.ejb.Local;

/**
 * A simple heartbeat/pulse service.
 *
 * @author  foxmobile
 */
@Local
public interface PulseService {

    /**
     * Resets the pulse to 0.
     */
    void resetPulse();

    /**
     * Returns the current pulse value.
     *
     * @return  the current pulse value.
     */
    long getPulse();

    /**
     * Performs a heart beat, and returns the new value.
     *
     * @return  the new pulse.
     */
    long pulse();
}
