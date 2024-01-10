package model;

import java.time.LocalDate;

public class Subject extends Student {
    private String nameSubject;
    private String codeSubject;
    private String numberOfCredits;
    private LocalDate dayStart;
    private LocalDate dayEnd;

    public Subject(String nameSubject, String codeSubject, String numberOfCredits, LocalDate dayStart, LocalDate dayEnd) {
        this.nameSubject = nameSubject;
        this.codeSubject = codeSubject;
        this.numberOfCredits = numberOfCredits;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
    }

    public Subject(String studentCode, String firstName, String lastName, String gender, String dayOfBirth, String phone, String nameSubject, String codeSubject, String numberOfCredits, LocalDate dayStart, LocalDate dayEnd) {
        super(studentCode, firstName, lastName, gender, dayOfBirth, phone);
        this.nameSubject = nameSubject;
        this.codeSubject = codeSubject;
        this.numberOfCredits = numberOfCredits;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getCodeSubject() {
        return codeSubject;
    }

    public void setCodeSubject(String codeSubject) {
        this.codeSubject = codeSubject;
    }

    public String getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(String numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public LocalDate getDayStart() {
        return dayStart;
    }

    public void setDayStart(LocalDate dayStart) {
        this.dayStart = dayStart;
    }

    public LocalDate getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(LocalDate dayEnd) {
        this.dayEnd = dayEnd;
    }
}
