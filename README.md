 PROG PART 1 - ChatApp

This project is a simple Java login and registration system.

What it does
- Registers a new user with first name, last name, username, password and cell number.
- Validates username, password and cell number.
- Logs in user and shows welcome message.

 Files
- ChatApp.java - Main file, gets input from user using Scanner
- Login.java - Has all validation logic
- LoginTest.java - JUnit tests

Validation Rules

1. Username:
   - Must contain underscore _
   - Max 5 characters
   - Example: `kyl_1` valid, `kyle` invalid

2. Password:
   - At least 8 characters
   - One capital letter
   - One number
   - One special character (! @ # $ % etc)
   - Example: `Test@1234`

3. Cell Number:
   - Must start with +27
   - Followed by 9 numbers
   - Example: "+27821234567"
   - Regex: `^\+27\d{9}$`

 How to Run

1. Open project in NetBeans
2. Right-click ChatApp > Run
3. Enter details when asked

 How to Test

1. Right-click ChatApp > Test
2. All 11 tests should be green (passed)

 Technologies
- Java
- Maven
- JUnit 5

 Author
Student: malebzamphahlele28-cmd
Module: PROG5121 / PROG Part 1
