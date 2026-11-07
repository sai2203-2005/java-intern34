package com.veda;

import java.util.*;

public class OrganizationService {

    private final Map<Integer, ServiceCategory> serviceCategories = new LinkedHashMap<>();
    private final Map<Integer, TechnologyProgram> technologyPrograms = new LinkedHashMap<>();
    private final Map<Integer, CustomerInquiry> customerInquiries = new LinkedHashMap<>();
    private final Map<Integer, TrainingProgram> trainingPrograms = new LinkedHashMap<>();
    private final Map<Integer, InternshipApplication> internshipApplications = new LinkedHashMap<>();
    private final Map<Integer, ServiceRequest> serviceRequests = new LinkedHashMap<>();

    private int nextCategoryId = 101;
    private int nextProgramId = 201;
    private int nextInquiryId = 301;
    private int nextTrainingId = 401;
    private int nextInternshipId = 501;
    private int nextRequestId = 601;

    public OrganizationService() {
        seedSyntheticData();
    }

    private void seedSyntheticData() {
        // 1. Service Categories
        addServiceCategory(new ServiceCategory(nextCategoryId++, "Cloud & DevOps Architecture", "End-to-end cloud migrations, Kubernetes orchestration, and CI/CD automation.", 4500.0, true));
        addServiceCategory(new ServiceCategory(nextCategoryId++, "Enterprise Full-Stack Development", "Microservices, distributed backend systems, and modern web applications.", 6000.0, true));
        addServiceCategory(new ServiceCategory(nextCategoryId++, "Applied AI & Data Engineering", "Machine learning model deployment, data lakehouse, and LLM integrations.", 7500.0, true));
        addServiceCategory(new ServiceCategory(nextCategoryId++, "Cybersecurity & SOC Advisory", "Vulnerability assessments, penetration testing, and ISO 27001 readiness.", 5000.0, true));

        // 2. Technology Programs
        addTechnologyProgram(new TechnologyProgram(nextProgramId++, "Java Enterprise & Spring Microservices", "Backend Systems", 6, "Active"));
        addTechnologyProgram(new TechnologyProgram(nextProgramId++, "Cloud Platform Engineering (AWS/GCP)", "DevOps & Cloud", 5, "Active"));
        addTechnologyProgram(new TechnologyProgram(nextProgramId++, "Generative AI & LLM Systems", "Artificial Intelligence", 4, "Active"));
        addTechnologyProgram(new TechnologyProgram(nextProgramId++, "Cyber Threat Intelligence & SOC", "Information Security", 6, "Upcoming"));

        // 3. Customer Inquiries
        addCustomerInquiry(new CustomerInquiry(nextInquiryId++, "Apollo Health Systems", "tech@apollohealth.org", "+91-9845012345", "Cloud & DevOps Architecture", "In Review"));
        addCustomerInquiry(new CustomerInquiry(nextInquiryId++, "FinFlow Payment Gateway", "contact@finflow.io", "+91-9876543210", "Enterprise Full-Stack Development", "Converted"));
        addCustomerInquiry(new CustomerInquiry(nextInquiryId++, "GreenMatrix Agrotech", "founders@greenmatrix.ai", "+91-9123456789", "Applied AI & Data Engineering", "New"));

        // 4. Training Programs
        TrainingProgram tp1 = new TrainingProgram(nextTrainingId++, "Production Java 21 & Concurrency", "Dr. S. K. Sharma", 25, 450.0, "Ongoing");
        tp1.enrollStudent("Aarav Mehta");
        tp1.enrollStudent("Kavya Reddy");
        tp1.enrollStudent("Rohan Gupta");
        addTrainingProgram(tp1);

        TrainingProgram tp2 = new TrainingProgram(nextTrainingId++, "Kubernetes & Terraform Masterclass", "Priya Nair", 20, 550.0, "Scheduled");
        tp2.enrollStudent("Sneha Varma");
        tp2.enrollStudent("Vikram Joshi");
        addTrainingProgram(tp2);

        // 5. Internship Programs
        addInternshipApplication(new InternshipApplication(nextInternshipId++, "Siva Sekhar", "IIT Madras", "siva.sekhar@campus.edu", "Java Backend Track", "Accepted"));
        addInternshipApplication(new InternshipApplication(nextInternshipId++, "Ananya Deshmukh", "NIT Warangal", "ananya.d@nitw.ac.in", "Cloud & DevOps Track", "Interviewed"));
        addInternshipApplication(new InternshipApplication(nextInternshipId++, "Karthik Raja", "BITS Pilani", "karthik.r@bits.edu", "AI & Data Science Track", "Under Review"));

        // 6. Service Requests
        addServiceRequest(new ServiceRequest(nextRequestId++, "FinFlow Payment Gateway", "Enterprise Full-Stack Development", "OAuth2.0 / OpenID Integration", "High", "Aditya Sen", "In Progress"));
        addServiceRequest(new ServiceRequest(nextRequestId++, "Apollo Health Systems", "Cloud & DevOps Architecture", "Kubernetes Multi-AZ Deployment", "High", "Neha Patil", "Open"));
        addServiceRequest(new ServiceRequest(nextRequestId++, "GreenMatrix Agrotech", "Applied AI & Data Engineering", "Pipeline Latency Profiling", "Medium", "Siddharth Rao", "Resolved"));
    }

