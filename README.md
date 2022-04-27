## IMG Tennis Event Application

Restful microservice to display details of licensed tennis matches for a customer.
A customer may license either an individual match or a whole tournament. Every match is part of a tournament. The service should support
multiple customers with different license agreements.
The service should return the following as JSON:
An array of matches a customer has purchased. Each element should contain:
* matchId: Unique ID for the match
* startDate: Date and Time the match is scheduled to start
* playerA: Name of player A
* playerB: Name of player B
* summary: An optional parameter called summaryType can be set to any of:
    - AvB - in which case return string "player A vs player B"
    - AvBTime - in which case use the start time to return string: 
      - "player A vs player B, starts in x minutes". when start time is in the future.
      - "player A vs player B, started x minutes ago" when start time is in the past.

## Tech Stack

For this project I have used:

- Spring Boot
- Spring Data JPA
- H2

## Running the application
To start the application run the following command:
```
docker-compose up -d
```

## Swagger - Open API Spec

After docker compose command, once it is completed successfully, 
the API specifications are available at http://localhost:80
    
  - endpoints: 
    
    - http://localhost:8080/api/v1/customer/1/matches
    - http://localhost:8080/api/v1/customer/1/matches?summaryType=AVB
    - http://localhost:8080/api/v1/customer/1/matches?summaryType=AVB_TIME


