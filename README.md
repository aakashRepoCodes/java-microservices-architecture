# Java Microservices Architecture

A microservices-based architecture built with Java, Spring Boot, Kafka, and observability tools like Prometheus and Grafana.

![App Architecture ]( https://i.postimg.cc/7hCwfXVg/356532380-d4ef38bd-8ae5-4cc7-9ac5-7a8e5ec3c969.png)

## Features
- **Decoupled Services**: Independent services with REST APIs and Kafka.
- **Event-Driven Architecture**: Kafka for asynchronous messaging.
- **Authentication**: Keycloak for OAuth2-based security.
- **Monitoring**: Metrics with Prometheus and Grafana; centralized logs with Loki.
- **Resiliency**: Fault tolerance with Circuit Breaker patterns.

## Technologies
- **Frameworks**: Spring Boot, Spring Cloud
- **Messaging**: Kafka
- **Database**: MySQL, MongoDB
- **Authentication**: Keycloak
- **Monitoring**: Prometheus, Grafana, Loki
- **Build Tool**: Gradle
- **Containerization**: Docker

## Services
1. **Order Service**: Handles order placement and sends events to Kafka.
2. **Notification Service**: Listens to Kafka and sends email notifications.
3. **API Gateway**: Centralized routing and authentication.
