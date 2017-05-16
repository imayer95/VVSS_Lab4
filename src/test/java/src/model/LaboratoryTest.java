package src.model;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LaboratoryTest {
	private Laboratory l1, l2;
	@Before
	public void setUp() throws Exception {
		l1 = new Laboratory(1, "09/09/2009", 1, "1");
        l2 = new Laboratory(2, "10/10/2010", 2, new Float(9.0), "2");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNumber() {
		assertEquals("Test for getNumber fail", 1,l1.getNumber());
        assertEquals("Test for getNumber fail", 2,l2.getNumber());
	}

	@Test
	public void testSetNumber() {
		l2.setNumber(3);
        assertEquals("Test for setNumber fail", 3, l2.getNumber());
	}

	@Test
	public void testGetDate() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals("Test getDate fail", format.parse("10/10/2010"), l2.getDate());
	}

	@Test
	public void testSetDate() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = format.parse("03/03/2003");
        l2.setDate(d1);
        assertEquals("Test setDate fail", format.parse("03/03/2003"), l2.getDate());
	}

	@Test
	public void testGetProblemNumber() {
        assertEquals("Test for getProblemNumber fail", 1, l1.getProblemNumber());
        assertEquals("Test for getProblemNumber fail", 2, l2.getProblemNumber());

	}

	@Test
	public void testSetProblemNumber() {
		l1.setProblemNumber(4);
        assertEquals("setProblemNumber fail",4,l1.getProblemNumber());
        l1.setProblemNumber(5);
        assertEquals("setProblemNumber fail",5,l1.getProblemNumber());
	}

	@Test
	public void testGetGrade() {
		assertEquals("getGrade fail",9.0,l2.getGrade(),0.00001);
	}

	@Test
	public void testSetGrade() {
		l1.setGrade((float)3.5);
        assertEquals("setGrade fail",3.5,l1.getGrade(),0.00001);
        l1.setGrade((float)8.5);
        assertEquals("setGrade fail",8.5,l1.getGrade(),0.00001);
	}

	@Test
	public void testGetStudentRegNumber() {
		assertEquals("getStudentRegNumber fail", "1", l1.getStudentRegNumber());
        assertEquals("getStudentRegNumber fail", "2", l2.getStudentRegNumber());
	}

	@Test
	public void testSetStudentRegNumber() {
		l1.setStudentRegNumber("l1");
        assertEquals("getStudentRegNumber fail", "l1", l1.getStudentRegNumber());

        l2.setStudentRegNumber("l2");
        assertEquals("getStudentRegNumber fail", "l2", l2.getStudentRegNumber());
	}

}
