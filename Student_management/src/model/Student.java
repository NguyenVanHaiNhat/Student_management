package model;
public class Student implements Comparable<Student> {
    private String studentCode;
    private String firstName;
    private String lastName;
    private String gender;
    private String dayOfBirth;
    private String phone;

    public Student(){

    }

    public Student(String studentCode, String firstName, String lastName, String gender, String dayOfBirth, String phone) {
        this.studentCode = studentCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.phone = phone;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String covertToLine(){
        return this.studentCode + ", " + this.firstName + ", " + this.lastName + ", " + this.gender + ", " + this.dayOfBirth + ", " + this.phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode='" + studentCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student otherStudent) {
        return this.getFirstName().compareTo(otherStudent.getFirstName());
    }
}
