/**
 * 
 */
package ext.demo.jee6.jpa;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ext.demo.jee6.jpa.model.AddressEntity;

/**
 * Simple validator check.
 * 
 * @author dstrauss
 * 
 */
public class ValidatorTest {
    private Validator val;
    
    /**
     * 
     */
    public ValidatorTest() {
        // TODO Auto-generated constructor stub
    }
    
    @BeforeClass
    public void onClass() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        val = factory.getValidator();
    }
    
    @Test
    public void testEmpty() {
        AddressEntity e = new AddressEntity();
        Set<ConstraintViolation<AddressEntity>> errors = val.validate(e);
        Assert.assertNotNull(errors);
        Assert.assertTrue(errors.size() > 0);
    }
}
