# API Regression Testing with RestAssured and TestNG
## Prerequisites
* Install jdk 8 version
* Install Gradle 8.5 version
* Configure **JAVA_HOME** and **GRADLE_HOME**
* Download Allure 2.26.0 and configure environment path
* Stable internet connection
## How to run this project
* Clone the repo
* Open cmd in the root folder
* Give following commands:
```
gradle clean test
```
```
allure generate allure-results --clean -o allure-report
```
* To access the report, open the index.html file in the allure-report folder at the project's root.
```
allure serve allure-results
```
* Access the address of the local Allure service indicated in the terminal output.
## Screenshots
These are the snapshots of the allure reports: