# 🏆 Selenium TestNG Automation for Flipkart

![Java](https://img.shields.io/badge/Java-11-red?logo=java)
![Selenium](https://img.shields.io/badge/Selenium-Web%20Automation-brightgreen?logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-Testing%20Framework-blue?logo=testng)
![XPath](https://img.shields.io/badge/XPath-Query%20Selector-orange)
![License](https://img.shields.io/badge/License-Apache%202.0-green)
![Build](https://img.shields.io/badge/Build-Passing-brightgreen)

## 📌 Overview
This project is an **automated web testing framework** built using **Selenium WebDriver** and **TestNG**, designed to perform automated tests on an e-commerce website. It includes test cases for searching products, filtering results, and analyzing ratings and discounts.

## 🚀 Features
- ✅ Automated web testing using **Selenium WebDriver**
- ✅ **TestNG framework** for structured test execution
- ✅ **XPath-based locators** for precise element selection
- ✅ **Logging and reporting** for test execution
- ✅ **Dynamic waits** for reliable element interactions
- ✅ **Page Object Model (POM)** architecture for maintainability

## 🛠️ Setup Instructions
### Prerequisites
Ensure you have the following installed:
- **Java 11** ([Download](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html))
- **Gradle** ([Download](https://gradle.org/install/))
- **ChromeDriver** ([Download](https://chromedriver.chromium.org/downloads))
- **Selenium WebDriver** ([Documentation](https://www.selenium.dev/documentation/))
- **TestNG** ([Guide](https://testng.org/doc/))

### 🔧 Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Gourab-Pal/flipkart-automation.git
   cd flipkart-automation
   ```
2. Open the project in **VS Code**.
3. Add dependencies via **Gradle** on **build.gradle**:
   ```sh
   dependencies {

      testImplementation 'org.testng:testng:6.9.10'

      // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
      implementation 'org.seleniumhq.selenium:selenium-java:4.21.0'

    }
   ```

## 📌 Test Cases

### 🔍 **Test Case 01 - Search & Ratings**
- Searches for **Washing Machine**
- Clicks on "Popularity" filter
- Extracts ratings and counts products with **≤ 4-star ratings**

### 📱 **Test Case 02 - iPhone Discounts**
- Searches for **iPhone**
- Extracts and prints product titles and discounts above **17%**

### ☕ **Test Case 03 - Coffee Mug Reviews**
- Searches for **Coffee Mug**
- Filters results with **4+ star ratings**
- Finds top **6 most reviewed products**

## 🏃 Running the Tests
### Using TestNG in Terminal
```bash
./gradlew test
```
### Using IDE (VS Code/IntelliJ)
1. Open `TestCases.java`
2. Click **Run** on the `@Test` annotations

## 📝 Project Structure
```plaintext
selenium-testng-project/
├── src/main/java/demo/
│   ├── TestCases.java   # Main test cases
│   ├── Wrappers.java    # Utility functions
│   ├── logging.properties
├── build.gradle         # Gradle dependencies
├── README.md           # Documentation
```



## 📜 License
This project is free to use

## 🤝 Contributing
Feel free to **fork** this repository and submit **pull requests** to improve the framework!

## 📬 Contact
📧 **Email:** [gourab.pal.gpal@gmail.com](mailto:gourab.pal.gpal@gmail.com)
🔗 **LinkedIn:** [Gourab Pal](http://www.linkedin.com/in/gourab-pal-0327801a4)

