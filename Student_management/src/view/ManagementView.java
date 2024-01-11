package view;

import file.CsvWriterAndRead;
import file.RegexHandler;
import management.AdminManagement;
import model.Chemistry;
import model.Maths;
import model.Physical;
import model.Student;

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
            List<Object> objects = adminManagement.getAllEntities();
            System.out.println("Admin Management");
            System.out.println("1. add new student");
            System.out.println("2. add new subject");
            System.out.println("3. display student");
            System.out.println("4. display all");
            System.out.println("5. edit student");
            System.out.println("6. edit subject point");
            System.out.println("7. delete student");
            System.out.println("8. write to file");
            System.out.println("9. read to file");
            System.out.println("10. sort student name");
            System.out.println("11 display all");
            System.out.println("12. Back Main Menu");
            System.out.print("your choice: ");
            int choice = scanner.nextByte();

            scanner.nextLine();
            switch (choice){
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addPoint();
                    break;
                case 3:
                    displayStudentList();
                    break;
                case 4:
                    displayAllEntities(adminManagement.getAllEntities());
                    break;
                case 5:
                    editStudentById(students);
                    break;
                case 6:
                    editPoint(objects, students);
                    break;
                case 7:
                    System.out.println("Enter studentCode want to delete: ");
                    String codeStudent = RegexHandler.checkRegexStudentCode();
                    adminManagement.deleteStudentByCode(codeStudent);
                    break;
                case 8:
                    csv.writeStudent(students);
                    break;
                case 9:
                    csv.readStudent();
                    break;
                case 10:
                    adminManagement.sortStudentsByNameVietnamese();
                    displayStudentList();
                    break;
                case 11:
                    adminManagement.getAllEntities();
                    break;
                case 12:
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
            System.out.println("Student Menu");
            System.out.println("1. display student list");
            System.out.println("2. display all list");
            System.out.println("3. find student");
            System.out.println("4. Back Main Menu");
            int choice = scanner.nextByte();
            switch (choice){
                case 1:
                    displayStudentList();
                    break;
                case 2:
                    displayAllEntities(adminManagement.getAllEntities());
                    break;
                case 3:
                    findStudentById(students);
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
            System.out.println("Information found: ");
            System.out.println(students.get(index));
        }
    }
    public static void addPoint() {
        System.out.println("Enter student code to add points: ");
        String studentCode = scanner.nextLine().trim();

        int indexOfStudent = findStudentIndex(adminManagement.getStudents(), studentCode);

        if (indexOfStudent != -1) {
            System.out.println("1. Maths");
            System.out.println("2. Physical");
            System.out.println("3. Chemistry");
            int choice = scanner.nextByte();
            switch (choice) {
                case 1:
                    addMathsPointsForStudent(adminManagement.getAllEntities(), adminManagement.getStudents().get(indexOfStudent));
                    break;
                case 2:
                    addPhysicalPointsForStudent(adminManagement.getAllEntities(), adminManagement.getStudents().get(indexOfStudent));
                    break;
                case 3:
                    addChemistryPointsForStudent(adminManagement.getAllEntities(), adminManagement.getStudents().get(indexOfStudent));
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } else {
            System.out.println("Student not found with code: " + studentCode);
        }
    }

    private static void addMathsPointsForStudent(List<Object> objects, Student student) {
        Maths maths = findMathsObject(objects, student.getStudentCode());

        if (maths != null) {
            System.out.println("Select the point to add:");
            System.out.println("1. exercise points");
            System.out.println("2. test marks");
            System.out.println("3. practice Point");
            System.out.println("4. midterm Score");
            System.out.println("5. final Grade");
            int mathschoice = scanner.nextInt();
            switch (mathschoice) {
                case 1:
                    System.out.println("Enter exercise points: ");
                    double newExercisePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    maths.setExercisePoints(newExercisePoint);
                    break;
                case 2:
                    System.out.println("Enter test marks: ");
                    double newTestMarks = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    maths.setTestMarks(newTestMarks);
                    break;
                case 3:
                    System.out.println("Enter practice Point: ");
                    double newPracticePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    maths.setPracticePoint(newPracticePoint);
                    break;
                case 4:
                    System.out.println("Enter midterm Score: ");
                    double newMidTermScore = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    maths.setMidtermScore(newMidTermScore);
                    break;
                case 5:
                    System.out.println("Enter final Grade: ");
                    double newFinalGrade = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    maths.setFinalGrade(newFinalGrade);
                    break;
                default:
                    System.out.println("choice again");
                    break;
            }

            System.out.println("Maths points updated successfully.");
        } else {
            System.out.println("Invalid operation. Student has not registered for Maths.");
        }
    }

    private static void addPhysicalPointsForStudent(List<Object> objects, Student student) {
        Physical physical = findPhysicalObject(objects, student.getStudentCode());

        if (physical != null) {
            System.out.println("Select points to add: ");
            System.out.println("1. exercise points");
            System.out.println("2. test marks");
            System.out.println("3. practice Point");
            System.out.println("4. midterm Score");
            System.out.println("5. final Grade");
            int physicalchoice = scanner.nextInt();
            switch (physicalchoice) {
                case 1:
                    System.out.println("Enter exercise points: ");
                    double newExercisePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    physical.setExercisePoints(newExercisePoint);
                    break;
                case 2:
                    System.out.println("Enter test marks: ");
                    double newTestMarks = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    physical.setTestMarks(newTestMarks);
                    break;
                case 3:
                    System.out.println("Enter practice Point: ");
                    double newPracticePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    physical.setPracticePoint(newPracticePoint);
                    break;
                case 4:
                    System.out.println("Enter midterm Score: ");
                    double newMidTermScore = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    physical.setMidtermScore(newMidTermScore);
                    break;
                case 5:
                    System.out.println("Enter final Grade: ");
                    double newFinalGrade = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    physical.setFinalGrade(newFinalGrade);
                    break;
                default:
                    System.out.println("choice again");
                    break;
            }

            System.out.println("Physical points updated successfully.");
        } else {
            System.out.println("Invalid operation. Student has not registered for Physical.");
        }
    }

    private static void addChemistryPointsForStudent(List<Object> objects, Student student) {
        Chemistry chemistry = findChemistryObject(objects, student.getStudentCode());

        if (chemistry != null) {
            System.out.println("Select points to add: ");
            System.out.println("1. exercise points");
            System.out.println("2. test marks");
            System.out.println("3. practice Point");
            System.out.println("4. midterm Score");
            System.out.println("5. final Grade");
            int chemistychoice = scanner.nextInt();
            switch (chemistychoice) {
                case 1:
                    System.out.println("Enter exercise points: ");
                    double newExercisePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    chemistry.setExercisePoints(newExercisePoint);
                    break;
                case 2:
                    System.out.println("Enter test marks: ");
                    double newTestMarks = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    chemistry.setTestMarks(newTestMarks);
                    break;
                case 3:
                    System.out.println("Enter practice Point: ");
                    double newPracticePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    chemistry.setPracticePoint(newPracticePoint);
                    break;
                case 4:
                    System.out.println("Enter midterm Score: ");
                    double newMidTermScore = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    chemistry.setMidtermScore(newMidTermScore);
                    break;
                case 5:
                    System.out.println("Enter final Grade: ");
                    double newFinalGrade = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    chemistry.setFinalGrade(newFinalGrade);
                    break;
                default:
                    System.out.println("choice again");
                    break;
            }

            System.out.println("Chemistry points updated successfully.");
        } else {
            System.out.println("Invalid operation. Student has not registered for Chemistry.");
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
    private static void editPoint(List<Object> objects, List<Student> students) {
        System.out.println("Enter student code to edit points:");
        String studentCodeToEdit = scanner.nextLine().trim();
        int indexOfStudentToEdit = findStudentIndex(students, studentCodeToEdit);

        if (indexOfStudentToEdit != -1) {
            System.out.println("Information before editing: ");
            System.out.println(objects.get(indexOfStudentToEdit));
            System.out.println("Choose a subject to edit points:");
            System.out.println("1. Maths");
            System.out.println("2. Physical");
            System.out.println("3. Chemistry");
            int subjectChoice = scanner.nextInt();

            switch (subjectChoice) {
                case 1:
                    editMathsPoints(objects, students.get(indexOfStudentToEdit));
                    break;
                case 2:
                    editPhysicalPoints(objects, students.get(indexOfStudentToEdit));
                    break;
                case 3:
                    editChemistryPoints(objects, students.get(indexOfStudentToEdit));
                    break;
                default:
                    System.out.println("Invalid choice. No points edited.");
                    break;
            }
        } else {
            System.out.println("Student not found with code: " + studentCodeToEdit);
        }
    }

    private static void editMathsPoints(List<Object> objects, Student student) {
        Maths maths = findMathsObject(objects, student.getStudentCode());

        if (maths != null) {
            System.out.println("Select the point to correct: ");
            System.out.println("1. exercise points");
            System.out.println("2. test marks");
            System.out.println("3. practice Point");
            System.out.println("4. midterm Score");
            System.out.println("5. final Grade");
            int mathschoice = scanner.nextInt();
            switch (mathschoice){
                case 1:
                    System.out.println("Enter exercise points: ");
                    double newExercisePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    maths.setExercisePoints(newExercisePoint);
                    break;
                case 2:
                    System.out.println("Enter test marks: ");
                    double newTestMarks = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    maths.setTestMarks(newTestMarks);
                    break;
                case 3:
                    System.out.println("Enter practice Point: ");
                    double newPracticePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    maths.setPracticePoint(newPracticePoint);
                    break;
                case 4:
                    System.out.println("Enter midterm Score: ");
                    double newMidTermScore = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    maths.setMidtermScore(newMidTermScore);
                    break;
                case 5:
                    System.out.println("Enter final Grade: ");
                    double newFinalGrade = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    maths.setFinalGrade(newFinalGrade);
                    break;
                default:
                    System.out.println("choice again");
                    break;
            }

            System.out.println("Maths points updated successfully.");
        } else {
            System.out.println("Invalid operation. Student has not registered for Maths.");
        }
    }

    private static void editPhysicalPoints(List<Object> objects, Student student) {
        Physical physical = findPhysicalObject(objects, student.getStudentCode());

        if (physical != null) {
            System.out.println("Select the point to correct: ");
            System.out.println("1. exercise points");
            System.out.println("2. test marks");
            System.out.println("3. practice Point");
            System.out.println("4. midterm Score");
            System.out.println("5. final Grade");
            int physicalchoice = scanner.nextInt();
            switch (physicalchoice){
                case 1:
                    System.out.println("Enter exercise points: ");
                    double newExercisePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    physical.setExercisePoints(newExercisePoint);
                    break;
                case 2:
                    System.out.println("Enter test marks: ");
                    double newTestMarks = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    physical.setTestMarks(newTestMarks);
                    break;
                case 3:
                    System.out.println("Enter practice Point: ");
                    double newPracticePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    physical.setPracticePoint(newPracticePoint);
                    break;
                case 4:
                    System.out.println("Enter midterm Score: ");
                    double newMidTermScore = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    physical.setMidtermScore(newMidTermScore);
                    break;
                case 5:
                    System.out.println("Enter final Grade: ");
                    double newFinalGrade = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    physical.setFinalGrade(newFinalGrade);
                    break;
                default:
                    System.out.println("choice again");
                    break;
            }

            System.out.println("Physical points updated successfully.");
        } else {
            System.out.println("Invalid operation. Student has not registered for Physical.");
        }
    }

    private static void editChemistryPoints(List<Object> objects, Student student) {
        Chemistry chemistry = findChemistryObject(objects, student.getStudentCode());

        if (chemistry != null) {
            System.out.println("Select the point to correct: ");
            System.out.println("1. exercise points");
            System.out.println("2. test marks");
            System.out.println("3. practice Point");
            System.out.println("4. midterm Score");
            System.out.println("5. final Grade");
            int chemistychoice = scanner.nextInt();
            switch (chemistychoice){
                case 1:
                    System.out.println("Enter exercise points: ");
                    double newExercisePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    chemistry.setExercisePoints(newExercisePoint);
                    break;
                case 2:
                    System.out.println("Enter test marks: ");
                    double newTestMarks = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    chemistry.setTestMarks(newTestMarks);
                    break;
                case 3:
                    System.out.println("Enter practice Point: ");
                    double newPracticePoint = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    chemistry.setPracticePoint(newPracticePoint);
                    break;
                case 4:
                    System.out.println("Enter midterm Score: ");
                    double newMidTermScore = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    chemistry.setMidtermScore(newMidTermScore);
                    break;
                case 5:
                    System.out.println("Enter final Grade: ");
                    double newFinalGrade = Double.parseDouble(RegexHandler.checkNumOfCredits());
                    chemistry.setFinalGrade(newFinalGrade);
                    break;
                default:
                    System.out.println("choice again");
                    break;
            }

            System.out.println("Chemistry points updated successfully.");
        } else {
            System.out.println("Invalid operation. Student has not registered for Chemistry.");
        }
    }

    private static int findStudentIndex(List<Student> students, String studentCode) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentCode().equals(studentCode)) {
                return i;
            }
        }
        return -1;
    }

    private static Maths findMathsObject(List<Object> objects, String studentCode) {
        for (Object obj : objects) {
            if (obj instanceof Maths && ((Maths) obj).getStudentCode().equals(studentCode)) {
                return (Maths) obj;
            }
        }
        return null;
    }

    private static Physical findPhysicalObject(List<Object> objects, String studentCode) {
        for (Object obj : objects) {
            if (obj instanceof Physical && ((Physical) obj).getStudentCode().equals(studentCode)) {
                return (Physical) obj;
            }
        }
        return null;
    }

    private static Chemistry findChemistryObject(List<Object> objects, String studentCode) {
        for (Object obj : objects) {
            if (obj instanceof Chemistry && ((Chemistry) obj).getStudentCode().equals(studentCode)) {
                return (Chemistry) obj;
            }
        }
        return null;
    }


    public static void displayStudentList() {
        List<Student> students = adminManagement.getStudents();
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    private static void displayAllEntities(List<Object> allEntities) {
        System.out.println("List of All Entities:");
        for (Object entity : allEntities) {
            System.out.println(entity);
        }
    }
}


