//package management;
//
//import model.Student;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CsvWriter {
//    private static final String COMMA_DELIMITER = ", ";
//    private static final String NEW_LINE_SEPARATOR = "\n";
//
//    private static final String FILE_HEADER = "id,code,name";
//
//    public static void main(String[] args) {
//
//        String fileName = "E:\\Bootcamp Java Fullstack\\C1023H1-JV101-NguyenVanHaiNhat\\Module_2\\Case_study\\Student_management\\src\\data\\danhsachtaikhoan.csv";
//        writeCsvFile(fileName);
//    }
//
//    public static void writeCsvFile(String fileName) {
//        Student student1 = new Student(1, "Nam", "Nguyễn Văn Hải Nhật");
//        Student student2 = new Student(2, "Nữ", "Nguyễn Thị Cẩm Nhung");
//        Student student3 = new Student(3, "Nam", "Lương Văn Đạt");
//
//        List<Student> students = new ArrayList<>();
//        students.add(student1);
//        students.add(student2);
//        students.add(student3);
//
//        FileWriter fileWriter = null;
//
//        try {
//            fileWriter = new FileWriter(fileName);
//
//            fileWriter.append(FILE_HEADER);
//
//            fileWriter.append(NEW_LINE_SEPARATOR);
//
//            for (Student student : students) {
//                fileWriter.append(String.valueOf(student.getId()));
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(student.getCode());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(student.getName());
//                fileWriter.append(NEW_LINE_SEPARATOR);
//            }
//
//            System.out.println("Done");
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        } finally {
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//                e.printStackTrace();
//            }
//        }
//    }
//}