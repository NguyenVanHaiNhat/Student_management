package file;

import model.Student;
import model.SubjectHasThreeCredits;
import model.SubjectHasTwoCredits;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvWriterAndRead {
    private static final String FILE_STUDENT_PATH = "E:\\Bootcamp Java Fullstack\\C1023H1-JV101-NguyenVanHaiNhat\\Module_2\\Case_study\\Student_management\\src\\data\\danhsachsinhvien.csv";
    private static final String FILE_SUBJECT_PATH = "E:\\Bootcamp Java Fullstack\\C1023H1-JV101-NguyenVanHaiNhat\\Module_2\\Case_study\\Student_management\\src\\data\\danhsachmonhoc.csv";
    public List<Student> readStudent(){
        List<Student> students = new ArrayList<>();
        List<String> strings = readFromFile(FILE_STUDENT_PATH);

        String[] temp;
        for (String s: strings){
            temp = s.split(",");
            String studentCode = temp[0];
            String firstName = temp[1];
            String lastName = temp[2];
            String gender = temp[3];
            String dayOfBirth = temp[4];
            String phone = temp[5];

            Student student = new Student(studentCode, firstName, lastName, gender, dayOfBirth, phone);
            students.add(student);
        }
        return students;
    }

    public List<SubjectHasThreeCredits> readSubjectHasThreeCredits(){
        List<SubjectHasThreeCredits> subjectHasThreeCredits = new ArrayList<>();
        List<String> strings = readFromFile(FILE_SUBJECT_PATH);

        String[] temp;
        for (String s: strings){
            temp = s.split(",");
            String nameSubject = temp[0];
            String codeSubject = temp[1];
            String numberOfCredits = temp[2];
            String dayStart = temp[3];
            String dayEnd = temp[4];
            double exercisePoints = Double.parseDouble(temp[5]);
            double testMarks = Double.parseDouble(temp[6]);
            double midtermScore = Double.parseDouble(temp[7]);
            double finalGrade = Double.parseDouble(temp[8]);
            double practicePoint = Double.parseDouble(temp[9]);

            SubjectHasThreeCredits subjectHasThreeCredits1 = new SubjectHasThreeCredits(nameSubject, codeSubject, numberOfCredits, dayStart, dayEnd, exercisePoints, testMarks, midtermScore, finalGrade, practicePoint);
            subjectHasThreeCredits.add(subjectHasThreeCredits1);
        }
        return subjectHasThreeCredits;
    }
    public List<SubjectHasTwoCredits> readSubjectHasTwoCredits(){
        List<SubjectHasTwoCredits> subjectHasTwoCredits = new ArrayList<>();
        List<String> strings = readFromFile(FILE_SUBJECT_PATH);

        String[] temp;
        for (String s: strings){
            temp = s.split(",");
            String nameSubject = temp[0];
            String codeSubject = temp[1];
            String numberOfCredits = temp[2];
            String dayStart = temp[3];
            String dayEnd = temp[4];
            double exercisePoints = Double.parseDouble(temp[5]);
            double midtermScore = Double.parseDouble(temp[6]);
            double finalGrade = Double.parseDouble(temp[7]);

            SubjectHasTwoCredits subjectHasTwoCredits1 = new SubjectHasTwoCredits(nameSubject, codeSubject, numberOfCredits, dayStart, dayEnd, exercisePoints, midtermScore, finalGrade);
            subjectHasTwoCredits.add(subjectHasTwoCredits1);
        }
        return subjectHasTwoCredits;
    }

    public void writeStudent(List<Student> students){
        List<String> strings = new ArrayList<>();

        for (Student student: students){
            strings.add(student.covertToLine());
        }
        writeToFile(FILE_STUDENT_PATH, strings);
    }

    public void writeSubjectHasThreeCredits(List<SubjectHasThreeCredits> subjects){
        List<String> strings = new ArrayList<>();

        for (SubjectHasThreeCredits subjectHasThreeCredits: subjects){
            strings.add(subjectHasThreeCredits.covertToLine2());
        }
        writeToFile(FILE_SUBJECT_PATH, strings);
    }
    public void writeSubjectHasTwoCredits(List<SubjectHasTwoCredits> subjects){
        List<String> strings = new ArrayList<>();

        for (SubjectHasTwoCredits subjectHasTwoCredits: subjects){
            strings.add(subjectHasTwoCredits.covertToLine1());
        }
        writeToFile(FILE_SUBJECT_PATH, strings);
    }

    private void writeToFile(String pathFile, List<String> strings) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String s : strings) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<String> readFromFile(String pathFile) {
        List<String> strings = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}