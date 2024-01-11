package model;

public abstract class Point extends Student {
    private double exercisePoints;
    private double testMarks;
    private double midtermScore;
    private double finalGrade;
    private double practicePoint;

    public Point(double exercisePoints, double testMarks, double midtermScore, double finalGrade, double practicePoint) {
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
