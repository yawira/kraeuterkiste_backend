# Kraeuterkiste - Backend

This is the Backend to our "Kraeuterkiste" project. <br>
It is the connection between Frontend and Raspberry Pi, enabling data exchange and handling HTTP-requests.

Project Kraeuterkiste is a REST-Application consisting of three parts - Frontend, Backend and Raspberry Pi module. It is build to enable users to take care of their plants via the internet. Let's say you are on holiday and want to check on your greens at home. Simply visit a website and push a button to take a photo of the current state or water it in case it looks dry. Check the charts monitoring the moisture of your plant's soil or the previous watering/lighting details. If your plant doesn't get enough light - no problem! Push a button and a 6500K LED light will help it grow.  

## Getting Started

### Prerequisites

- IDE
- MariaDB Relational Database
- Web Browser

### Application Properties

server.port=6060 <br>
spring.datasource.url=jdbc:mariadb://localhost:3306/raspi <br>
spring.datasource.username=* <br>
spring.datasource.password=* <br>

spring.datasource.driver-class-name=org.mariadb.jdbc.Driver <br>
spring.jpa.hibernate.ddl-auto=create 

##### Raspberry Pi configuration
raspi.ip=192.168.43.240 <br>
raspi.port=4444 <br>
raspi.url=http://${raspi.ip}:${raspi.port} <br>


## Technologies

- Java
- Maven - Dependency Management
- Spring Boot - Microservice Framework
- RESTful Webservices
- Lombok


## Authors

- Ralf Jackels
- Lorenz Josten
- Evgeni Kozyr
- Laura Yawira Lewinski


