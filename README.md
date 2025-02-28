# Hospital Management System

**Final Requirement for Object-Oriented Programming**  
**Developed using Java JFrame and JSwing GUI with MySQL Database**

## Overview
The Hospital Management System is a role-based application designed to streamline hospital operations by providing different levels of access to administrators, doctors, help desk staff, and accounting personnel. The system enhances efficiency, ensures data security, and improves inter-departmental coordination, ultimately leading to better patient care and hospital management.

## Features
### **Administrator Features:**
- Manage patient records (register, view, edit, discharge).
- Manage employee profiles (add, edit, delete, reset passwords).
- View receipts from the accounting department.
- Monitor deleted patient records and modifications by employees.

### **Doctor & Help Desk Features:**
- Register, view, edit, and discharge patients.
- Manage patient records to ensure accuracy.
- View patient receipts for better service coordination.

### **Accounting Features:**
- Finalize bills and process patient payments.
- View receipts and maintain financial records.
- Access patient records in a read-only mode to ensure data security.

### **Security & Access Control:**
- Implements **Role-Based Access Control (RBAC)** to restrict user permissions.
- Ensures only authorized personnel can access sensitive data.
- Secure login system with email and password authentication.

### **Inter-Departmental Coordination:**
- Integrated system to facilitate communication between hospital departments.
- Reduces redundancy and minimizes errors in patient data management.

## Technologies Used
- **Java** (JFrame & JSwing GUI) for user interface and logic.
- **MySQL** for storing patient records, employee details, and financial transactions.

## How to Use
1. **Installation:**
   - Clone the repository or download the project files.
   - Open the project in your preferred Java IDE.
   - Set up a MySQL database and configure the connection in the application.
   - Run the application.

2. **User Login:**
   - Each user logs in with their credentials.
   - The system grants access based on their role (Admin, Doctor, Help Desk, Accountant).

3. **Managing Hospital Operations:**
   - Admins oversee and manage patient and employee records.
   - Doctors and help desk staff handle patient interactions.
   - Accountants process financial transactions securely.

## Scope and Limitations
### **Scope:**
- Desktop-based application accessible on Windows.
- Supports predefined user roles (Admin, Doctor, Help Desk, Accountant).
- Secure login system to prevent unauthorized access.

### **Limitations:**
- No support for appointment scheduling or telemedicine features.
- Does not integrate with external billing systems or healthcare databases.
- No mobile application support.
- Receipts can be viewed but not printed.

## Contributors
- Concept, paper, and developed by Wendel Derraco
