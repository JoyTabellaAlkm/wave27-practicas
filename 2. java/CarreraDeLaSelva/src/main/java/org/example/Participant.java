package org.example;

public class Participant {

    private int participantId;
    private int identificationNumber;
    private String name;
    private String lastName;
    private int age;
    private long cellNumber;
    private long emergencyNumber;
    private String bloodType;

    public Participant(int participantId, int identificationNumber, String name, String lastName, int age, long cellNumber, long emergencyNumber, String bloodType) {
        this.participantId = participantId;
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.cellNumber = cellNumber;
        this.emergencyNumber = emergencyNumber;
        this.bloodType = bloodType;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(long cellNumber) {
        this.cellNumber = cellNumber;
    }

    public long getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(long emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
