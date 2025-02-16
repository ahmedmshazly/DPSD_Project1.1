
# Pizza Configuration API - Project 1.1

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Architecture & Design](#architecture--design)
  - [Model Package](#model-package)
  - [Wrapper Package (API)](#wrapper-package-api)
  - [Exceptions Package](#exceptions-package)
- [File Structure](#file-structure)
- [Installation & Setup](#installation--setup)
- [Usage](#usage)
- [Testing](#testing)
- [Design Artifacts](#design-artifacts)
- [Future Enhancements](#future-enhancements)
- [Credits & License](#credits--license)

## Overview
The **Pizza Configuration API - Project 1.1** is an enhanced iteration of the initial Pizza Configuration proof-of-concept (Project 1.0). This version refactors the core model to use dynamic collections and introduces an API layer that encapsulates the model while exposing a controlled set of operations. The project also lays the foundation for robust custom exception handling.

## Features
- **Dynamic Data Structures:**  
  Refactored model classes use `ArrayList` for dynamic management of OptionSets and Options.
- **API Layer:**  
  The `wrapper` package contains:
  - **API Interfaces:** `CreatePizzeria` and `UpdatePizzeria`
  - **Abstract Class:** `ProxyPizzerias` (holding a shared `LinkedHashMap` of pizzerias)
  - **Concrete API Implementation:** `PizzeriaConfigAPI`
- **Custom Exception Framework:**  
  A basic custom exception hierarchy is established (e.g., `PizzeriaException`, `MissingBasePriceException`, `DuplicateOptionSetException`) along with an Exception Factory for future extensibility.
- **Integration & Testing:**  
  A comprehensive test driver (`PizzeriaAPITestDriver`) demonstrates creation, updates, printing, and error handling of pizzeria configurations.
- **Documentation & UML Diagrams:**  
  Detailed design artifacts and documentation are provided to support the architecture and design decisions.

## Architecture & Design

### Model Package
The `model` package contains the core data classes:
- **PizzaConfig:**  
  - Represents an entire pizza configuration.
  - Holds a `String` name, a `double` base price, and an `ArrayList<OptionSet>`.
- **OptionSet:**  
  - Represents a set of options (e.g., size, toppings).
  - Contains an `ArrayList<Option>` and an inner class **Option** that stores individual option details (name and price).

### Wrapper Package (API)
The `wrapper` package exposes the API layer and abstracts access to the internal model:
- **API Interfaces:**  
  - `CreatePizzeria`: Defines methods for creating and configuring pizzerias.
  - `UpdatePizzeria`: Defines methods for updating pizzeria details (e.g., base price, option set names, option prices).
- **ProxyPizzerias (Abstract Class):**  
  - Holds a static `LinkedHashMap<String, PizzaConfig>` to ensure a single shared data source.
  - Provides helper methods to retrieve pizzerias.
- **PizzeriaConfigAPI (Concrete Class):**  
  - Implements both API interfaces.
  - Provides methods to create, update, print, and (stub) configure pizzerias.

### Exceptions Package
The `exceptions` package sets the groundwork for robust error handling:
- **PizzeriaException:**  
  - The base custom exception class.
- **Specific Exceptions:**  
  - Examples include `MissingBasePriceException` and `DuplicateOptionSetException`.
- **ExceptionFactory:**  
  - Implements the Factory pattern for standardized exception creation.

## File Structure
```
Project1.1/
├── src/
│   ├── model/
│   │   ├── PizzaConfig.java
│   │   └── OptionSet.java
│   ├── wrapper/
│   │   ├── CreatePizzeria.java
│   │   ├── UpdatePizzeria.java
│   │   ├── ProxyPizzerias.java
│   │   └── PizzeriaConfigAPI.java
│   ├── exceptions/
│   │   ├── PizzeriaException.java
│   │   ├── MissingBasePriceException.java
│   │   ├── DuplicateOptionSetException.java
│   │   └── ExceptionFactory.java
│   └── driver/
│       └── PizzeriaAPITestDriver.java
├── README.md
├── .gitignore
├── uml_diagram.png
└── build.xml / pom.xml / build.gradle  (depending on your build tool)
```

## Installation & Setup
### Prerequisites
- **Java JDK 8** or higher
- **IntelliJ IDEA Ultimate**
- **Git** for version control
- **Maven/Gradle/Ant** (depending on your chosen build tool)

### Steps
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/ahmdmshazly/Project1.1.git
   cd Project1.1
   ```
2. **Open in IntelliJ IDEA:**
    - Select **File > Open...** and navigate to the project directory.
3. **Build the Project:**
    - Use IntelliJ's **Build > Build Project** command or your build tool command (e.g., `mvn clean install` or `gradle build`).

## Usage
### Running the Application
- **Test Driver:**
    - Navigate to `src/driver/PizzeriaAPITestDriver.java` and run it.
    - The driver will demonstrate creating a pizzeria, updating configurations, and error handling.

### API Usage
- **Creating a Pizzeria:**
    - Use `PizzeriaConfigAPI.createPizzerias(String pizzeriaName, ArrayList<PizzaConfig> pizzaConfigs)`.
- **Configuring a Pizzeria (Stub):**
    - Use `configurePizzeria(String filename)` for future file I/O integration.
- **Printing & Updating:**
    - Use `printPizzeria(String pizzeriaName)`, `updateOptionSetName(...)`, `updateBasePrice(...)`, and `updateOptionPrice(...)` to manage configurations.

## Testing
### Running Tests
- **JUnit Tests:**
    - Existing tests from Project 1.0 (updated in `src/test/PizzaConfigTest.java`) are maintained to verify model functionality.
- **Integration Testing:**
    - Run the `PizzeriaAPITestDriver` to verify API operations and observe console output for creation, updates, and error handling.

## Design Artifacts
- **UML Diagram:**  
  ![UML Diagram](UMLs/uml_diagram.jpg)
  See `uml_diagram.jpg` for the complete system architecture, including the model, wrapper, and exceptions packages.
- **Design Rationale Document:**  
  (Optional) Include a detailed document discussing design decisions, application of SOLID principles, and design patterns (Factory, Proxy/Adapter).

## Future Enhancements
- **Custom Exception Integration:**  
  Fully integrate custom exceptions into API methods instead of simple console outputs.
- **File I/O Functionality:**  
  Implement the `configurePizzeria` method with file reading capabilities.
- **Multi-threading and Synchronization:**  
  Enhance the API to support concurrent modifications using proper synchronization techniques.
- **Expanded Test Coverage:**  
  Add more comprehensive tests, including boundary and error-case scenarios.

## Credits & License
- **Developed by:** AHMED MOHAMED ELSHAZLY, A MENTALLY STABLE ~ ISH GRADUATE STUDENT WHO SPEND MOST OF HIS DAY FIXING BUGS THAT MAY OR MAY NOT EXIST. 
- **Course:** DPSD (Design Patterns For SmartPhone Development)
- **Institution:** CMU-Africa
- **License:** This project is licensed under the [MIT License](LICENSE).