    // ==========================================================
    // 1. Service Category Operations
    // ==========================================================
    public void addServiceCategory(ServiceCategory category) {
        serviceCategories.put(category.getId(), category);
    }

    public List<ServiceCategory> getAllServiceCategories() {
        return new ArrayList<>(serviceCategories.values());
    }

    public ServiceCategory getServiceCategory(int id) {
        return serviceCategories.get(id);
    }

    public boolean updateServiceCategory(int id, String name, String desc, double price, boolean active) {
        ServiceCategory cat = serviceCategories.get(id);
        if (cat != null) {
            cat.setName(name);
            cat.setDescription(desc);
            cat.setBasePrice(price);
            cat.setActive(active);
            return true;
        }
        return false;
    }

    public boolean deleteServiceCategory(int id) {
        return serviceCategories.remove(id) != null;
    }

    public int getNextCategoryId() {
        return nextCategoryId++;
    }

    // ==========================================================
    // 2. Technology Program Operations
    // ==========================================================
    public void addTechnologyProgram(TechnologyProgram program) {
        technologyPrograms.put(program.getId(), program);
    }

    public List<TechnologyProgram> getAllTechnologyPrograms() {
        return new ArrayList<>(technologyPrograms.values());
    }

    public TechnologyProgram getTechnologyProgram(int id) {
        return technologyPrograms.get(id);
    }

    public boolean updateTechnologyProgram(int id, String name, String domain, int duration, String status) {
        TechnologyProgram prog = technologyPrograms.get(id);
        if (prog != null) {
            prog.setName(name);
            prog.setDomain(domain);
            prog.setDurationMonths(duration);
            prog.setStatus(status);
            return true;
        }
        return false;
    }

    public boolean deleteTechnologyProgram(int id) {
        return technologyPrograms.remove(id) != null;
    }

    public int getNextProgramId() {
        return nextProgramId++;
    }

    // ==========================================================
    // 3. Customer Inquiry Operations
    // ==========================================================
    public void addCustomerInquiry(CustomerInquiry inquiry) {
        customerInquiries.put(inquiry.getInquiryId(), inquiry);
    }

    public List<CustomerInquiry> getAllCustomerInquiries() {
        return new ArrayList<>(customerInquiries.values());
    }

    public CustomerInquiry getCustomerInquiry(int id) {
        return customerInquiries.get(id);
    }

    public boolean updateInquiryStatus(int id, String newStatus) {
        CustomerInquiry inq = customerInquiries.get(id);
        if (inq != null) {
            inq.setStatus(newStatus);
            return true;
        }
        return false;
    }

    public int getNextInquiryId() {
        return nextInquiryId++;
    }

    // ==========================================================
    // 4. Training Program Operations
    // ==========================================================
    public void addTrainingProgram(TrainingProgram training) {
        trainingPrograms.put(training.getTrainingId(), training);
    }

    public List<TrainingProgram> getAllTrainingPrograms() {
        return new ArrayList<>(trainingPrograms.values());
    }

    public TrainingProgram getTrainingProgram(int id) {
        return trainingPrograms.get(id);
    }

    public boolean enrollStudentInTraining(int trainingId, String studentName) {
        TrainingProgram prog = trainingPrograms.get(trainingId);
        if (prog != null) {
            return prog.enrollStudent(studentName);
        }
        return false;
    }

