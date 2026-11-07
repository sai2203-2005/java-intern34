package com.veda;

public class TechnologyProgram {
    private int id;
    private String name;
    private String domain;
    private int durationMonths;
    private String status;

    public TechnologyProgram(int id, String name, String domain, int durationMonths, String status) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.durationMonths = durationMonths;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("[%d] %-32s | Domain: %-18s | Duration: %d mos | Status: %s",
                id, name, domain, durationMonths, status);
    }
}

