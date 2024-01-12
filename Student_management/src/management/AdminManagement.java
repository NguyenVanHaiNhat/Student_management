package management;

import model.*;

import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class AdminManagement implements Serializable {
    List<Student> students = new ArrayList<>();
    List<Point1> point1s = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }
    public void addPoint(Point1 point) {
        point1s.add(point);
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

        public void editSubjectPointsByStudentCode(String studentCode, String subject, double newExercisePoints, double newTestMarks, double newPracticePoint, double newMidtermScore, double newFinalGrade) {
            for (Point1 point : point1s) {
                if (point.getStudentCode().equals(studentCode)) {
                    switch (subject) {
                        case "Maths":
                            point.setAvgMaths(calculateNewAvgPoint(point.getAvgMaths(), newExercisePoints, newTestMarks, newPracticePoint, newMidtermScore, newFinalGrade));
                            break;
                        case "Physical":
                            point.setAvgPhysical(calculateNewAvgPoint(point.getAvgPhysical(), newExercisePoints, newTestMarks, newPracticePoint, newMidtermScore, newFinalGrade));
                            break;
                        case "Chemistry":
                            point.setAvgChemistry(calculateNewAvgPoint(point.getAvgChemistry(), newExercisePoints, newTestMarks, newPracticePoint, newMidtermScore, newFinalGrade));
                            break;
                        default:
                            System.out.println("Invalid subject");
                            return;
                    }
                    System.out.println(subject + " points updated successfully for student with code " + studentCode);
                    return;
                }
            }
            System.out.println("Student with code " + studentCode + " not found.");
        }

        private double calculateNewAvgPoint(double currentAvg, double newExercisePoints, double newTestMarks, double newPracticePoint, double newMidtermScore, double newFinalGrade) {
            return (currentAvg + newExercisePoints + newTestMarks + newPracticePoint + newMidtermScore * 2 + newFinalGrade * 3) / 8;
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
    public List<Point1> getPoint1s(){
        return point1s;
    }
}



