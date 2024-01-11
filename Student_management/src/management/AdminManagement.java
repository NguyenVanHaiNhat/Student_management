package management;

import model.Student;
import model.Subject;
import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class AdminManagement implements Serializable {
    List<Student> students = new ArrayList<>();
    List<Subject> subjects = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void deleteStudentByCode(String studentCode) {
        Student studentToDelete = findStudentByCode(studentCode);
        if (studentToDelete != null) {
            students.remove(studentToDelete);
            System.out.println("Student with code " + studentCode + " deleted successfully.");
        } else {
            System.out.println("Student with code " + studentCode + " not found.");
        }
    }

    public void deleteSubjectByCode(String subjectCode) {
        Subject subjectToDelete = findSubjectByCode(subjectCode);
        if (subjectToDelete != null) {
            subjects.remove(subjectToDelete);
            System.out.println("Subject with code " + subjectCode + " deleted successfully.");
        } else {
            System.out.println("Subject with code " + subjectCode + " not found.");
        }
    }

    private Student findStudentByCode(String studentCode) {
        for (Student student : students) {
            if (student.getStudentCode().equals(studentCode)) {
                return student;
            }
        }
        return null;
    }

    private Subject findSubjectByCode(String subjectCode) {
        for (Subject subject : subjects) {
            if (subject.getCodeSubject().equals(subjectCode)) {
                return subject;
            }
        }
        return null;
    }
    public void sortStudentsByNameVietnamese() {
        Comparator<Student> vietnameseComparator = Comparator
                .comparing(Student::getFirstName, Collator.getInstance(java.util.Locale.forLanguageTag("vi-VN")));
        students.sort(vietnameseComparator);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
    public List<Object> getAllEntities() {
        List<Object> allEntities = new ArrayList<>();
        allEntities.addAll(students);
        allEntities.addAll(subjects);
        return allEntities;
    }

}



