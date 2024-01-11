package model;

public class Physical extends Point{
    public Physical(double exercisePoints, double testMarks, double midtermScore, double finalGrade, double practicePoint) {
        super(exercisePoints, testMarks, midtermScore, finalGrade, practicePoint);
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
