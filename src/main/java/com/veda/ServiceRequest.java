package com.veda;

public class ServiceRequest {
    private int requestId;
    private String clientName;
    private String category;
    private String title;
    private String priority; // High, Medium, Low
    private String assignedEngineer;
    private String status; // Open, In Progress, Resolved, Closed

    public ServiceRequest(int requestId, String clientName, String category, String title, String priority, String assignedEngineer, String status) {
        this.requestId = requestId;
        this.clientName = clientName;
        this.category = category;
        this.title = title;
        this.priority = priority;
        this.assignedEngineer = assignedEngineer;
        this.status = status;
    }

    public int getRequestId() {
        return requestId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssignedEngineer() {
        return assignedEngineer;
    }

    public void setAssignedEngineer(String assignedEngineer) {
        this.assignedEngineer = assignedEngineer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("[%d] %-28s | Priority: %-6s | Status: %-12s\n    Client: %-18s | Category: %-20s | Assigned: %s",
                requestId, title, priority, status, clientName, category, assignedEngineer);
    }
}
