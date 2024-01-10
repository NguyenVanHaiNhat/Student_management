package view;

import file.RegexHandler;
import management.AdminManagement;
import model.Student;

import java.util.Scanner;

public class ManagementView {
    public static void addNewSubject(){}
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
}
