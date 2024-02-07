Overview
This Java project is designed to manage student information using various data structures such as hash tables and linked lists. 
It primarily focuses on storing, searching, and managing(insert, update, delete) student data efficiently.

Functionality Of Code
Read Names from Files: Reads male, female and last names from separate text files.
Generate Random Students: Creates random student profiles using the names read from files.
Hash Tables Implementation: Utilizes two types of hash tables (Chaining and Open Addressing) for efficient data storage and retrieval.
Efficient Operations: Performs operations on hash tables to search, delete and add new student information.

Structure
Main Class: Orchestrates the overall process including reading names, generating students, storing them in hash tables, and searching for student records.
Student Class: Represents the student entity with attributes like name, ID, department, and faculty.
StudentDatabase Class: Manages a collection of student objects.
StudentGenerator Class: Generates random student data.
ReadNames Class: Reads names from files and stores them in lists.
ChainingHashTable Class: Implements a hash table using chaining.
OpenAddressingHashTable Class: Implements a hash table using open addressing.
HashFunctions Class: Provides hash functions for the hash tables.
Node Class: Represents a node in a linked list for the chaining hash table.
StudentLinkedList Class: Manages a linked list of students.

How to Run
Set Up Environment: Ensure Java is installed on your system.
Clone/Download Code: Obtain the source code files on your machine.
Data Files: Prepare malename.txt, femalename.txt, and lastnames.txt files with names for the program to read.
Compile the Program: Use a Java compiler to compile the .java files.
Run the Application: Execute the compiled program.
