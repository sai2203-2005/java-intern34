# 🏢 Veda Technologies – Technology & Digital Services Management Platform

[![Java](https://img.shields.io/badge/Java-17%2B%20%2F%2021%20%2F%2023-orange.svg)](https://www.oracle.com/java/)
[![Build](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]()
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Architecture](https://img.shields.io/badge/Architecture-Modular%20OOP%20%26%20Collections-blueviolet.svg)]()
[![Platform](https://img.shields.io/badge/Platform-Console%20%2F%20CLI-lightgrey.svg)]()

A modular, production-style organization management application written in **Core Java**. It simulates the comprehensive operations of **Veda Technologies**—orchestrating technology consulting services, technical curriculum offerings, customer sales inquiries, corporate training rosters, student internship pipelines, and client service ticketing.

---

## 📌 Table of Contents

- [1. Project Overview](#1-project-overview)
- [2. System Architecture](#2-system-architecture)
- [3. Functional Modules & Requirements](#3-functional-modules--requirements)
- [4. Project Structure](#4-project-structure)
- [5. Synthetic Sample Dataset](#5-synthetic-sample-dataset)
- [6. Core Java & OOP Concepts Implemented](#6-core-java--oop-concepts-implemented)
- [7. How to Compile and Run](#7-how-to-compile-and-run)
  - [Option A: Compiling with Sourcepath (Recommended)](#option-a-compiling-with-sourcepath-recommended)
  - [Option B: Compiling All Source Files](#option-b-compiling-all-source-files)
  - [Running in IDEs (VS Code / IntelliJ IDEA)](#running-in-ides-vs-code--intellij-idea)
- [8. Interactive Console Walkthrough & Sample Output](#8-interactive-console-walkthrough--sample-output)
- [9. Future Roadmap: MySQL & JDBC Upgrade](#9-future-roadmap-mysql--jdbc-upgrade)
- [10. License](#10-license)

---

## 1. Project Overview

**Veda Technologies** operates across multiple digital domains: enterprise consulting, corporate training, academic internships, and ongoing client service delivery.

This application acts as an operational console that manages organizational entities in memory using the **Java Collections Framework** (`LinkedHashMap`, `ArrayList`) and strictly follows **Object-Oriented Design Principles**.

### Key Highlights:
- **Zero External Dependencies**: Runs out of the box with pure Java standard libraries (JDK 17+).
- **Preloaded Synthetic Data**: Ready for immediate demonstration without requiring manual data entry on startup.
- **Defensive Console Architecture**: Sanitized user input preventing scanner newline bugs and numerical parsing errors.
- **Executive Dashboard**: Real-time statistical aggregation of pipeline valuation, active client requests, and trainee enrollment revenues.

---

## 2. System Architecture

The application adopts a clean, decoupled **Model-Service-Controller** design:

```
                                ┌──────────────────────────────────────────┐
                                │        VedaTechnologiesApp.java          │
                                │   (Console Controller & Menu Dispatcher) │
                                └────────────────────┬─────────────────────┘
                                                     │ delegates
                                                     ▼
                                ┌──────────────────────────────────────────┐
                                │         OrganizationService.java         │
                                │   (Business Logic, CRUD & Aggregations)  │
                                └────────────────────┬─────────────────────┘
                                                     │ manages in-memory
          ┌─────────────────┬────────────────────────┼─────────────────┬─────────────────┐
          ▼                 ▼                        ▼                 ▼                 ▼
 ┌─────────────────┐┌─────────────────┐    ┌──────────────────┐┌────────────────┐┌────────────────┐
 │ ServiceCategory ││TechnologyProgram│    │ CustomerInquiry  ││TrainingProgram ││ ServiceRequest │
 │     (Model)     ││     (Model)     │    │     (Model)      ││    (Model)     ││    (Model)     │
 └─────────────────┘└─────────────────┘    └──────────────────┘└────────────────┘└────────────────┘
                                                     ▲
                                                     │
                                           ┌──────────────────┐
                                           │InternshipApplicat│
                                           │     (Model)      │
                                           └──────────────────┘
```

---

## 3. Functional Modules & Requirements

| Module | Operational Capabilities | Business Purpose |
| :--- | :--- | :--- |
| **1. Executive Dashboard** | Aggregations, metrics, revenue calculations | Overview of operational throughput, active tickets, and revenue realization. |
| **2. Service Categories** | Add, View All, Update, Delete | Manage organizational service offerings, base pricing, and active status. |
| **3. Technology Programs** | Add, View All, Update, Delete | Track technical curriculum tracks, duration in months, and availability. |
| **4. Customer Inquiries** | Register, View All, Update Status | Track inbound business leads through lifecycle stages (`New` $\to$ `In Review` $\to$ `Contacted` $\to$ `Converted` $\to$ `Closed`). |
| **5. Corporate Training** | Add Course, View, Enroll Trainees | Manage technical workshops, seat capacity limits, fees, and trainee rosters. |
| **6. Internship Programs** | Register Applicant, View, Update Status | Pipeline tracking for student candidates (`Applied` $\to$ `Under Review` $\to$ `Interviewed` $\to$ `Accepted` $\to$ `Rejected`). |
| **7. Service Requests** | Create Ticket, View, Assign, Resolve | Enterprise client service deliverables, priority management (`High`, `Medium`, `Low`), and engineer assignment. |

---

## 4. Project Structure

```
src/main/java/com/veda/
│
├── ServiceCategory.java        # Domain Model: Consultative service definition & base fee
├── TechnologyProgram.java      # Domain Model: Technology offerings, domain, & duration
├── CustomerInquiry.java        # Domain Model: Client leads, service interest, & contact info
├── TrainingProgram.java        # Domain Model: Corporate training capacities, fees, & enrollments
├── InternshipApplication.java  # Domain Model: Student candidate applications & review stage
├── ServiceRequest.java         # Domain Model: Client delivery tickets, priority, & engineer assign
│
├── OrganizationService.java    # Service Layer: Collections repository, synthetic seed, & CRUD
└── VedaTechnologiesApp.java    # Application Entry: Menu loop, input validation, & display
```

---

## 5. Synthetic Sample Dataset

The system initializes with realistic enterprise sample records:

### Service Categories
| ID | Service Name | Base Price | Status | Description |
| :---: | :--- | :---: | :---: | :--- |
| **101** | Cloud & DevOps Architecture | \$4,500.00 | Active | End-to-end cloud migrations, Kubernetes orchestration, and CI/CD. |
| **102** | Enterprise Full-Stack Development | \$6,000.00 | Active | Distributed microservices and modern responsive web systems. |
| **103** | Applied AI & Data Engineering | \$7,500.00 | Active | ML model deployment, lakehouse pipelines, and LLM integrations. |
| **104** | Cybersecurity & SOC Advisory | \$5,000.00 | Active | Vulnerability assessments, penetration testing, and ISO 27001. |

### Technology Curriculums
| ID | Program Name | Domain | Duration | Status |
| :---: | :--- | :--- | :---: | :---: |
| **201** | Java Enterprise & Spring Microservices | Backend Systems | 6 Months | Active |
| **202** | Cloud Platform Engineering (AWS/GCP) | DevOps & Cloud | 5 Months | Active |
| **203** | Generative AI & LLM Systems | Artificial Intelligence | 4 Months | Active |
| **204** | Cyber Threat Intelligence & SOC | Information Security | 6 Months | Upcoming |

### Pre-Enrolled Corporate Training
* **Production Java 21 & Concurrency** (Instructor: Dr. S. K. Sharma | Fee: \$450.00 | Enrolled: 3/25)
* **Kubernetes & Terraform Masterclass** (Instructor: Priya Nair | Fee: \$550.00 | Enrolled: 2/20)

### Client Service Deliverables
* **OAuth2.0 / OpenID Integration** (Client: FinFlow Payment Gateway | Priority: High | Assigned: Aditya Sen | Status: In Progress)
* **Kubernetes Multi-AZ Deployment** (Client: Apollo Health Systems | Priority: High | Assigned: Neha Patil | Status: Open)
* **Pipeline Latency Profiling** (Client: GreenMatrix Agrotech | Priority: Medium | Assigned: Siddharth Rao | Status: Resolved)

---

## 6. Core Java & OOP Concepts Implemented

| Concept | Implementation Details |
| :--- | :--- |
| **Encapsulation** | All domain entities declare private attributes with public accessors, mutators, and formatted `toString()` representations. |
| **High Cohesion & Separation of Concerns** | UI presentation (`VedaTechnologiesApp`) is strictly isolated from data storage and business rules (`OrganizationService`). |
| **Java Collections Framework** | `LinkedHashMap<Integer, T>` provides $O(1)$ key-based access while maintaining deterministic insertion order for tabular console display. |
| **Java 17+ Switch Expressions** | Modern arrow syntax (`case 1 -> ...`) for clean, fall-through-safe menu branch dispatching. |
| **Java Streams API** | Real-time numerical reductions (`sum()`, `filter()`, `count()`, `mapToDouble()`) inside `displayDashboard()`. |
| **Defensive I/O Programming** | Custom input helpers `readIntChoice()` and `readDoubleChoice()` with try-catch blocks prevent `InputMismatchException` and `Scanner.nextInt()` newline skipping bugs. |

---

## 7. How to Compile and Run

### Prerequisites
* **Java Development Kit (JDK) 17, 21, or 23** installed.
* Verify your Java version:
  ```powershell
  javac -version
  java -version
  ```

---

### Option A: Compiling with Sourcepath (Recommended)

From the project root directory (`c:\Users\sivas\OneDrive\Desktop\java intership`):

```powershell
# Compile the main application with its source tree
javac -d out -sourcepath src/main/java src/main/java/com/veda/VedaTechnologiesApp.java

# Run the compiled application
java -cp out com.veda.VedaTechnologiesApp
```

---

### Option B: Compiling All Source Files

#### On Windows (PowerShell):
```powershell
# Create out directory if not present
if (!(Test-Path out)) { New-Item -ItemType Directory -Name out }

# Compile all source files
javac -d out (Get-ChildItem -Path src/main/java/com/veda/*.java).FullName

# Execute
java -cp out com.veda.VedaTechnologiesApp
```

#### On Linux / macOS (Bash):
```bash
javac -d out src/main/java/com/veda/*.java
java -cp out com.veda.VedaTechnologiesApp
```

---

### Running in IDEs (VS Code / IntelliJ IDEA)

1. **IntelliJ IDEA**:
   * Open the project root folder.
   * Right-click on `src/main/java` $\to$ **Mark Directory as** $\to$ **Sources Root**.
   * Open `src/main/java/com/veda/VedaTechnologiesApp.java` and click **Run**.
2. **VS Code**:
   * Open the workspace folder.
   * Install the **Extension Pack for Java**.
   * Navigate to `VedaTechnologiesApp.java` and click the **Run** button above `main()`.

---

## 8. Interactive Console Walkthrough & Sample Output

### 1. Main Menu Screen
```text
==========================================
   VEDA TECHNOLOGIES
   MANAGEMENT SYSTEM
==========================================

MAIN MENU

1. Dashboard
2. Service Categories
3. Technology Programs
4. Customer Inquiries
5. Training Programs
6. Internship Programs
7. Service Requests
0. Exit

Enter your choice: 1
```

### 2. Executive Dashboard Output
```text
=======================================================
       VEDA TECHNOLOGIES - EXECUTIVE DASHBOARD         
=======================================================
  Service Categories               : 4 (4 Active)
  Technology Offerings             : 4 (3 Active)
  Customer Inquiries               : 3 (3 Pending Action)
  Corporate Training               : 2 Programs (5 Trainees Enrolled)
  Internship Candidates            : 3 Applicants (1 Accepted)
  Client Service Requests          : 3 Total (2 Active/In-Progress)
-------------------------------------------------------
  Active Services Pipeline Value   : $23,000.00
  Total Training Revenue Realized  : $2,450.00
=======================================================
```

### 3. Customer Inquiry Submenu & Listing
```text
--- [Customer Inquiries Management] ---
1. View All Inquiries
2. Register New Inquiry
3. Update Inquiry Status
0. Back to Main Menu
Choice: 1

--- Customer Inquiries (3) ---
[301] Apollo Health Systems | Service: Cloud & DevOps Architecture | Status: In Review   
    Contact: tech@apollohealth.org | +91-9845012345
[302] FinFlow Payment Gateway | Service: Enterprise Full-Stack Development | Status: Converted   
    Contact: contact@finflow.io | +91-9876543210
[303] GreenMatrix Agrotech | Service: Applied AI & Data Engineering | Status: New         
    Contact: founders@greenmatrix.ai | +91-9123456789
```

### 4. Client Service Requests Overview
```text
--- [Service Requests Management] ---
1. View All Service Requests
2. Create New Service Request
3. Assign Lead Engineer
4. Update Request Status
0. Back to Main Menu
Choice: 1

--- Client Service Requests (3) ---
[601] OAuth2.0 / OpenID Integration | Priority: High   | Status: In Progress 
    Client: FinFlow Payment Gateway | Category: Enterprise Full-Stack Development | Assigned: Aditya Sen
[602] Kubernetes Multi-AZ Deployment | Priority: High   | Status: Open        
    Client: Apollo Health Systems | Category: Cloud & DevOps Architecture | Assigned: Neha Patil
[603] Pipeline Latency Profiling   | Priority: Medium | Status: Resolved    
    Client: GreenMatrix Agrotech | Category: Applied AI & Data Engineering | Assigned: Siddharth Rao
```

---

## 9. Future Roadmap: MySQL & JDBC Upgrade

The current version maintains data in-memory for zero-friction setup. The planned architectural evolution includes:

```
┌─────────────────────────┐       ┌─────────────────────────┐       ┌─────────────────────────┐
│     Console / Web UI    │ ───▶  │      Service Layer      │ ───▶  │        DAO Layer        │
│  (VedaTechnologiesApp)  │       │  (Business Validation)  │       │   (JDBC PreparedStmts)  │
└─────────────────────────┘       └─────────────────────────┘       └────────────┬────────────┘
                                                                                 │
                                                                                 ▼
                                                                    ┌─────────────────────────┐
                                                                    │      MySQL Database     │
                                                                    │  (Persistent Relational)│
                                                                    └─────────────────────────┘
```

* [ ] **Phase 2 (MySQL + JDBC Persistence):**
  * Create normalized relational tables: `service_categories`, `technology_programs`, `customer_inquiries`, `training_programs`, `internship_applications`, and `service_requests`.
  * Implement connection pooling via `HikariCP` and `DBConnection.java`.
  * Replace collection mutations with transactional SQL queries (`PreparedStatement`).
* [ ] **Phase 3 (Enterprise Spring Boot REST API):**
  * Expose REST endpoints (`/api/v1/services`, `/api/v1/inquiries`, `/api/v1/trainings`).
  * Implement Spring Security with JWT authentication for Administrator and Engineer roles.
* [ ] **Phase 4 (Web Dashboard & Analytics):**
  * Modern React.js frontend with live Chart.js metrics and automated PDF invoice/mark sheet exports.

---

## 10. License

This project is licensed under the **MIT License** — feel free to use, modify, and distribute it for academic coursework, technical interview portfolios, and enterprise training simulations.
