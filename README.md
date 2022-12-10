# SaquAPI Project Backend Source
This repository contains the backend source code of the SaquAPI project. The project aims to help to record and manage the watermeter position of each room in each month at SAPIENTIA EMTE Boarding School. 

This project's backend was created with Apache Maven ( https://maven.apache.org ), a software project management and comprehension tool designed for Java based projects that work with dependencies. As the programming language, the code is written in Java EE ( https://javaee.github.io ).

# Technologies used:
- Intellij IDEA
- Java EE
- Wildfly
- MySQL DBMS

# Prerequisites
- IntelliJ IDEA Ultimate Edition ( https://www.jetbrains.com/idea/download ) as coding environment
- Wildfly 20 by JBoss ( https://github.com/wildfly/wildfly ) for running the web-server
- Java 1.8 Edition ( was tested and works fine, but may be upgraded in the future )

# Configuring Jboss Wildfly
- You need to specify the directory of your Wildfly 20 server, which can be downloaded from this website: https://www.wildfly.org/downloads
- In the Intellij IDEA open `Edit configurations...` near the `Run` button, then in the `Deployment` menu add the artifact `saquapi:war exploded` and then `Apply`

# Development server
- Run Wildfly 20 configuration with the `Run` button
- After the message `Artifact is deployed successfully` is shown, the server's base URL can be accessed on `http://localhost:8080/saquapi/api/<API path>`

# Applying changes
After the wanted changes are done, the artifact neeeds to be redeployed to apply the changes. It can de done by clicking the `Run` button, selecting `Redeploy`, then `OK`. After the server redeployes the artifact, the changes should be seen. 

# Testing APIs
To test if the APIs are working correctly, there can be used any software that can handle HTTP requests and responses.
An alternative for this purpose is `Postman` ( https://www.postman.com ) which is a free software for personal and study use.

# Frontend
For the usage of the full web application, the frontend of the project also has to be set up. It can be reached at https://github.com/napsugarinf/SaquAPI_FrontEnd. For the configuration and setup please follow the instructions in it's README.md file.

# Database
For the database connection there is no need to configure or download anything, since it is a cloud-based DB. It is located in Europe, but can be accessed from anywhere, only the response time may differ depending on your geological location.

# Further help
For more information related to the used technologies please visit the websites given above.
