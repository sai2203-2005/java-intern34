package com.veda;

public class InternshipApplication {
    private int applicationId;
    private String applicantName;
    private String college;
    private String email;
    private String track;
    private String status; // Applied, Under Review, Interviewed, Accepted, Rejected

    public InternshipApplication(int applicationId, String applicantName, String college, String email, String track, String status) {
        this.applicationId = applicationId;
        this.applicantName = applicantName;
        this.college = college;
        this.email = email;
        this.track = track;
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("[%d] %-20s | Track: %-18s | College: %-22s | Status: %s",
                applicationId, applicantName, track, college, status);
    }
}
