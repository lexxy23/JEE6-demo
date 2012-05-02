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
    public synchronized Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
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
