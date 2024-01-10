package management;

import model.Student;
import model.Subject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdminManagement implements Serializable {
    List<Student> students;
    List<Subject> subjects;
    public AdminManagement() {
        this.students = new ArrayList<>();
        this.subjects = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public void deleteStudent(Student student){
        students.remove(student);
    }
    public void deleteSubject(Subject subject){
        subjects.remove(subject);
    }
    public List<Student> getStudents() {
        return students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
