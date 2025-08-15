import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.txt";

    public StudentManager() {
        loadFromFile();
    }

    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    public void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) System.out.println(s);
        }
    }

    public Student searchByRollNo(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) return s;
        }
        return null;
    }

    public void deleteStudent(int rollNo) {
        students.removeIf(s -> s.getRollNo() == rollNo);
        saveToFile();
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.getRollNo() + "," + s.getName() + "," + s.getAge() + "," + s.getGrade());
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3]));
            }
        } catch (IOException e) {
            // File may not exist initially
        }
    }
}
