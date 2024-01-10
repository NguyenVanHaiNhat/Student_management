package model;

import java.time.LocalDate;

public class SubjectHasThreeCredits extends Subject implements PointCaculate {
    private double exercisePoints;
    private double testMarks;
    private double midtermScore;
    private double finalGrade;
    private double practicePoint;

    public SubjectHasThreeCredits(String nameSubject, String codeSubject, String numberOfCredits, String dayStart, String dayEnd, double exercisePoints, double testMarks, double midtermScore, double finalGrade, double practicePoint) {
        super(nameSubject, codeSubject, numberOfCredits, dayStart, dayEnd);
        this.exercisePoints = exercisePoints;
        this.testMarks = testMarks;
        this.midtermScore = midtermScore;
        this.finalGrade = finalGrade;
        this.practicePoint = practicePoint;
    }

    public double getExercisePoints() {
        return exercisePoints;
    }

    public void setExercisePoints(double exercisePoints) {
        this.exercisePoints = exercisePoints;
    }

    public double getTestMarks() {
        return testMarks;
    }

    public void setTestMarks(double testMarks) {
        this.testMarks = testMarks;
    }

    public double getMidtermScore() {
        return midtermScore;
    }

    public void setMidtermScore(double midtermScore) {
        this.midtermScore = midtermScore;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public double getPracticePoint() {
        return practicePoint;
    }

    public void setPracticePoint(double practicePoint) {
        this.practicePoint = practicePoint;
    }

    @Override
    public double getDiemTong() {
        return exercisePoints + testMarks + midtermScore + finalGrade + practicePoint;
    }

    @Override
    public double getDiemTrungBinh() {
        return (exercisePoints + testMarks + midtermScore * 2 + finalGrade * 3 + practicePoint) / 8 ;
    }

    public String covertToLine2() {
        return super.getNameSubject() + ", " + super.getCodeSubject() + ", " + super.getNumberOfCredits() + ", " + super.getDayStart() + ", " + super.getDayEnd() + ", " + this.exercisePoints + ", " + this.testMarks + ", " + this.midtermScore + ", " + this.finalGrade + ", " + this.practicePoint;
    }
}
