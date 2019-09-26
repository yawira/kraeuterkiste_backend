# Kraeuterkiste - Backend

This is the Backend to our "Kraeuterkiste" project. <br>
It is the connection between Frontend and Raspberry Pi, enabling data exchange and handling HTTP-requests.

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