    public int getNextTrainingId() {
        return nextTrainingId++;
    }

    // ==========================================================
    // 5. Internship Program Operations
    // ==========================================================
    public void addInternshipApplication(InternshipApplication app) {
        internshipApplications.put(app.getApplicationId(), app);
    }

    public List<InternshipApplication> getAllInternshipApplications() {
        return new ArrayList<>(internshipApplications.values());
    }

    public InternshipApplication getInternshipApplication(int id) {
        return internshipApplications.get(id);
    }

    public boolean updateInternshipStatus(int id, String newStatus) {
        InternshipApplication app = internshipApplications.get(id);
        if (app != null) {
            app.setStatus(newStatus);
            return true;
        }
        return false;
    }

    public int getNextInternshipId() {
        return nextInternshipId++;
    }

    // ==========================================================
    // 6. Service Request Operations
    // ==========================================================
    public void addServiceRequest(ServiceRequest request) {
        serviceRequests.put(request.getRequestId(), request);
    }

    public List<ServiceRequest> getAllServiceRequests() {
        return new ArrayList<>(serviceRequests.values());
    }

    public ServiceRequest getServiceRequest(int id) {
        return serviceRequests.get(id);
    }

    public boolean assignEngineer(int requestId, String engineer) {
        ServiceRequest req = serviceRequests.get(requestId);
        if (req != null) {
            req.setAssignedEngineer(engineer);
            return true;
        }
        return false;
    }

    public boolean updateRequestStatus(int requestId, String newStatus) {
        ServiceRequest req = serviceRequests.get(requestId);
        if (req != null) {
            req.setStatus(newStatus);
            return true;
        }
        return false;
    }

    public int getNextRequestId() {
        return nextRequestId++;
    }

    // ==========================================================
    // 7. Executive Dashboard & Metrics
    // ==========================================================
    public void displayDashboard() {
        long activeServices = serviceCategories.values().stream().filter(ServiceCategory::isActive).count();
        long activeTech = technologyPrograms.values().stream().filter(p -> p.getStatus().equalsIgnoreCase("Active")).count();
        long openInquiries = customerInquiries.values().stream().filter(i -> !i.getStatus().equalsIgnoreCase("Closed")).count();
        long totalEnrolled = trainingPrograms.values().stream().mapToInt(t -> t.getEnrolledStudents().size()).sum();
        long acceptedInterns = internshipApplications.values().stream().filter(a -> a.getStatus().equalsIgnoreCase("Accepted")).count();
        long activeRequests = serviceRequests.values().stream().filter(r -> !r.getStatus().equalsIgnoreCase("Resolved") && !r.getStatus().equalsIgnoreCase("Closed")).count();

        double totalTrainingRevenue = trainingPrograms.values().stream().mapToDouble(t -> t.getEnrolledStudents().size() * t.getFee()).sum();
        double activeServicesValuation = serviceCategories.values().stream().filter(ServiceCategory::isActive).mapToDouble(ServiceCategory::getBasePrice).sum();

        System.out.println("\n=======================================================");
        System.out.println("       VEDA TECHNOLOGIES - EXECUTIVE DASHBOARD         ");
        System.out.println("=======================================================");
        System.out.printf("  %-32s : %d (%d Active)%n", "Service Categories", serviceCategories.size(), activeServices);
        System.out.printf("  %-32s : %d (%d Active)%n", "Technology Offerings", technologyPrograms.size(), activeTech);
        System.out.printf("  %-32s : %d (%d Pending Action)%n", "Customer Inquiries", customerInquiries.size(), openInquiries);
        System.out.printf("  %-32s : %d Programs (%d Trainees Enrolled)%n", "Corporate Training", trainingPrograms.size(), totalEnrolled);
        System.out.printf("  %-32s : %d Applicants (%d Accepted)%n", "Internship Candidates", internshipApplications.size(), acceptedInterns);
        System.out.printf("  %-32s : %d Total (%d Active/In-Progress)%n", "Client Service Requests", serviceRequests.size(), activeRequests);
        System.out.println("-------------------------------------------------------");
        System.out.printf("  %-32s : $%,.2f%n", "Active Services Pipeline Value", activeServicesValuation);
        System.out.printf("  %-32s : $%,.2f%n", "Total Training Revenue Realized", totalTrainingRevenue);
        System.out.println("=======================================================");
    }
}
