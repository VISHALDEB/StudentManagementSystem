import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Roll No: "); int roll = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: "); String grade = sc.nextLine();
                    sm.addStudent(new Student(roll, name, age, grade));
                    break;

                case 2:
                    sm.viewAll();
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int searchRoll = sc.nextInt();
                    Student s = sm.searchByRollNo(searchRoll);
                    if (s != null) System.out.println("Found: " + s);
                    else System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter Roll No to update: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();
                    Student stu = sm.searchByRollNo(updateRoll);
                    if (stu != null) {
                        System.out.print("New Name: "); stu.setName(sc.nextLine());
                        System.out.print("New Age: "); stu.setAge(sc.nextInt());
                        sc.nextLine();
                        System.out.print("New Grade: "); stu.setGrade(sc.nextLine());
                        sm.saveToFile();
                        System.out.println("Updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Roll No to delete: ");
                    sm.deleteStudent(sc.nextInt());
                    System.out.println("Deleted successfully.");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
