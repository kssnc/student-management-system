import java.util.ArrayList;
import java.util.Scanner;


public class StuManSy{
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Update Student Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: updateMarks(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
        sc.close();
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        sc.nextLine(); // consume newline
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        System.out.print("Enter marks: ");
        int marks = sc.nextInt();
        students.add(new Student(name, rollNo, marks));
        System.out.println("Student added successfully.");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : students) {
                s.display();
            }
        }
    }

    static void updateMarks() {
        System.out.print("Enter roll number to update marks: ");
        int rollNo = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.print("Enter new marks: ");
                s.marks = sc.nextInt();
                System.out.println("Marks updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with roll number " + rollNo + " not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter roll number to delete: ");
        int rollNo = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).rollNo == rollNo) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with roll number " + rollNo + " not found.");
        }
    }
}