Gym Membership Management System

A Java-based **Gym Membership Management System** that provides full
CRUD functionality, transaction handling, and file-based data storage
using a `.txt` file.

------------------------------------------------------------------------

Project Overview

This system is designed to help manage:

-   Gym Members
-   Trainers
-   Equipment
-   Membership Transactions

All records are stored in a single `.txt` file for simplicity and
compliance with project requirements.

------------------------------------------------------------------------

Features

CRUD Operations

-   Add new members
-   View member records
-   Update member details
-   Delete member records

Transaction Handling

-   Records membership type (Bronze, Silver, Gold, etc.)
-   Tracks payment method (Cash, etc.)
-   Tracks duration
-   Stores transaction date

File-Based Storage

All data is stored in:

    newData.txt

Organized sections: - #MEMBERS - #TRAINERS - #EQUIPMENTS

------------------------------------------------------------------------

Technologies Used

-   Java
-   File Handling (.txt)
-   Object-Oriented Programming (OOP)
-   Custom user-defined methods

------------------------------------------------------------------------

Project Structure

GymMembershipSystem
    ├── GymInterface.java
    ├── GymManager.java
    ├──newData.txt 
    ├── GymInterface.class 
    ├── GymManager.class 
    └── README.md

------------------------------------------------------------------------

How to Run

1.  Compile: javac GymInterface.java javac GymManager.java

2.  Run: java GymInterface

Make sure: - newData.txt is in the same folder. - You are using Java 8
or higher.

------------------------------------------------------------------------

Project Requirements Met

✔ CRUD functionality
✔ Transaction handling
✔ GUI interface
✔ File-based storage (.txt only)
✔ Object-Oriented design

------------------------------------------------------------------------

Author

Adrian Lexter Ajento
Java Gym Membership System Project
