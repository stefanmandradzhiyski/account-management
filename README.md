# account-management

Programming language: Java 11

Framework: Spring

ORM: Hibernate

Database: PostgreSQL

Building tool: Gradle

Additional tools/libraries: Lombok, Mapstruct, Swagger, Flyway

Available functionality:
- Create a new account:
POST api/v1/accounts which can return response HTTP status code 201, 400, 409 or 500
- Get an existing account:
GET api/v1/accounts/{accountId} which can return response HTTP status code 200, 404 or 500
- Get all accounts:
GET api/v1/accounts which can return response HTTP status code 200 or 500
- Update an existing account:
PUT api/v1/accounts/{accountId} which can return response HTTP status code 200, 400, 404, 409 or 500
- Delete an existing account:
DELETE api/v1/accounts/{accountId} which can return response HTTP status code 200, 404 or 500

Setup:
- Import the project as Gradle one;
- Enable Annotation Processors;
- Apply Java 11 SDK;
- Change Gradle build tool settings to build and run with IntelliJ IDEA;
- Change application-development.yml's properties to meet your requirements;
- Run AccountManagementApplication.java;
- Use http://localhost:8080/swagger-ui/index.html#/ in your browser and test the application.
