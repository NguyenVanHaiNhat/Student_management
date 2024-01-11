package management;

import model.Chemistry;
import model.Maths;
import model.Physical;
import model.Student;

import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class AdminManagement implements Serializable {
    List<Student> students = new ArrayList<>();
    List<Maths> maths = new ArrayList<>();
    List<Physical> physicals = new ArrayList<>();
    List<Chemistry> chemistries = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }
    public void addMaths(Maths math){
        maths.add(math);
    }
    public void addPhysicals(Physical physical){
        physicals.add(physical);
    }
    public void addChemistres(Chemistry chemistry){
        chemistries.add(chemistry);
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


    private Student findStudentByCode(String studentCode) {
        for (Student student : students) {
            if (student.getStudentCode().equals(studentCode)) {
                return student;
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

    public List<Object> getAllEntities() {
        List<Object> allEntities = new ArrayList<>();
        allEntities.addAll(students);
        allEntities.addAll(maths);
        allEntities.addAll(physicals);
        allEntities.addAll(chemistries);
        return allEntities;
    }

}



