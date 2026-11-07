package com.veda;

import java.util.List;
import java.util.Scanner;

public class VedaTechnologiesApp {

    private static final Scanner sc = new Scanner(System.in);
    private static final OrganizationService service = new OrganizationService();

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            int choice = readIntChoice("Enter your choice: ");

            switch (choice) {
                case 1 -> service.displayDashboard();
                case 2 -> handleServiceCategories();
                case 3 -> handleTechnologyPrograms();
                case 4 -> handleCustomerInquiries();
                case 5 -> handleTrainingPrograms();
                case 6 -> handleInternshipPrograms();
                case 7 -> handleServiceRequests();
                case 0 -> {
                    System.out.println("\nThank you for using Veda Technologies Management System. Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please select an option from 0 to 7.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n==========================================");
        System.out.println("   VEDA TECHNOLOGIES");
        System.out.println("   MANAGEMENT SYSTEM");
        System.out.println("==========================================");
        System.out.println("\nMAIN MENU\n");
        System.out.println("1. Dashboard");
        System.out.println("2. Service Categories");
        System.out.println("3. Technology Programs");
        System.out.println("4. Customer Inquiries");
        System.out.println("5. Training Programs");
        System.out.println("6. Internship Programs");
        System.out.println("7. Service Requests");
        System.out.println("0. Exit");
    }

    // ==========================================================
    // 2. Service Categories Submenu
    // ==========================================================
    private static void handleServiceCategories() {
        while (true) {
            System.out.println("\n--- [Service Categories Management] ---");
            System.out.println("1. View All Service Categories");
            System.out.println("2. Add New Service Category");
            System.out.println("3. Update Service Category");
            System.out.println("4. Delete Service Category");
            System.out.println("0. Back to Main Menu");
            int choice = readIntChoice("Choice: ");

            switch (choice) {
                case 1 -> {
                    List<ServiceCategory> list = service.getAllServiceCategories();
                    System.out.println("\n--- All Service Categories (" + list.size() + ") ---");
                    list.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Enter Category Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine().trim();
                    double price = readDoubleChoice("Enter Base Price ($): ");
                    System.out.print("Is Active? (true/false): ");
                    boolean active = Boolean.parseBoolean(sc.nextLine().trim());

                    int id = service.getNextCategoryId();
                    service.addServiceCategory(new ServiceCategory(id, name, desc, price, active));
                    System.out.println("Service Category added successfully with ID: " + id);
                }
                case 3 -> {
                    int id = readIntChoice("Enter Category ID to update: ");
                    ServiceCategory existing = service.getServiceCategory(id);
                    if (existing == null) {
                        System.out.println("Category not found!");
                        break;
                    }
                    System.out.print("Enter New Name [" + existing.getName() + "]: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) name = existing.getName();

                    System.out.print("Enter New Description: ");
                    String desc = sc.nextLine().trim();
                    if (desc.isEmpty()) desc = existing.getDescription();

                    double price = readDoubleChoice("Enter New Base Price ($): ");
                    System.out.print("Is Active? (true/false): ");
                    boolean active = Boolean.parseBoolean(sc.nextLine().trim());

                    service.updateServiceCategory(id, name, desc, price, active);
                    System.out.println("Service Category updated successfully!");
                }
                case 4 -> {
                    int id = readIntChoice("Enter Category ID to delete: ");
                    if (service.deleteServiceCategory(id)) {
                        System.out.println("Service Category deleted successfully!");
                    } else {
                        System.out.println("Category ID not found.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid selection.");
            }
        }
    }

    // ==========================================================
    // 3. Technology Programs Submenu
    // ==========================================================
    private static void handleTechnologyPrograms() {
        while (true) {
            System.out.println("\n--- [Technology Programs Management] ---");
            System.out.println("1. View All Technology Programs");
            System.out.println("2. Add New Program");
            System.out.println("3. Update Program");
            System.out.println("4. Delete Program");
            System.out.println("0. Back to Main Menu");
            int choice = readIntChoice("Choice: ");

            switch (choice) {
                case 1 -> {
                    List<TechnologyProgram> list = service.getAllTechnologyPrograms();
                    System.out.println("\n--- All Technology Programs (" + list.size() + ") ---");
                    list.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Enter Program Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Domain (e.g., Backend, AI, Cloud): ");
                    String domain = sc.nextLine().trim();
                    int duration = readIntChoice("Enter Duration in Months: ");
                    System.out.print("Enter Status (Active/Upcoming/Retired): ");
                    String status = sc.nextLine().trim();

                    int id = service.getNextProgramId();
                    service.addTechnologyProgram(new TechnologyProgram(id, name, domain, duration, status));
                    System.out.println("Technology Program added successfully with ID: " + id);
                }
                case 3 -> {
                    int id = readIntChoice("Enter Program ID to update: ");
                    TechnologyProgram existing = service.getTechnologyProgram(id);
                    if (existing == null) {
                        System.out.println("Program not found!");
                        break;
                    }
                    System.out.print("Enter New Name [" + existing.getName() + "]: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) name = existing.getName();

                    System.out.print("Enter New Domain [" + existing.getDomain() + "]: ");
                    String domain = sc.nextLine().trim();
                    if (domain.isEmpty()) domain = existing.getDomain();

                    int duration = readIntChoice("Enter Duration in Months: ");
                    System.out.print("Enter Status (Active/Upcoming/Retired): ");
                    String status = sc.nextLine().trim();

                    service.updateTechnologyProgram(id, name, domain, duration, status);
                    System.out.println("Technology Program updated successfully!");
                }
                case 4 -> {
                    int id = readIntChoice("Enter Program ID to delete: ");
                    if (service.deleteTechnologyProgram(id)) {
                        System.out.println("Program deleted successfully!");
                    } else {
                        System.out.println("Program ID not found.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid selection.");
            }
        }
    }

    // ==========================================================
    // 4. Customer Inquiries Submenu
    // ==========================================================
    private static void handleCustomerInquiries() {
        while (true) {
            System.out.println("\n--- [Customer Inquiries Management] ---");
            System.out.println("1. View All Inquiries");
            System.out.println("2. Register New Inquiry");
            System.out.println("3. Update Inquiry Status");
            System.out.println("0. Back to Main Menu");
            int choice = readIntChoice("Choice: ");

            switch (choice) {
                case 1 -> {
                    List<CustomerInquiry> list = service.getAllCustomerInquiries();
                    System.out.println("\n--- Customer Inquiries (" + list.size() + ") ---");
                    list.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Enter Customer/Company Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Contact Email: ");
                    String email = sc.nextLine().trim();
                    System.out.print("Enter Contact Phone: ");
                    String phone = sc.nextLine().trim();
                    System.out.print("Enter Service Interested: ");
                    String serviceName = sc.nextLine().trim();

                    int id = service.getNextInquiryId();
                    service.addCustomerInquiry(new CustomerInquiry(id, name, email, phone, serviceName, "New"));
                    System.out.println("Inquiry registered successfully with ID: " + id);
                }
                case 3 -> {
                    int id = readIntChoice("Enter Inquiry ID to update: ");
                    System.out.print("Enter New Status (New, In Review, Contacted, Converted, Closed): ");
                    String status = sc.nextLine().trim();
                    if (service.updateInquiryStatus(id, status)) {
                        System.out.println("Inquiry status updated successfully!");
                    } else {
                        System.out.println("Inquiry ID not found.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid selection.");
            }
        }
    }

    // ==========================================================
    // 5. Training Programs Submenu
    // ==========================================================
    private static void handleTrainingPrograms() {
        while (true) {
            System.out.println("\n--- [Training Programs Management] ---");
            System.out.println("1. View All Training Programs");
            System.out.println("2. Add New Training Program");
            System.out.println("3. Enroll Student in Program");
            System.out.println("0. Back to Main Menu");
            int choice = readIntChoice("Choice: ");

            switch (choice) {
                case 1 -> {
                    List<TrainingProgram> list = service.getAllTrainingPrograms();
                    System.out.println("\n--- Training Programs (" + list.size() + ") ---");
                    for (TrainingProgram tp : list) {
                        System.out.println(tp);
                        if (!tp.getEnrolledStudents().isEmpty()) {
                            System.out.println("    Enrolled: " + String.join(", ", tp.getEnrolledStudents()));
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Enter Training Program Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Lead Instructor: ");
                    String instructor = sc.nextLine().trim();
                    int cap = readIntChoice("Enter Student Seat Capacity: ");
                    double fee = readDoubleChoice("Enter Registration Fee ($): ");
                    System.out.print("Enter Status (Scheduled/Ongoing/Completed): ");
                    String status = sc.nextLine().trim();

                    int id = service.getNextTrainingId();
                    service.addTrainingProgram(new TrainingProgram(id, name, instructor, cap, fee, status));
                    System.out.println("Training Program created successfully with ID: " + id);
                }
                case 3 -> {
                    int id = readIntChoice("Enter Training Program ID: ");
                    TrainingProgram tp = service.getTrainingProgram(id);
                    if (tp == null) {
                        System.out.println("Training Program not found!");
                        break;
                    }
                    if (tp.getAvailableSeats() <= 0) {
                        System.out.println("Program is already at full capacity (" + tp.getCapacity() + " seats)!");
                        break;
                    }
                    System.out.print("Enter Trainee/Student Name: ");
                    String studentName = sc.nextLine().trim();
                    if (service.enrollStudentInTraining(id, studentName)) {
                        System.out.println("Student '" + studentName + "' enrolled successfully! Remaining seats: " + tp.getAvailableSeats());
                    } else {
                        System.out.println("Failed to enroll student.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid selection.");
            }
        }
    }

    // ==========================================================
    // 6. Internship Programs Submenu
    // ==========================================================
    private static void handleInternshipPrograms() {
        while (true) {
            System.out.println("\n--- [Internship Programs Management] ---");
            System.out.println("1. View All Internship Applications");
            System.out.println("2. Submit New Application");
            System.out.println("3. Update Application Status");
            System.out.println("0. Back to Main Menu");
            int choice = readIntChoice("Choice: ");

            switch (choice) {
                case 1 -> {
                    List<InternshipApplication> list = service.getAllInternshipApplications();
                    System.out.println("\n--- Internship Applications (" + list.size() + ") ---");
                    list.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Enter Applicant Full Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter University / College: ");
                    String college = sc.nextLine().trim();
                    System.out.print("Enter Email Address: ");
                    String email = sc.nextLine().trim();
                    System.out.print("Enter Internship Track (e.g. Java Backend, AI, Cloud): ");
                    String track = sc.nextLine().trim();

                    int id = service.getNextInternshipId();
                    service.addInternshipApplication(new InternshipApplication(id, name, college, email, track, "Applied"));
                    System.out.println("Application registered successfully with ID: " + id);
                }
                case 3 -> {
                    int id = readIntChoice("Enter Application ID to update: ");
                    System.out.print("Enter New Status (Applied, Under Review, Interviewed, Accepted, Rejected): ");
                    String status = sc.nextLine().trim();
                    if (service.updateInternshipStatus(id, status)) {
                        System.out.println("Application status updated successfully!");
                    } else {
                        System.out.println("Application ID not found.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid selection.");
            }
        }
    }

    // ==========================================================
    // 7. Service Requests Submenu
    // ==========================================================
    private static void handleServiceRequests() {
        while (true) {
            System.out.println("\n--- [Service Requests Management] ---");
            System.out.println("1. View All Service Requests");
            System.out.println("2. Create New Service Request");
            System.out.println("3. Assign Lead Engineer");
            System.out.println("4. Update Request Status");
            System.out.println("0. Back to Main Menu");
            int choice = readIntChoice("Choice: ");

            switch (choice) {
                case 1 -> {
                    List<ServiceRequest> list = service.getAllServiceRequests();
                    System.out.println("\n--- Client Service Requests (" + list.size() + ") ---");
                    list.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Enter Client Company Name: ");
                    String client = sc.nextLine().trim();
                    System.out.print("Enter Service Category: ");
                    String cat = sc.nextLine().trim();
                    System.out.print("Enter Request Title / Summary: ");
                    String title = sc.nextLine().trim();
                    System.out.print("Enter Priority (High/Medium/Low): ");
                    String priority = sc.nextLine().trim();
                    System.out.print("Enter Assigned Engineer (or 'Unassigned'): ");
                    String engineer = sc.nextLine().trim();

                    int id = service.getNextRequestId();
                    service.addServiceRequest(new ServiceRequest(id, client, cat, title, priority, engineer, "Open"));
                    System.out.println("Service Request registered successfully with ID: " + id);
                }
                case 3 -> {
                    int id = readIntChoice("Enter Request ID: ");
                    System.out.print("Enter Lead Engineer Name: ");
                    String engineer = sc.nextLine().trim();
                    if (service.assignEngineer(id, engineer)) {
                        System.out.println("Engineer assigned successfully!");
                    } else {
                        System.out.println("Service Request ID not found.");
                    }
                }
                case 4 -> {
                    int id = readIntChoice("Enter Request ID to update: ");
                    System.out.print("Enter New Status (Open, In Progress, Resolved, Closed): ");
                    String status = sc.nextLine().trim();
                    if (service.updateRequestStatus(id, status)) {
                        System.out.println("Request status updated successfully!");
                    } else {
                        System.out.println("Service Request ID not found.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid selection.");
            }
        }
    }

    // ==========================================================
    // Utility Input Helpers
    // ==========================================================
    private static int readIntChoice(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid numeric value.");
            }
        }
    }

    private static double readDoubleChoice(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid decimal number.");
            }
        }
    }
}

