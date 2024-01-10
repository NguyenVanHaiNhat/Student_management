package file;

import java.util.Scanner;

public class RegexHandler {
    private static final String REGEX_STUDENT_CODE = "^ST[0-9]{3}$";
    private static final String REGEX_NAME = "^[A-Z]([a-z]*)(\\s[A-Z]([a-z]*))*$";
    private static final String REGEX_PHONE = "[0-9]{10}$";

    private static final String REGEX_GENDER = "^(nam|nữ)$";
    private static final String REGEX_DATE = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

    private static final String REGEX_SUBJECT_CODE = "^S[0-9]$";
    private static final String REGEX_CREDITS = "^[0-9]$";


    private static final Scanner scanner = new Scanner(System.in);

    public static String checkRegexStudentCode() {
        String value = scanner.nextLine();
        while (!String.valueOf(value).matches(REGEX_STUDENT_CODE)) {
            System.out.print("Enter again: ");
            value = scanner.nextLine();
        }
        return value;
    }
    public static String checkRegexSubjectCode() {
        String value = scanner.nextLine();
        while (!String.valueOf(value).matches(REGEX_SUBJECT_CODE)) {
            System.out.print("Enter again: ");
            value = scanner.nextLine();
        }
        return value;
    }

    public static String checkRegexName() {
        String value = scanner.nextLine();
        while (!String.valueOf(value).matches(REGEX_NAME)) {
            System.out.println("Enter again: ");
            value = scanner.nextLine();
        }
        return value;
    }

    public static String checkRegexDate() {
        String value = scanner.nextLine();
        while (!String.valueOf(value).matches(REGEX_DATE)) {
            System.out.println("Enter again: ");
            value = scanner.nextLine();
        }
        return value;
    }

    public static String checkPhoneNumber() {
        String value = scanner.nextLine();
        while (!String.valueOf(value).matches(REGEX_PHONE)) {
            System.out.println("Enter again: ");
            value = scanner.nextLine();
        }
        return value;
    }
    public static String checkGender() {
        String value = scanner.nextLine();
        while (!String.valueOf(value).matches(REGEX_GENDER)) {
            System.out.println("Enter again: ");
            value = scanner.nextLine();
        }
        return value;
    }
    public static String checkNumOfCredits() {
        String value = scanner.nextLine();
        while (!String.valueOf(value).matches(REGEX_CREDITS)) {
            System.out.println("Enter again: ");
            value = scanner.nextLine();
        }
        return value;
    }



}
