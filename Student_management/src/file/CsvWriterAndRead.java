package file;

import model.Point1;
import model.Student;

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
    public void writeStudent(List<Student> students){
        List<String> strings = new ArrayList<>();

        for (Student student: students){
            strings.add(student.covertToLine());
        }
        writeToFile(FILE_STUDENT_PATH, strings);
    }
    public List<Point1> readAll(){
        List<Point1> point1s = new ArrayList<>();
        List<String> strings = readFromFile(FILE_SUBJECT_PATH);

        String[] temp;
        for (String s: strings){
            temp = s.split(",");
            String studentCode = temp[0];
            String firstName = temp[1];
            String lastName = temp[2];
            String gender = temp[3];
            String dayOfBirth = temp[4];
            String phone = temp[5];
            double avgMaths = Double.parseDouble(temp[6]);
            double avgPhysical = Double.parseDouble(temp[7]);
            double avgChemistry = Double.parseDouble(temp[8]);


            Point1 point1 = new Point1(studentCode, firstName, lastName, gender, dayOfBirth, phone, avgMaths, avgPhysical, avgChemistry);
            point1s.add(point1);
        }
        return point1s;
    }
    public void writeAll(List<Point1> point1s){
        List<String> strings = new ArrayList<>();

        for (Point1 point1: point1s){
            strings.add(point1.covertToLine1());
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