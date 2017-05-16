package src.repository;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.model.Laboratory;
import src.model.Student;

public class FileDataPersistenceTest {
	
	private Laboratory l1,l2,l3;
    private Student s1,s2;
    private FileDataPersistence stuRepo;
    private FileDataPersistence labRepo;

	@Before
	public void setUp() throws Exception {
		s1 = new Student("s1", "Alex", 112);
        s2 = new Student("s2","Tudor", 113);
        l1 = new Laboratory(1, "01/01/1995",1, "s1");
        l2 = new Laboratory(2, "02/01/1995", 2, "s2");
        l3 = new Laboratory(1,"01/01/2002",1,"s1");

        stuRepo = new FileDataPersistence("testStud.txt");
        labRepo = new FileDataPersistence("testLab.txt");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFile() {
		assertEquals("Test for getFile fail", "testStud.txt",stuRepo.getFile());
        assertEquals("Test for getFile fail", "testLab.txt",labRepo.getFile());
	}

	@Test
	public void testSetFile() {
		stuRepo.setFile("1.txt");
		assertEquals("fail in setFile","1.txt",stuRepo.getFile());
	}

	@Test
	public void testSaveStudent() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testSaveLaboratory() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testGetLaboratoryMap() throws NumberFormatException, IOException, ParseException {
		//labRepo.saveLaboratory(l1);
        //Map<String, List<Laboratory>> m = labRepo.getLaboratoryMap();
        //assertEquals("getLaboratoryMap fail", 1,m.get("s1").get(0).getProblemNumber());
        //assertEquals("getLaboratoryMap fail", 1,m.get("s1").get(0).getNumber());
        //assertEquals("getLaboratoryMap fail", "s1",m.get("s1").get(0).getStudentRegNumber());
        //assertEquals("getLaboratoryMap fail", 6.5,m.get("s1").get(0).getGrade(),0.0001);
	}
	



}
