package model;


public class Point1 extends Student implements CheckRanking{
    private double avgMaths;
    private double avgPhysical;
    private double avgChemistry;

    public Point1(String studentCode, String firstName, String lastName, String gender, String dayOfBirth, String phone, double avgMaths, double avgPhysical, double avgChemistry) {
        super(studentCode, firstName, lastName, gender, dayOfBirth, phone);
        this.avgMaths = avgMaths;
        this.avgPhysical = avgPhysical;
        this.avgChemistry = avgChemistry;
    }

    public double getAvgMaths() {
        return avgMaths;
    }

    public void setAvgMaths(double avgMaths) {
        this.avgMaths = avgMaths;
    }

    public double getAvgPhysical() {
        return avgPhysical;
    }

    public void setAvgPhysical(double avgPhysical) {
        this.avgPhysical = avgPhysical;
    }

    public double getAvgChemistry() {
        return avgChemistry;
    }

    public void setAvgChemistry(double avgChemistry) {
        this.avgChemistry = avgChemistry;
    }
    @Override
    public double getAvgAllSubject() {
        return (getAvgChemistry() + getAvgMaths() + getAvgPhysical())/3;
    }

    @Override
    public String ranking() {
        if (getAvgAllSubject() > 9){
            return "excellent";
        } else if (getAvgAllSubject() > 7){
            return "academic pretty";
        } else if (getAvgAllSubject() > 5){
            return "medium";
        } else if (getAvgAllSubject() > 3){
            return "weak";
        } else if (getAvgAllSubject() < 3){
            return "fail the subject";
        }
        return "hack";
    }

    @Override
    public String toString() {
        return "Point1{" +
                "codeStudent=" + getStudentCode() +
                ", firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", avgMaths=" + avgMaths +
                ", avgPhysical=" + avgPhysical +
                ", avgChemistry=" + avgChemistry +
                ", avg=" + getAvgAllSubject() +
                ", rank=" + ranking() +
                '}';
    }
}
