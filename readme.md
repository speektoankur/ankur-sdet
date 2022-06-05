The Framework includes both UI and BackEnd tests

Modules 

![Screenshot 2022-06-05 at 6 24 11 PM](https://user-images.githubusercontent.com/101249539/172051377-68d12d43-3796-48ae-98a6-bdb717e7e504.png)

--> **UserInterfaceFunctional**

Page Factory - Page Object Pattern for UI Screens

Utility - Retrying Failed Tests, Base Functionality, Test Data Utility, Event Listeners for Basic Selenium event logs

UtilityFactory - Used Factory Pattern for Driver Initialisation keeping scalability aspect for Different Env scope

![Screenshot 2022-06-05 at 6 25 43 PM](https://user-images.githubusercontent.com/101249539/172051473-574bee24-4c19-4c9f-b9c9-77a5c837a34a.png)

--> **BackEndFunctionalTest**

Models - POJO pattern for payload and response body

TestBase - Function to set prerequisite and other static utilities

To Run Tests 

Install Java 8
Install Maven 

Commands 
mvn clean install 
mvn test



