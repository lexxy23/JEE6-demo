/**
 *
 */
package de.jamba.jee6.jpa.impl.entities;

import javax.persistence.Embeddable;

/**
 * A base class to offer an id.
 *
 * @author dstrauss
 */
@Embeddable
public class PersistenceBase {

	/**
	 * the svuid.
	 */
	private static final long serialVersionUID = 3625763408328699359L;

	/**
	 * Inits the base.
	 */
	protected PersistenceBase() {
		// nothing special to do
	}

}
