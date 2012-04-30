/**
 * 
 */
package ext.tools.jee6.rs.web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ext.tools.jee6.rs.impl.AddressBookResourceImpl;

/**
 * @author dstrauss
 * 
 */
@ApplicationPath("rs")
public class AddressbookApplication extends Application {
    
    /**
     * 
     */
    public AddressbookApplication() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> rsImpls = new HashSet<Class<?>>();
        rsImpls.add(AddressBookResourceImpl.class);
        return rsImpls;
    }
    
}
