# Selenium Automation Testing Project

## Project Overview

This project contains automated test cases for the TechForing career portal using Selenium WebDriver with Java. It includes automated user registration (sign-up) and login functionality with manual CAPTCHA input using `Thread.sleep()` for pausing test execution.

## Features

- **Automated User Registration**: Fills out and submits the sign-up form with user details
- **Automated Login**: Authenticates users with email and password
- **Manual CAPTCHA Input**: Uses `Thread.sleep()` for manual CAPTCHA entry during test execution
- **Page Navigation**: Handles dynamic web elements and waits for proper page loading

## [Automation Video](https://drive.google.com/file/d/1q8cMrsdwHeOi8av6QgttMS-V-d8EkoM5/view?usp=sharing)

## Technologies Used

- **Java**: Programming language
- **Selenium WebDriver**: Browser automation framework
- **JUnit 5**: Testing framework for organizing and running test cases
- **Gradle**: Build automation tool
- **ChromeDriver**: WebDriver implementation for Chrome browser


## How It Works

### Login_SignUp.java

Contains two test cases:

#### 1. SignUp Test (`@Order(1)`)
- Navigates to the TechForing career portal
- Clicks the sign-up button
- Fills in user details:
  - Full Name
  - Phone Number
  - Date of Birth
  - Gender (dropdown selection)
  - Email
  - Password
  - Confirm Password
- Pauses execution with `Thread.sleep()` for manual CAPTCHA input
- Waits for tester to manually enter the CAPTCHA
- Completes sign-up process

#### 2. Login Test (`@Order(2)`)
- Navigates to the login page
- Enters email credentials
- Enters password
- Submits the login form


## Important Notes

⚠️ **Manual CAPTCHA Input**: The tests use `Thread.sleep()` to pause execution and wait for manual CAPTCHA entry. Ensure you monitor the test execution and enter the CAPTCHA when prompted.

⚠️ **Test Data**: Update the test credentials in `Login_SignUp.java` before running:
- Email addresses
- Passwords
- Phone numbers
- Personal information

⚠️ **Test Execution**: Monitor test execution closely as manual intervention is required during CAPTCHA validation.



## Bug Report

For detailed bug report information, please refer to the Google Drive document:

📊 [Bug Report Spreadsheet](https://docs.google.com/spreadsheets/d/19hOZSLZQophndQ6DyEtCQpEqJsuG2VSg/edit?usp=drive_link&ouid=115215919620166132160&rtpof=true&sd=true)

## Test Cases

For comprehensive test cases, please refer to the Google Drive document:

📋 [Test Case Spreadsheet](https://docs.google.com/spreadsheets/d/1EjxHCxoR_dQsJRXSvwKm9Ca5rRWzYQ0z/edit?usp=drive_link&ouid=115215919620166132160&rtpof=true&sd=true)

## Contact

For questions or issues, please open an issue in the repository.

