package com.veda;

import java.util.ArrayList;
import java.util.List;

public class TrainingProgram {
    private int trainingId;
    private String programName;
    private String instructor;
    private int capacity;
    private double fee;
    private String status; // Scheduled, Ongoing, Completed
    private List<String> enrolledStudents;

    public TrainingProgram(int trainingId, String programName, String instructor, int capacity, double fee, String status) {
        this.trainingId = trainingId;
        this.programName = programName;
        this.instructor = instructor;
        this.capacity = capacity;
        this.fee = fee;
        this.status = status;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getTrainingId() {
        return trainingId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean enrollStudent(String studentName) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(studentName);
            return true;
        }
        return false;
    }

    public int getAvailableSeats() {
        return Math.max(0, capacity - enrolledStudents.size());
    }

    @Override
    public String toString() {
        return String.format("[%d] %-32s | Instructor: %-16s | Fee: $%-6.2f | Enrolled: %d/%d (%s)",
                trainingId, programName, instructor, fee, enrolledStudents.size(), capacity, status);
    }
}

