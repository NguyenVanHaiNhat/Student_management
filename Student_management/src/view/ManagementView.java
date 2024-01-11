package view;

import file.CsvWriterAndRead;
import file.RegexHandler;
import management.AdminManagement;
import model.Student;
import model.Subject;
import model.SubjectHasThreeCredits;
import model.SubjectHasTwoCredits;

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
            List<Subject> subjects = adminManagement.getSubjects();
            System.out.println("Admin Management");
            System.out.println("1. add new student");
            System.out.println("2. add new subject");
            System.out.println("3. display student");
            System.out.println("4. display subject");
            System.out.println("5. edit student");
            System.out.println("6. edit subject point");
            System.out.println("7. delete student");
            System.out.println("8. delete point");
            System.out.println("9. write to file");
            System.out.println("10. read to file");
            System.out.println("11. Back Main Menu");
            System.out.print("your choice: ");
            int choice = scanner.nextByte();

            scanner.nextLine();
            switch (choice){
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addSubject();
                    break;
                case 3:
                    displayStudentList();
                    break;
                case 4:
                    displaySubjectList();
                    break;
                case 5:
                    editStudentById(students);
                    break;
                case 6:
                    editPoint(subjects);
                    break;
                case 7:
                    System.out.println("Enter studentCode want to delete: ");
                    String codeStudent = RegexHandler.checkRegexStudentCode();
                    adminManagement.deleteStudentByCode(codeStudent);
                    break;
                case 8:
                    System.out.println("Enter subjectCode wain to delete: ");
                    String codeSubject = RegexHandler.checkRegexSubjectCode();
                    adminManagement.deleteSubjectByCode(codeSubject);
                    break;
                case 9:
                    csv.writeStudent(students);
                    break;
                case 10:
                    csv.readStudent();
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
            List<Student> students = adminManagement.getStudents();
            List<Subject> subjects = adminManagement.getSubjects();
            System.out.println("Student Menu");
            System.out.println("1. display student list");
            System.out.println("2. display subject list");
            System.out.println("3. find student");
            System.out.println("4. find subject");
            System.out.println("5. Back Main Menu");
            int choice = scanner.nextByte();
            switch (choice){
                case 1:
                    displayStudentList();
                    break;
                case 2:
                    displaySubjectList();
                    break;
                case 3:
                    findStudentById(students);
                    break;
                case 4:
                    findSubjectById(subjects);
                    break;
                case 5:
                    showMainMenu();
                    break;
                default:
                    System.out.println("choice again: ");
                    break;
            }
        }
    }

    private static void findSubjectById(List<Subject> subjects) {
        System.out.println("Enter subject code to find:");
        String codeSubject = scanner.nextLine().trim();
        int index = -1;
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getCodeSubject().equals(codeSubject)){
                index = i;
                break;
            }
        }
        if (index != -1){
            System.out.println("Thông tin được tìm thấy: ");
            System.out.println(subjects.get(index));
        }
    }

    private static void findStudentById(List<Student> students) {
        System.out.println("Enter student code to find:");
        String codeStudent = scanner.nextLine().trim();
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentCode().equals(codeStudent)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("Thông tin được tìm thấy: ");
            System.out.println(students.get(index));
        }
    }

    public static void addSubject(){
        System.out.println("Enter name subject: ");
        String nameSubject = RegexHandler.checkRegexName();
        System.out.println("Enter code subject: ");
        String codeSubject = RegexHandler.checkRegexSubjectCode();
        System.out.println("Enter number of credits: ");
        String numOfCredits = RegexHandler.checkNumOfCredits();
        System.out.println("Enter day start: ");
        String dayStart = RegexHandler.checkRegexDate();
        System.out.println("Enter day end: ");
        String dayEnd = RegexHandler.checkRegexDate();

        System.out.println("1. Subject has two credits");
        System.out.println("2. Subject has three credits");
        int choice = scanner.nextByte();
        switch (choice){
            case 1:
                System.out.println("Enter exercise points: ");
                double exercisePoints = Double.parseDouble(RegexHandler.checkNumOfCredits());
                System.out.println("Enter midterm Score: ");
                double midtermScore = Double.parseDouble(RegexHandler.checkNumOfCredits());
                System.out.println("Enter final Grade: ");
                double finalGrade = Double.parseDouble(RegexHandler.checkNumOfCredits());
                SubjectHasTwoCredits subject2 = new SubjectHasTwoCredits(nameSubject, codeSubject, numOfCredits, dayStart, dayEnd, exercisePoints, midtermScore, finalGrade);
                adminManagement.addSubject(subject2);
                System.out.println("Done add");
                break;
            case 2:
                System.out.println("Enter exercise points: ");
                double exercisePoints3 = Double.parseDouble(RegexHandler.checkNumOfCredits());
                System.out.println("Enter test Mark: ");
                double testMarks = Double.parseDouble(RegexHandler.checkNumOfCredits());
                System.out.println("Enter midterm Score: ");
                double midtermScore3 = Double.parseDouble(RegexHandler.checkNumOfCredits());
                System.out.println("Enter final Grade: ");
                double finalGrade3 = Double.parseDouble(RegexHandler.checkNumOfCredits());
                System.out.println("Enter practice Point: ");
                double practicePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                SubjectHasThreeCredits subject3 = new SubjectHasThreeCredits(nameSubject, codeSubject, numOfCredits, dayStart, dayEnd, exercisePoints3, testMarks, midtermScore3, finalGrade3, practicePoint);
                adminManagement.addSubject(subject3);
                System.out.println("Done add");
                break;
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
            System.out.println("Thông tin trước khi sửa:");
            System.out.println(students.get(indexOfStudentToEdit));

            System.out.println("Chọn thông tin cần sửa:");
            System.out.println("1. Tên");
            System.out.println("2. Họ");
            System.out.println("3. Giới tính");
            System.out.println("4. Ngày sinh");
            System.out.println("5. sdt");

            System.out.print("Nhập lựa chọn của bạn: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.print("Nhập họ mới: ");
                    String newFirstName = RegexHandler.checkRegexName();
                    students.get(indexOfStudentToEdit).setFirstName(newFirstName);
                    break;
                case 2:
                    System.out.print("Nhập tên mới: ");
                    String newLastName = RegexHandler.checkRegexName();
                    students.get(indexOfStudentToEdit).setLastName(newLastName);
                    break;
                case 3:
                    System.out.print("Nhập giới tính mới: ");
                    String newGender = RegexHandler.checkRegexName();
                    students.get(indexOfStudentToEdit).setGender(newGender);
                    break;
                case 4:
                    System.out.println("Nhập ngày sinh: ");
                    String newDay = RegexHandler.checkRegexDate();
                    students.get(indexOfStudentToEdit).setDayOfBirth(newDay);
                    break;
                case 5:
                    System.out.println("Nhập số điện thoại");
                    String newPhone = RegexHandler.checkPhoneNumber();
                    students.get(indexOfStudentToEdit).setPhone(newPhone);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }

            System.out.println("Thông tin sau khi sửa:");
            System.out.println(students.get(indexOfStudentToEdit));
        } else {
            System.out.println("Không tìm thấy sinh viên có ID: " + studentCodeToEdit);
        }
    }
    public static void editPoint(List<Subject> subjects){
        System.out.println("Enter subject code to edit:");
        String codeSubject = scanner.nextLine().trim();
        int indexOfPointToEdit = -1;
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getCodeSubject().equals(codeSubject)) {
                indexOfPointToEdit = i;
                break;
            }
        }
        if (indexOfPointToEdit != -1) {
            System.out.println("Thông tin trước khi sửa:");
            System.out.println(subjects.get(indexOfPointToEdit));

            System.out.println("Chọn thông tin cần sửa:");
            System.out.println("1. Điểm bài tập");
            System.out.println("2. Điểm kiểm tra");
            System.out.println("3. Điểm giữa kì");
            System.out.println("4. Điểm cuối kì");
            System.out.println("5. Điểm thực hành");

            System.out.print("Nhập lựa chọn của bạn: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.print("Nhập Điểm bài tập mới: ");
                    String newFirstName = RegexHandler.checkRegexName();
                    subjects.get(indexOfPointToEdit).setFirstName(newFirstName);
                    break;
                case 2:
                    System.out.print("Nhập Điểm kiểm tra mới: ");
                    String newLastName = RegexHandler.checkRegexName();
                    subjects.get(indexOfPointToEdit).setLastName(newLastName);
                    break;
                case 3:
                    System.out.print("Nhập Điểm giữa kì mới: ");
                    String newGender = RegexHandler.checkRegexName();
                    subjects.get(indexOfPointToEdit).setGender(newGender);
                    break;
                case 4:
                    System.out.println("Nhập Điểm cuối kì mới: ");
                    String newDay = RegexHandler.checkRegexDate();
                    subjects.get(indexOfPointToEdit).setDayOfBirth(newDay);
                    break;
                case 5:
                    System.out.println("Nhập Điểm thực hành mới: ");
                    String newPhone = RegexHandler.checkPhoneNumber();
                    subjects.get(indexOfPointToEdit).setPhone(newPhone);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }

            System.out.println("Thông tin sau khi sửa:");
            System.out.println(subjects.get(indexOfPointToEdit));
        } else {
            System.out.println("Không tìm thấy sinh viên có ID: " + codeSubject);
        }
    }
    public static void displayStudentList() {
        List<Student> students = adminManagement.getStudents();
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public static void displaySubjectList(){
        List<Subject> subjects = adminManagement.getSubjects();
        System.out.println("List of Subject:");
        for (Subject subject: subjects){
            System.out.println(subject);
        }
    }
}


