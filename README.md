# 🏢 Veda Technologies – Java Organization Management System

[![Java](https://img.shields.io/badge/Java-17%2B%20%2F%2021%20%2F%2023-orange.svg)](https://www.oracle.com/java/)
[![Build](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]()
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Architecture](https://img.shields.io/badge/Architecture-Modular%20OOP%20%26%20Collections-blueviolet.svg)]()

A comprehensive, production-style console platform developed in **Core Java** that simulates the organizational workflow of **Veda Technologies**—managing technology offerings, corporate training courses, customer inquiries, student internships, and client service requests.

---

## 📌 Table of Contents

- [Overview](#-overview)
- [System Architecture](#-system-architecture)
- [Module Breakdown & Features](#-module-breakdown--features)
- [Project Directory Structure](#-project-directory-structure)
- [Synthetic Sample Data](#-synthetic-sample-data)
- [Technologies Used](#-technologies-used)
- [How to Compile and Run](#-how-to-compile-and-run)
- [Interactive Console Walkthrough](#-interactive-console-walkthrough)
- [Future Roadmap & Database Upgrade](#-future-roadmap--database-upgrade)
- [License](#-license)

---

## 📖 Overview

The **Veda Technologies Organization Management System** serves as an operational hub for digital services and training management. It emphasizes:
* **Object-Oriented Design**: Clean encapsulation, separation of concerns, and domain modeling.
* **In-Memory High-Performance Collections**: `LinkedHashMap` for fast $O(1)$ ID lookups while maintaining deterministic insertion sequence for reporting.
* **Preloaded Synthetic Data**: Instantly operational upon launch, allowing immediate exploration of dashboards, inquiries, training rosters, and client service tickets.

---

## 🏗️ System Architecture

```
                       ┌───────────────────────────────────┐
                       │      VedaTechnologiesApp.java     │
                       │     (Interactive Menu Controller) │
                       └─────────────────┬─────────────────┘
                                         │ delegates
                                         ▼
                       ┌───────────────────────────────────┐
                       │     OrganizationService.java      │
                       │    (Business Logic & Collections) │
                       └─────────────────┬─────────────────┘
                                         │ coordinates
         ┌──────────────┬────────────────┼──────────────┬──────────────┐
         ▼              ▼                ▼              ▼              ▼
┌──────────────┐ ┌──────────────┐ ┌──────────────┐ ┌──────────────┐ ┌──────────────┐
│ServiceCategory│ │TechnologyProg│ │CustomerInq   │ │TrainingProg  │ │ServiceRequest│
└──────────────┘ └──────────────┘ └──────────────┘ └──────────────┘ └──────────────┘
```

---

## ⚡ Module Breakdown & Features

| Module | Key Operations | Description |
| :--- | :--- | :--- |
| **1. Executive Dashboard** | Metrics & Aggregations | Live overview of total offerings, pipeline valuations, active service tickets, and training enrollments. |
| **2. Service Categories** | Add, View, Update, Delete | Manage organizational services (e.g., Cloud & DevOps, AI Engineering, Full-Stack Development). |
| **3. Technology Programs** | Add, View, Update, Delete | Track technical tracks, duration, and status (Active, Upcoming, Retired). |
| **4. Customer Inquiries** | Register, View, Update Status | Capture enterprise leads and update engagement statuses (New, In Review, Converted, Closed). |
| **5. Training Programs** | Add, View, Enroll Students | Manage corporate courses, seat capacities, course fees, and student rosters. |
| **6. Internship Programs** | Register, View, Update Status | Track student applicants across engineering tracks and track recruitment pipelines. |
| **7. Service Requests** | Create, View, Assign, Resolve | Client ticketing system for assigning lead engineers and resolving deliverables. |

---

## 📁 Project Directory Structure

```
src/main/java/com/veda/
├── ServiceCategory.java        # Domain Model: Service definitions and base pricing
├── TechnologyProgram.java      # Domain Model: Curriculum offerings and technical domains
├── CustomerInquiry.java        # Domain Model: Enterprise client contact information
├── TrainingProgram.java        # Domain Model: Training course capacities, rosters, and fees
├── InternshipApplication.java  # Domain Model: Internship candidate pipeline
├── ServiceRequest.java         # Domain Model: Client engineering tickets & priorities
├── OrganizationService.java    # Service Layer: Collections storage, CRUD, and dashboard calculations
└── VedaTechnologiesApp.java    # Main Entry Point: Menu loop, input sanitization, and navigation
```

---

## 💾 Synthetic Sample Data

The application boots with realistic enterprise seed data:
* **Services**: Cloud & DevOps (\$4,500), Full-Stack Systems (\$6,000), Applied AI (\$7,500), Cybersecurity (\$5,000).
* **Corporate Training**: Production Java 21, Kubernetes & Terraform with pre-enrolled students.
* **Internship Candidates**: Real student applicant records from premier technical universities.
* **Live Service Tickets**: In-progress client deliverables with assigned engineers.

---

## 🧠 Technologies Used

* **Java 17+ / 21 / 23**: Modern Core Java features (switch expressions, stream reductions, string formatting).
* **OOP Principles**: High cohesion, encapsulation, and domain model decoupling.
* **Java Collections Framework**: `LinkedHashMap<Integer, T>` and `ArrayList<T>`.
* **Defensive I/O**: Robust console input handling avoiding scanner skipping traps.

---

## 🚀 How to Compile and Run

### Prerequisites
* Java JDK 17 or higher installed.

### Step 1: Compile all source files into the `out` directory
```powershell
javac -d out (Get-ChildItem -Path src/main/java/com/veda/*.java).FullName
```
*(On Linux/macOS: `javac -d out src/main/java/com/veda/*.java`)*

### Step 2: Execute the application
```powershell
java -cp out com.veda.VedaTechnologiesApp
```

---

## 🖥️ Interactive Console Walkthrough

### 1. Main Navigation Menu
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

### 2. Live Executive Dashboard
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

---

## 🗺️ Future Roadmap & Database Upgrade

* [ ] **Phase 2 (MySQL + JDBC Connectivity):** Migrate in-memory maps to MySQL schemas with DAO classes and database connection pools.
* [ ] **Phase 3 (Enterprise Spring Boot REST API):** Expose endpoints for customer inquiry submissions and training enrollments.
* [ ] **Phase 4 (Frontend UI Dashboard):** React.js single-page application with real-time analytics charts and PDF export functionality.

---

## 📜 License

This project is licensed under the MIT License - feel free to use it for portfolio presentations, academic projects, and learning references.
