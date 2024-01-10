package view;

import file.RegexHandler;
import management.AdminManagement;
import model.Student;
import model.SubjectHasThreeCredits;
import model.SubjectHasTwoCredits;

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
}
