# Job Portal System

## 📌 Project Overview
The **Job Portal System** is a backend-driven application designed to connect employers and candidates. It facilitates job postings, application management, and resume uploads. The system includes role-based authentication for Admins, Employers, and Candidates to ensure a secure and efficient recruitment process.

* **Role:** Software Developer Intern
* **Tech Stack:** Java, Spring Boot, MySQL, Hibernate
* **Tooling:** Maven, Postman, IntelliJ IDEA

---

## 🚀 Features

### 1. User Module
* **Registration & Login:** Secure registration for Employers and Candidates.
* **Role-Based Access:** * **Admin:** Verifies employer accounts.
    * **Employer:** Posts jobs and reviews applications.
    * **Candidate:** Browses jobs and applies.

### 2. Job Module
* **Post Jobs:** Verified employers can create job listings.
* **Browse Jobs:** Candidates can view all available job openings.
* **Search:** Retrieve jobs by specific IDs or Employers.

### 3. Application Module
* **Apply for Jobs:** Candidates can apply to jobs and upload their **Resume (PDF)**.
* **Track Applications:** Candidates can view their application history.
* **Review Applicants:** Employers can see who applied to their jobs.

---

## 🛠️ Tech Stack & Setup

* **Language:** Java 17+
* **Framework:** Spring Boot 3.x
* **Database:** MySQL 8.0
* **Build Tool:** Maven

## ⚙️ Installation & Execution Steps

Follow these steps to run the project locally:

### 1. Clone the Repository
git clone [https://github.com/YourUsername/JobPortalSystem.git](https://github.com/YourUsername/JobPortalSystem.git)
cd JobPortalSystem

2. Configure Database
Open MySQL Workbench.
Create the database:
CREATE DATABASE job_portal_db;

Open src/main/resources/application.properties and update your MySQL credentials:
spring.datasource.username=root
spring.datasource.password=YourPassword

3. Build & Run
Open the project in IntelliJ IDEA.
Let Maven download all dependencies.
Run the main class: JobPortalApplication.java.
The server will start at http://localhost:8080.

## 🔌 API Endpoints (Postman)

| Method | Endpoint | Description | Auth Required |
| :--- | :--- | :--- | :--- |
| **POST** | `/users/register` | Register a new user | No |
| **POST** | `/users/login` | Login to the system | No |
| **POST** | `/users/verify/{id}` | Admin verifies Employer | Admin |
| **POST** | `/jobs/postJob` | Employer posts a job | Employer |
| **POST** | `/applications/apply` | Candidate applies (File) | Candidate |
| **GET** | `/jobs` | View all jobs | Public |

## 📂 Folder Structure

```text
JobPortalSystem
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── prasanna
│   │   │           └── JobPortal
│   │   │               ├── config        # Security Configurations
│   │   │               ├── controller    # API Endpoints (User, Job, Application)
│   │   │               ├── entity        # Database Models
│   │   │               ├── repository    # Database Repositories
│   │   │               └── service       # Business Logic
│   │   └── resources
│   │       └── application.properties    # Database & File Config
├── uploads                   # Stores uploaded resumes (Created automatically)
├── pom.xml                   # Maven Dependencies
├── mvnw                      # Maven Wrapper
└── README.md                 # Project Documentation

```

📝 Contact

Developer: Prasanna Lakshmi Motati

Email: prasannalakshmimotati@gmail.com

