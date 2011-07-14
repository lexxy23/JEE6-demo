/**
 *
 */
package ext.demo.jee6.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * @author  dstrauss
 */
@XmlType
@XmlEnum
public enum Country {

    /**
     * Germany.
     */
    DE,

    /**
     * United kingdom.
     */
    UK,

    /**
     * United States of America.
     */
    US;
}
