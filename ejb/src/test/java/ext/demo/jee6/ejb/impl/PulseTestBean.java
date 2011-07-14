/**
 *
 */
package ext.demo.jee6.ejb.impl;

import javax.ejb.Stateless;

import ext.demo.jee6.jpa.api.PulseService;

/**
 * @author dstrauss
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
    
    @Override
    public void resetPulse() {
        pulse = 0;
    }
    
    @Override
    public long getPulse() {
        return pulse;
    }
    
    @Override
    public long pulse() {
        return ++pulse;
    }
}
