# Flexion Code Challenge

## Production Deployment

The Flexion code challenge is deployed on AWS.  The CI/CD pipeline consists
of the following steps:

1. A feature branch must be created and pull request must be made. Currently the feature branch is not built by Jenkins.  This must be added in a production system.
2. On acceptance, the feature branch is merged into master by a reviewer.  
3. When master is updated, Jenkins (deployed on an EC2 instance) automatically builds the application and deployes it to another EC2 instance. Jenkins uses Maven to build and to run the unit tests. Since the application is only deployed on a single EC2 instance, the application is halted and restarted.  In a production environment, a blue/green strategy would be used to avoid any downtime.
  
## Development

Developers can download the source code and run it locally as it is a Spring Boot application.  After starting it, access it via localhost:8080.

## Access

Use the following link to access the deployed application:

http://ec2-34-215-6-75.us-west-2.compute.amazonaws.com:8080/


## TODO

Some tech debt was incurred in the conversions from one unit to another.  Too many common constants and computations. 

And the **WorksheetItemFactorySpec** should be improved to avoid a *problem*.  Can you find it?
