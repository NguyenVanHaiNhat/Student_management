package view;

import file.RegexHandler;
import management.AdminManagement;
import model.Student;
import model.Subject;
import model.SubjectHasThreeCredits;
import model.SubjectHasTwoCredits;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementView {
    public static void addNewSubjectHasTwoCredits(){
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
        System.out.println("Enter exercise points: ");
        double exercisePoints = Double.parseDouble(RegexHandler.checkNumOfCredits());
        System.out.println("Enter midterm Score: ");
        double midtermScore = Double.parseDouble(RegexHandler.checkNumOfCredits());
        System.out.println("Enter final Grade: ");
        double finalGrade = Double.parseDouble(RegexHandler.checkNumOfCredits());
        SubjectHasTwoCredits subject = new SubjectHasTwoCredits(nameSubject, codeSubject, numOfCredits, dayStart, dayEnd, exercisePoints, midtermScore, finalGrade);
        AdminManagement adminManagement = new AdminManagement();
        adminManagement.addSubject(subject);
        System.out.println("List of subject:");
        for (Student s : adminManagement.getSubjects()) {
            System.out.println(s.toString());
        }

    }
    public static void addNewSubjectHasThreeCredits(){
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
        System.out.println("Enter exercise points: ");
        double exercisePoints = Double.parseDouble(RegexHandler.checkNumOfCredits());
        System.out.println("Enter test Mark: ");
        double testMarks = Double.parseDouble(RegexHandler.checkNumOfCredits());
        System.out.println("Enter midterm Score: ");
        double midtermScore = Double.parseDouble(RegexHandler.checkNumOfCredits());
        System.out.println("Enter final Grade: ");
        double finalGrade = Double.parseDouble(RegexHandler.checkNumOfCredits());
        System.out.println("Enter practice Point: ");
        double practicePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
        SubjectHasThreeCredits subject = new SubjectHasThreeCredits(nameSubject, codeSubject, numOfCredits, dayStart, dayEnd, exercisePoints, testMarks, midtermScore, finalGrade, practicePoint);
        AdminManagement adminManagement = new AdminManagement();
        adminManagement.addSubject(subject);
        System.out.println("List of subject:");
        for (Student s : adminManagement.getSubjects()) {
            System.out.println(s.toString());
        }

    }
    public static void addNewStudent(){
        Scanner input = new Scanner(System.in);
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
        AdminManagement adminManagement = new AdminManagement();
        adminManagement.addStudent(student);
        System.out.println("List of students:");
        for (Student s : adminManagement.getStudents()) {
            System.out.println(s.toString());
        }
    }

    public static void editStudentById(List<Student> students, String studentCodeToEdit, Scanner scanner) {
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
            System.out.println("6. Menu");

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
                case 6:

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
    public static void editPoint(List<Subject> subjects, String codeSubject, Scanner scanner){
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
            System.out.println("6. Menu");

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
                case 6:

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
    }


