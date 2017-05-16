package src.repository;

import src.model.Laboratory;
import src.model.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDataPersistence {
    private String file;

    public FileDataPersistence(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void saveStudent(Student student) {
        try {
        	BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(file, true));
            String forWrite = "";
            forWrite += student.getRegNumber() + "#" + student.getName() + "#" + student.getGroup() + "\n";
            //writer.write(student.toString() + "\n");
            writer.write(forWrite);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // No check if laboratory is unique
    public void saveLaboratory(Laboratory laboratory) {
    	BufferedWriter writter;
        try {
            writter = new BufferedWriter(new FileWriter(file, true));
            int month = laboratory.getDate().getMonth() + 1;
            int year = laboratory.getDate().getYear() + 1900;

            String forWrite =  laboratory.getNumber() + "#" + laboratory.getDate().getDate() + "/" + month + "/" + year + "#"
                    + laboratory.getProblemNumber() + "#" + laboratory.getGrade() + "#" + laboratory.getStudentRegNumber() + '\n';
            writter.write(forWrite);
            writter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Ambiguous what field of "Student" should be passed
    public void addGrade(String student, String labNumber, float grade)
            throws IOException, NumberFormatException, ParseException {
        File fileA = new File(file);
        File fileB = new File("temp");

        BufferedReader reader = new BufferedReader(new FileReader(fileA));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileB));

        String line;

        while ((line = reader.readLine()) != null) {
            String[] temp = line.split(" ");
            String fileLabNumber = temp[0];
            String fileStudentNumber = temp[4];
            if (fileLabNumber.equals(labNumber) && fileStudentNumber.equals(student)) {
                Laboratory laboratory = new Laboratory(
                        Integer.valueOf(temp[0]), temp[1],
                        Integer.valueOf(temp[2]), temp[4]);
                laboratory.setGrade(grade);
                writer.write(laboratory.toString() + "\n");
            } else {
                writer.write(line + "\n");
            }
        }
        writer.close();
        reader.close();

        fileA.delete();
        fileB.renameTo(fileA);
    }

    public Map<String, List<Laboratory>> getLaboratoryMap()
            throws NumberFormatException, IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        Map<String, List<Laboratory>> laboratoryMap = new HashMap<String, List<Laboratory>>();

        String line;

        while ((line = reader.readLine()) != null) {
            String[] temp = line.split(" ");
            Laboratory laboratory = new Laboratory(Integer.valueOf(temp[0]),
                    temp[1], Integer.valueOf(temp[2]), Float.valueOf(temp[3]),
                    temp[4]);
            if (laboratoryMap.get(laboratory.getStudentRegNumber()) == null) {
                List<Laboratory> laboratoryList = new ArrayList<Laboratory>();
                laboratoryList.add(laboratory);
                laboratoryMap.put(laboratory.getStudentRegNumber(),
                        laboratoryList);
            } else {
                laboratoryMap.get(laboratory.getStudentRegNumber()).add(
                        laboratory);
            }
        }
        return laboratoryMap;
    }

    public List<Student> getStudentsList() throws NumberFormatException,
            IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<Student> allStudentsList = new ArrayList<Student>();

        String line = null;

        while ((line = reader.readLine()) != null) {
            String[] temp = line.split(" ");
            Student student = new Student(temp[0], temp[1] + temp[2], Integer.valueOf(temp[3]));
            allStudentsList.add(student);
        }

        return allStudentsList;
    }
} 