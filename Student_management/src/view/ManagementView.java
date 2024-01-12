package view;

import file.CsvWriterAndRead;
import file.RegexHandler;
import controller.AdminManagement;
import model.*;

import java.util.List;
import java.util.Scanner;

public class ManagementView {
    private static final AdminManagement adminManagement = new AdminManagement();
    private static final CsvWriterAndRead csv = new CsvWriterAndRead();
    private static final Scanner scanner = new Scanner(System.in);

    public void renderView() {
        showMainMenu();
    }
    private static void showMainMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Student Management\n" +
                    "2. Admin Management\n" +
                    "0. Exit\n");
            System.out.print("Your choice: ");
            int choice = scanner.nextByte();
            switch (choice) {
                case 1:
                    showMenuStudent();
                    break;
                case 2:
                    showMenuAdmin();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Choice again");
                    break;
            }
        }
    }

    private static void showMenuAdmin() {
        while (true) {
            List<Student> students = adminManagement.getStudents();
            List<Point1> point1s = adminManagement.getPoint1s();
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                         MENU QUẢN LÝ SINH VIÊN                               ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║ Options:                                                                     ║");
            System.out.println("║ ▶ 1.Thêm mới sinh viên              ▶ 6.Sửa điểm sinh viên                   ║");
            System.out.println("║ ▶ 2.Thêm mới điểm sinh viên         ▶ 7.Xóa sinh viên ra khỏi danh sách      ║");
            System.out.println("║ ▶ 3.Hiển thị danh sách sinh viên    ▶ 8.Viết vào file                        ║");
            System.out.println("║ ▶ 4.Hiển thị danh sách điểm         ▶ 9.Đọc file                             ║");
            System.out.println("║ ▶ 5.Sửa thông tin sinh viên         ▶ 10.Sắp xếp theo tên sinh viên          ║");
            System.out.println("║ ▶ 6.Sửa điểm sinh viên              ▶ 11.Về menu chính                       ║");
            System.out.println("║                                                                              ║");
            System.out.println("║ ▶ Chon chức năng                                                             ║");
            System.out.println("║                    MENU: @copyright: Quốc Phú                                ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");
            int choice = scanner.nextByte();
            scanner.nextLine();
            switch (choice){
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addNewStudentPoint();
                    break;
                case 3:
                    displayStudentList();
                    break;
                case 4:
                    displayStudentAndPoint();
                    break;
                case 5:
                    editStudentById(students);
                    break;
                case 6:
                    editSubjectPointsByCode();
                    break;
                case 7:
                    System.out.println("Enter studentCode want to delete: ");
                    String codeStudent = RegexHandler.checkRegexStudentCode();
                    adminManagement.deleteStudentByCode(codeStudent);
                    break;
                case 8:
                    csv.writeStudent(students);
                    csv.writeAll(point1s);
                    break;
                case 9:
                    csv.readStudent();
                    csv.readAll();
                    break;
                case 10:
                    adminManagement.sortStudentsByNameVietnamese();
                    displayStudentList();
                    break;
                case 11:
                    showMainMenu();
                    break;
                default:
                    System.out.println("choice again: ");
                    break;
            }
        }
    }

    private static void showMenuStudent() {
        while (true){
            List<Point1> point1s = adminManagement.getPoint1s();
            System.out.println("Student Menu");
            System.out.println("1. display student list");
            System.out.println("2. display all list");
            System.out.println("3. find student");
            System.out.println("4. Back Main Menu");
            int choice = scanner.nextByte();
            scanner.nextLine();
            switch (choice){
                case 1:
                    displayStudentList();
                    break;
                case 2:
                    displayStudentAndPoint();
                    break;
                case 3:
                    findStudentById(point1s);
                    break;
                case 4:
                    showMainMenu();
                    break;
                default:
                    System.out.println("choice again: ");
                    break;
            }
        }
    }

    private static void findStudentById(List<Point1> point1s) {
        System.out.println("Enter student code to find:");
        String codeStudent = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < point1s.size(); i++) {
            if (point1s.get(i).getStudentCode().equals(codeStudent)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("Information found: ");
            System.out.println(point1s.get(index));
        } else {
            System.out.println("Student with code " + codeStudent + " not found.");
        }
    }

    public static void addNewStudent(){
        System.out.println("Enter student code: ");
        String code = RegexHandler.checkRegexStudentCode();
        System.out.println("Enter first name: ");
        String firstName = RegexHandler.checkRegexName();
        System.out.println("Enter last name: ");
        String lastName = RegexHandler.checkRegexName();
        System.out.println("Enter gender: ");
        String gender = RegexHandler.checkGender();
        System.out.println("Enter day of birth");
        String dayOfBirth = RegexHandler.checkRegexDate();
        System.out.println("Enter phone");
        String phone = RegexHandler.checkPhoneNumber();
        Student student = new Student(code, firstName, lastName, gender, dayOfBirth, phone);
        adminManagement.addStudent(student);
        System.out.println("Done add");
    }
    private static double enterSubjectData(String subject) {
        System.out.println("Enter id for " + subject + ": ");
        String id = scanner.nextLine();
        System.out.println("Enter exercise points: ");
        double exercisePoints = Double.parseDouble(RegexHandler.checkNumOfCredits());
        System.out.println("Enter test marks: ");
        double testMarks = Double.parseDouble(RegexHandler.checkNumOfCredits());
        System.out.println("Enter practice Point: ");
        double practicePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
        System.out.println("Enter midterm Score: ");
        double midtermScore = Double.parseDouble(RegexHandler.checkNumOfCredits());
        System.out.println("Enter final Grade: ");
        double finalGrade = Double.parseDouble(RegexHandler.checkNumOfCredits());

        switch (subject) {
            case "Maths":
                Maths maths = new Maths(id, exercisePoints, testMarks, midtermScore, finalGrade, practicePoint);
                return maths.getAvgPoint();
            case "Physical":
                Physical physical = new Physical(id, exercisePoints, testMarks, midtermScore, finalGrade, practicePoint);
                return physical.getAvgPoint();
            case "Chemistry":
                Chemistry chemistry = new Chemistry(id, exercisePoints, testMarks, midtermScore, finalGrade, practicePoint);
                return chemistry.getAvgPoint();
            default:
                System.out.println("Invalid subject");
                return 0.0;
        }
    }

    public static void addNewStudentPoint() {
        System.out.println("Enter student code: ");
        String code = RegexHandler.checkRegexStudentCode();
        System.out.println("Enter first name: ");
        String firstName = RegexHandler.checkRegexName();
        System.out.println("Enter last name: ");
        String lastName = RegexHandler.checkRegexName();
        System.out.println("Enter gender: ");
        String gender = RegexHandler.checkGender();
        System.out.println("Enter day of birth");
        String dayOfBirth = RegexHandler.checkRegexDate();
        System.out.println("Enter phone");
        String phone = RegexHandler.checkPhoneNumber();

        double avgMaths = enterSubjectData("Maths");

        double avgPhysical = enterSubjectData("Physical");

        double avgChemistry = enterSubjectData("Chemistry");

        Point1 point1 = new Point1(code, firstName, lastName, gender, dayOfBirth, phone, avgMaths, avgPhysical, avgChemistry);

        adminManagement.addPoint(point1);
        System.out.println("Done add");
    }

    public static void editStudentById(List<Student> students) {
        System.out.println("Enter student code to edit:");
        String studentCodeToEdit = scanner.nextLine().trim();
        int indexOfStudentToEdit = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentCode().equals(studentCodeToEdit)) {
                indexOfStudentToEdit = i;
                break;
            }
        }

        if (indexOfStudentToEdit != -1) {
            System.out.println("Information before editing: ");
            System.out.println(students.get(indexOfStudentToEdit));

            System.out.println("Select the information to edit: ");
            System.out.println("1. First Name");
            System.out.println("2. Last Name");
            System.out.println("3. Gender");
            System.out.println("4. Day of brith");
            System.out.println("5. phone");

            System.out.print("Enter your selection: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter new first name: ");
                    String newFirstName = RegexHandler.checkRegexName();
                    students.get(indexOfStudentToEdit).setFirstName(newFirstName);
                    break;
                case 2:
                    System.out.print("Enter new last name: ");
                    String newLastName = RegexHandler.checkRegexName();
                    students.get(indexOfStudentToEdit).setLastName(newLastName);
                    break;
                case 3:
                    System.out.print("Enter new gender: ");
                    String newGender = RegexHandler.checkRegexName();
                    students.get(indexOfStudentToEdit).setGender(newGender);
                    break;
                case 4:
                    System.out.println("Enter day of brith: ");
                    String newDay = RegexHandler.checkRegexDate();
                    students.get(indexOfStudentToEdit).setDayOfBirth(newDay);
                    break;
                case 5:
                    System.out.println("Enter new phone: ");
                    String newPhone = RegexHandler.checkPhoneNumber();
                    students.get(indexOfStudentToEdit).setPhone(newPhone);
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }

            System.out.println("Information after editing:");
            System.out.println(students.get(indexOfStudentToEdit));
        } else {
                System.out.println("No student found with ID: " + studentCodeToEdit);
        }
    }
    private static void editSubjectPointsByCode() {
        System.out.println("Enter student code to edit subject points:");
        String studentCodeToEdit = scanner.nextLine().trim();
        System.out.println("Enter subject (Maths, Physical, Chemistry): ");
        String subject = scanner.nextLine();
        System.out.println("Enter new exercise points: ");
        double newExercisePoints = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter new test marks: ");
        double newTestMarks = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter new practice point: ");
        double newPracticePoint = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter new midterm score: ");
        double newMidtermScore = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter new final grade: ");
        double newFinalGrade = Double.parseDouble(scanner.nextLine());

        adminManagement.editSubjectPointsByStudentCode(studentCodeToEdit, subject, newExercisePoints, newTestMarks, newPracticePoint, newMidtermScore, newFinalGrade);
    }
    


    public static void displayStudentList() {
        List<Student> students = adminManagement.getStudents();
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    private static void displayStudentAndPoint() {
        List<Point1> point1s = adminManagement.getPoint1s();
        System.out.println("List Student and Point");
        for (Point1 point1: point1s){
            System.out.println(point1);
        }
    }
}


