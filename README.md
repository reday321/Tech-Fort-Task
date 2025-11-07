# Selenium Automation Testing Project

## Project Overview

This project contains automated test cases for the TechForing career portal using Selenium WebDriver with Java. It includes automated user registration (sign-up) and login functionality with CAPTCHA reading capabilities.

## Features

- **Automated User Registration**: Fills out and submits the sign-up form with user details
- **Automated Login**: Authenticates users with email and password
- **CAPTCHA Reading**: Uses Tesseract OCR to automatically read and solve CAPTCHA challenges
- **Page Navigation**: Handles dynamic web elements and waits for proper page loading

## [Automation Video](https://drive.google.com/file/d/1q8cMrsdwHeOi8av6QgttMS-V-d8EkoM5/view?usp=sharing)

## Technologies Used

- **Java**: Programming language
- **Selenium WebDriver**: Browser automation framework
- **JUnit 5**: Testing framework for organizing and running test cases
- **Tesseract OCR**: Optical Character Recognition library for reading CAPTCHA text
- **Tess4J**: Java wrapper for Tesseract OCR
- **ChromeDriver**: WebDriver implementation for Chrome browser

## Project Structure

```
├── CaptchaReader.java       # Handles CAPTCHA image extraction and OCR processing
├── Login_SignUp.java        # Contains test cases for sign-up and login
└── lib/
    └── tessdata/            # Tesseract language data files
```

## Prerequisites

Before running this project, ensure you have:

1. **Java JDK 8 or higher** installed
2. **Maven** (for dependency management)
3. **Chrome browser** installed
4. **ChromeDriver** matching your Chrome version
5. **Tesseract OCR** installed and configured

## Dependencies

Add these dependencies to your `pom.xml`:

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.x.x</version>
    </dependency>
    
    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.x.x</version>
        <scope>test</scope>
    </dependency>
    
    <!-- Tess4J for OCR -->
    <dependency>
        <groupId>net.sourceforge.tess4j</groupId>
        <artifactId>tess4j</artifactId>
        <version>5.x.x</version>
    </dependency>
</dependencies>
```

## Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd <project-directory>
   ```

2. **Install Tesseract OCR**
  - **Windows**: Download from [GitHub Tesseract releases](https://github.com/tesseract-ocr/tesseract)
  - **macOS**: `brew install tesseract`
  - **Linux**: `sudo apt-get install tesseract-ocr`

3. **Download Tesseract language data**
  - Create a `lib/tessdata` directory in your project
  - Download `eng.traineddata` from [Tesseract GitHub](https://github.com/tesseract-ocr/tessdata)
  - Place it in the `lib/tessdata` folder

4. **Configure ChromeDriver**
  - Download ChromeDriver from [official site](https://chromedriver.chromium.org/)
  - Add ChromeDriver to your system PATH or specify the path in code



## How It Works

### CaptchaReader.java

This class handles CAPTCHA recognition:
- Takes a screenshot of the CAPTCHA element
- Saves it as a PNG file
- Uses Tesseract OCR to extract text from the image
- Cleans the extracted text by removing whitespace and special characters
- Returns the cleaned CAPTCHA text

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
- Reads and enters CAPTCHA automatically
- Verifies CAPTCHA
- Completes sign-up process

#### 2. Login Test (`@Order(2)`)
- Navigates to the login page
- Enters email credentials
- Enters password
- Submits the login form


## Important Notes

⚠️ **CAPTCHA Accuracy**: OCR-based CAPTCHA reading may not be 100% accurate. The success rate depends on:
- CAPTCHA image quality
- Font complexity
- Background noise
- Tesseract configuration

⚠️ **Test Data**: Update the test credentials in `Login_SignUp.java` before running:
- Email addresses
- Passwords
- Phone numbers
- Personal information

⚠️ **Ethical Considerations**: This project is for educational and testing purposes only. Automated CAPTCHA solving may violate terms of service of some websites.

## License

This project is for educational purposes only.

## Contact

For questions or issues, please open an issue in the repository.

