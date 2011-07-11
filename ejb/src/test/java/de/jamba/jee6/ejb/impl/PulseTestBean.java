/**
 *
 */
package de.jamba.jee6.ejb.impl;

import de.jamba.jee6.jpa.api.PulseService;

import javax.ejb.Stateless;

/**
 * @author  dstrauss
 */
@Stateless
public class PulseTestBean implements PulseService {

    /**
     * The pulse.
     */
    private long pulse = 0;

    /**
     */
    public PulseTestBean() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see de.jamba.jee6.jpa.api.PulseService#resetPulse()
     */
    @Override
    public void resetPulse() {
        pulse = 0;
    }

    /* (non-Javadoc)
     * @see de.jamba.jee6.jpa.api.PulseService#getPulse()
     */
    @Override
    public long getPulse() {
        return pulse;
    }

    /* (non-Javadoc)
     * @see de.jamba.jee6.jpa.api.PulseService#pulse()
     */
    @Override
    public long pulse() {
        return ++pulse;
    }
}
