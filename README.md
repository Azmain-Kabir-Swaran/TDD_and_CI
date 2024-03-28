
# Test Driven Development and CI
## Build Tools, Junit, Mocking, Coverage and Mutation, Continuous Integration with GitHub Actions

```
.
├── src
│   ├── main/java/org/example
│   │   ├── Main.java
│   │   └── MyString.java
│   │   
│   └── test/java/org/example
│       ├── MainTest.java
│       └── MyStringTest.java
│
├── pom.xml
└── README.md
```

In this project, I implemented a Java file called [MyString.java](src/main/java/org/example/MyString.java) to implement two methods, "indexOfString" and "replace" by following a Test-Driven Development (TDD) approach. The "indexOfString" method finds the first occurrence of a substring in a given string from a specified position. For the "replace" method, I reused "indexOfString" method to replace occurrences of one substring with another in a given string. I ensured robustness and correctness through test coverage and mutation scoring and integrated continuous integration with GitHub Actions. I also used mocking to test each method independently. If any input string is null or empty, appropriate handling is done to ensure the methods return expected values. [MyStringTest.java](src/test/java/org/example/MyStringTest.java) file contains all the test scripts.

## Steps to Run the Program
  1. [Requirements](#1-requirements)
  2. [Setup \& Usage](#2-setup--usage)

### 1. Requirements

- IntelliJ IDEA Community Edition was used to develop the Java program along Maven build tool and openjdk-19.
- All the required dependencies (JUnit, Mockito, and PITest) can be found inside the [pom.xml](pom.xml) file.
- Preferred operating system: Linux/macOS/Windows-WSL/Windows.


### 2. Setup \& Usage

To execute all the tests please use the below command from the root directory of the project:

```bash
mvn clean test
```
or
```bash
mvn clean package
```
or
```bash
mvn test
```

To see the PIT test report (line and mutation coverage) please use the following command from the project's root directory:

```bash
mvn clean test-compile org.pitest:pitest-maven:mutationCoverage
```

If the command is successful then the report will be available for the [MyString.java](src/main/java/org/example/MyString.java) file and can be found inside the `target/pit-reports/org.example/` directory.
