package management;

import model.Student;
import model.Subject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdminManagement implements Serializable {
    List<Student> students;
    List<Subject> subjects;

    public AdminManagement() {
        this.students = new ArrayList<>();
        this.subjects = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public void deleteSubject(Subject subject) {
        subjects.remove(subject);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }


    public void editStudentById(List<Student> studentList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id cần sửa: ");
        String studentCodeToEdit = scanner.nextLine();
        int indexOfStudentToEdit = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentCode().equals(studentCodeToEdit)) {
                indexOfStudentToEdit = i;
                break;
            }
        }

        if (indexOfStudentToEdit != -1) {
            System.out.println("Thông tin trước khi sửa:");
            System.out.println(studentList.get(indexOfStudentToEdit));

            System.out.print("Nhập tên mới: ");
            String newFirstName = scanner.nextLine();

            Student studentToEdit = studentList.get(indexOfStudentToEdit);
            studentToEdit.setFirstName(newFirstName);

            System.out.println("Thông tin sau khi sửa:");
            System.out.println(studentToEdit);
        } else {
            System.out.println("Không tìm thấy sinh viên có ID: " + studentCodeToEdit);
        }
    }
}



