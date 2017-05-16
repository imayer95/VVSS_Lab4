package src.validator;

import static org.junit.Assert.*;
import src.model.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {
	private Validator valid;
	private Student s1, s2, s3;
	private Laboratory l1,l2,l3,l4;
	@Before
	public void setUp() throws Exception {
		valid = new Validator();
		
		s1 = new Student("dmig0011","Alex",731);
		s2 = new Student("bfig0004","Flaviu", -731);
		s3 = new Student("miig0020", "Ingrid", 731);
		
		l1 = new Laboratory(1,"10/10/2010",1,"dmig0011");
		l2 = new Laboratory(0, "12/12/2012",2,"miig0020");
		l3 = new Laboratory(1, "11/03/2000",3,"bfig0004");
		l4 = new Laboratory(2, "09/09/2009",-3,new Float(10.00),"dmig0011");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateStudent() {
		assertTrue("fail validateStudent",Validator.validateStudent(s1));
		assertFalse("fail validateStudent", Validator.validateStudent(s2));
		assertTrue("fail validateStudent", Validator.validateStudent(s3));
		
	}

	@Test
	public void testValidateLaboratory() {
		//System.out.println("Sunt in validateLaboratory");
		assertTrue("fail validateLaboratory", Validator.validateLaboratory(l1));
		assertFalse("fail validateLaboratory", Validator.validateLaboratory(l2));
		assertTrue("fail validateLaboratory", Validator.validateLaboratory(l3));
		assertFalse("fail validateLaboratory", Validator.validateLaboratory(l4));
	}

	@Test
	public void testValidateGrade() {
		assertTrue("fail validateGrade", Validator.validateGrade(l4.getGrade()));
	}

}
