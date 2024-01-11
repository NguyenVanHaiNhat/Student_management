package model;

public class Maths extends Point{
    public Maths(String studentCode, String firstName, String lastName, String gender, String dayOfBirth, String phone, String nameSubject, String codeSubject, String numberOfCredits, String dayStart, String dayEnd, double exercisePoints, double testMarks, double midtermScore, double finalGrade, double practicePoint) {
        super(studentCode, firstName, lastName, gender, dayOfBirth, phone, nameSubject, codeSubject, numberOfCredits, dayStart, dayEnd, exercisePoints, testMarks, midtermScore, finalGrade, practicePoint);
    }

    @Override
    public double getTotalPoint() {
        return getExercisePoints() +getTestMarks() + getPracticePoint() + getMidtermScore() + getFinalGrade();
    }

    @Override
    public double getAvgPoint() {
        return (getExercisePoints() +getTestMarks() + getPracticePoint() + getMidtermScore()*2 + getFinalGrade()*3)/8;
    }
}
