## Application
Countries route demo

Application implemented by Impact Zbigniew Bockowski for recruitment process

## Building & Running

### Running from jar
```
gradle build
./gradlew bootRun
```

### Port
8080

### Open Api Documentation
```
/v3/api-docs (json)
/v3/api-docs.yaml (yaml)
```

### SwaggerUI endpoint
```
/swagger-ui.html
```

### Documentation
Application is implemented based on latest tech stack, Java 17, Spring Boot 3, Gradle 7.
Business functionality demonstrates usage of popular breadth-first algorithm to find route between two entries. 
Source data is loaded from file and transformed into Graph structure at application startup.

There is only one endpoint implemented according to task requirements. It will always return single path between given origin and destination (if exists).
It will return 400 Bad Request error in case there is no land connection between given countries. 

I have implemented just two unit tests for my implementation, because of the time limitation. Subsequently unit tests doesn't cover whole application business logic.
Integration tests should as well cover API implemented in the application.
Of course application requires much more effort to be fully completed, among others:
-Data validation
-Extended Error handling.
-Security layer
-Fully tested business logic
-Service pipeline definition.
-Any containerization setup.
-Postman collections for test purposes.

### Final note
I was not given much information about position for this recruitment process. 
My main expertise and experience is related to microservices architecture and tech stack used around their implementation.
To be honest I'm a little bit wondering if task given to me has anything in common with expected skill set that perfect candidate should possess. 
Being a very experienced programmer who leads a lot of various solutions I am capable to implement any task, but algorithms are not my favourite ones.
If my concerns are groundless and you like my implementation I would be happy to talk to you some time at next recruitment process step. 
