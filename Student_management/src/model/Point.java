package model;

public abstract class Point extends Subject {
    private double exercisePoints;
    private double testMarks;
    private double midtermScore;
    private double finalGrade;
    private double practicePoint;

    public Point(String studentCode, String firstName, String lastName, String gender, String dayOfBirth, String phone, String nameSubject, String codeSubject, String numberOfCredits, String dayStart, String dayEnd, double exercisePoints, double testMarks, double midtermScore, double finalGrade, double practicePoint) {
        super(studentCode, firstName, lastName, gender, dayOfBirth, phone, nameSubject, codeSubject, numberOfCredits, dayStart, dayEnd);
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

    public abstract double getTotalPoint();
    public abstract double getAvgPoint();
}
