package model;

import java.time.LocalDate;

public class SubjectHasTwoCredits extends Subject implements PointCaculate {
    private double exercisePoints;
    private double midtermScore;
    private double finalGrade;

    public SubjectHasTwoCredits(String nameSubject, String codeSubject, String numberOfCredits, String dayStart, String dayEnd, double exercisePoints, double midtermScore, double finalGrade) {
        super(nameSubject, codeSubject, numberOfCredits, dayStart, dayEnd);
        this.exercisePoints = exercisePoints;
        this.midtermScore = midtermScore;
        this.finalGrade = finalGrade;
    }

    public double getExercisePoints() {
        return exercisePoints;
    }

    public void setExercisePoints(double exercisePoints) {
        this.exercisePoints = exercisePoints;
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

    @Override
    public String toString() {
        return "SubjectHasTwoCredits{" +
                "nameSubject=" + getNameSubject() +
                "codeSubject=" + getCodeSubject() +
                "exercisePoints=" + exercisePoints +
                ", midtermScore=" + midtermScore +
                ", finalGrade=" + finalGrade +
                '}';
    }

    @Override
    public double getDiemTong() {
        return exercisePoints + midtermScore + finalGrade;
    }

    @Override
    public double getDiemTrungBinh() {
        return (exercisePoints + midtermScore * 2 + finalGrade * 3) / 6;
    }

    public String covertToLine1() {
        return super.getNameSubject() + ", " + super.getCodeSubject() + ", " + super.getNumberOfCredits() + ", " + super.getDayStart() + ", " + super.getDayEnd() + this.exercisePoints + ", " + this.midtermScore + ", " + this.finalGrade;
    }
}
