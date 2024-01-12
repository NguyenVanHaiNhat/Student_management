package model;

public class Physical extends Point{
    private String id;
    public Physical(String id,double exercisePoints, double testMarks, double midtermScore, double finalGrade, double practicePoint) {
        super(exercisePoints, testMarks, midtermScore, finalGrade, practicePoint);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
