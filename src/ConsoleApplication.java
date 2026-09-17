import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Person {
    private int id;
    private String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    abstract void show();
}

class Student extends Person {
    private String course;
    private double gpa;

    Student(int id, String name, String course, double gpa) {
        super(id, name);
        this.course = course;
        this.gpa = gpa;
    }

    String getCourse() {
        return course;
    }

    double getGpa() {
        return gpa;
    }

    void setCourse(String course) {
        this.course = course;
    }

    void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    void show() {
        System.out.println(
                "ID: " + getId() + " | Name: " + getName() + " | Course: " + course + " | GPA: " + gpa
        );
    }
}

class StudentManager {
    private List<Student> list = new ArrayList<>();

    StudentManager() {
//        list.add(new Student(101, "Naresh", "Computer Science", 8.9));
//        list.add(new Student(102, "Vamseedhar ", "Java ", 9));
    }

    void add(Student s) {
        if (find(s.getId()) != null) {
            System.out.println("Student with this ID already existsssssss.");
            return;
        }

        list.add(s);
        System.out.println("Student addeddddd.");
    }

    void showAll() {
        if (list.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Students ---");

        for (Student s : list) {
            s.show();
        }
    }

    Student find(int id) {
        for (Student s : list) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    void update(int id, String name, String course, double gpa) {
        Student s = find(id);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        s.setName(name);
        s.setCourse(course);
        s.setGpa(gpa);

        System.out.println("Student updated.");
    }

    void delete(int id) {
        Student s = find(id);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        list.remove(s);
        System.out.println("Student deleted.");
    }
}

public class ConsoleApplication {
    static Scanner sc = new Scanner(System.in);
    static StudentManager sm = new StudentManager();

    public static void main(String[] args) {

        boolean run = true;

        while (run) {
            menu();

            int ch = readInt("Enter choice: ");

            switch (ch) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    sm.showAll();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    run = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }

    static void menu() {
        System.out.println("\n--- Student Management ---");
        System.out.println("1. Add Student");
        System.out.println("2. Show Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }

    static void addStudent() {
        System.out.println("\n--- Add Student ---");

        int id = readInt("Enter ID: ");

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter course: ");
        String course = sc.nextLine();

        double gpa = readDouble("Enter GPA: ");

        Student s = new Student(id, name, course, gpa);

        sm.add(s);
    }

    static void searchStudent() {
        System.out.println("\n--- Search Student ---");

        int id = readInt("Enter ID: ");

        Student s = sm.find(id);

        if (s == null) {
            System.out.println("Student not found.");
        } else {
            s.show();
        }
    }

    static void updateStudent() {
        System.out.println("\n--- Update Student ---");

        int id = readInt("Enter ID: ");

        Student s = sm.find(id);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        System.out.print("Enter new course: ");
        String course = sc.nextLine();

        double gpa = readDouble("Enter new GPA: ");

        sm.update(id, name, course, gpa);
    }

    static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");

        int id = readInt("Enter ID: ");

        sm.delete(id);
    }

    static int readInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    static double readDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid GPA.");
            }
        }
    }
}
