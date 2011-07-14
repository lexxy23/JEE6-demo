/**
 *
 */
package ext.demo.jee6.jpa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ext.demo.jee6.api.Persistable;

/**
 * The pulse entity.
 *
 * @author  dstrauss
 */
@Entity
@Table(name = "JE6_PULSE")
public class PulseEntity implements Persistable {

    /**
     * The svuid.
     */
    private static final long serialVersionUID = 2293310189213334760L;

    /**
     * The id of the entry.
     */
    @Id
    @SequenceGenerator(
        allocationSize = 2,
        initialValue = 1,
        name = "seq2",
        sequenceName = "seq_pulse"
    )
    @GeneratedValue(
        generator = "seq2",
        strategy = GenerationType.SEQUENCE
    )
    private long id;

    /**
     * The pulse value.
     */
    @Column(
        name = "pulse",
        nullable = false
    )
    private long pulse = -1;

    /**
     * Inits the entity.
     */
    public PulseEntity() {
        // nothing special.
    }

    /**
     * @return  the pulse
     */
    public synchronized long getPulse() {
        return pulse;
    }

    /**
     * @param  pulse  the pulse to set
     */
    public synchronized void setPulse(long pulse) {
        this.pulse = pulse;
    }

    /**
     * @return  the id
     */
    @Override
    public synchronized long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Increments the pulse value by 1 and returns the new value.
     *
     * @return  the new pulse value
     */
    public long incrementPulse() {
        return ++pulse;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(PulseEntity.class.getName());
        sb.append("(");
        sb.append("id=").append(id);
        sb.append(",pulse=").append(pulse);
        sb.append(")");
        return sb.toString();
    }
}
