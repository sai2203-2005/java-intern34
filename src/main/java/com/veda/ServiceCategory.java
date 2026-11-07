package com.veda;

public class ServiceCategory {
    private int id;
    private String name;
    private String description;
    private double basePrice;
    private boolean active;

    public ServiceCategory(int id, String name, String description, double basePrice, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.active = active;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format("[%d] %-30s | Base: $%-8.2f | Status: %s\n    Description: %s",
                id, name, basePrice, (active ? "Active" : "Inactive"), description);
    }
}

