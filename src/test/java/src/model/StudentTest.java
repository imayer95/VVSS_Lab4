package src.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	
	private Student s1;
    private Student s2;

	@Before
	public void setUp() throws Exception {
		s1 = new Student("11","Alex",100);
        s2 = new Student( "12", "Tudor", 999);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetRegNumber() {
		assertEquals("Test getRegNumber fail", "11",s1.getRegNumber());
        assertEquals("Test getRegNumber fail", "12",s2.getRegNumber());
	}

	@Test
	public void testSetRegNumber() {
		s1.setRegNumber("111");
        assertEquals("setRegNumber fail", "111",s1.getRegNumber());

        s1.setRegNumber("112");
        assertEquals("setRegNumber fail", "112",s1.getRegNumber());
	}

	@Test
	public void testGetName() {
		assertEquals("Test getName fail", "Alex", s1.getName());
        assertEquals("Test getName fail", "Tudor", s2.getName());
	}

	@Test
	public void testSetName() {
		s1.setName("student1");
        assertEquals("Test setName fail", "student1", s1.getName());

        s1.setName("student2");
        assertEquals("Test setName fail", "student2", s1.getName());
	}

	@Test
	public void testGetGroup() {
		assertEquals("Test for getGroup fail", 100, s1.getGroup());
        assertEquals("Test for getGroup fail", 999, s2.getGroup());
	}

	@Test
	public void testSetGroup() {
		s1.setGroup(733);
        assertEquals("Test for setGroup fail", 733, s1.getGroup());

        s1.setGroup(734);
        assertEquals("Test for setGroup fail", 734, s1.getGroup());

	}

}
