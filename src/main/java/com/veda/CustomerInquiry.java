package com.veda;

public class CustomerInquiry {
    private int inquiryId;
    private String customerName;
    private String email;
    private String phone;
    private String serviceInterested;
    private String status; // New, In Review, Contacted, Converted, Closed

    public CustomerInquiry(int inquiryId, String customerName, String email, String phone, String serviceInterested, String status) {
        this.inquiryId = inquiryId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.serviceInterested = serviceInterested;
        this.status = status;
    }

    public int getInquiryId() {
        return inquiryId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getServiceInterested() {
        return serviceInterested;
    }

    public void setServiceInterested(String serviceInterested) {
        this.serviceInterested = serviceInterested;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("[%d] %-20s | Service: %-25s | Status: %-12s\n    Contact: %s | %s",
                inquiryId, customerName, serviceInterested, status, email, phone);
    }
}

