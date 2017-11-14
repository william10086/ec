# eureka ..

eureka 是一种服务发现机制，为 aws 而生，也可以在非 `AWS`  的环境使用 

spring cloud 也整合了其他的东西去实现这个 ..

# Spring Cloud Config Client

A Spring Boot application can take immediate advantage of the Spring Config Server (or other 
external property sources provided by the application developer), and it will also pick up some 
additional useful features to related to `Environment`

# Config First Bootstrap

When a config client starts up it binds to the Config Server (via the bootstrap configuration 
property `spring.cloud.config.uri`) and initialize Spring `Environment` with remote property 
sources.

The net result of this is that all client apps that want to consume the Config Server need a 
bootstrap.yml (or an environment variable) with the server address in `spring.cloud.config.uri` 
(defaults to "http://localhost:8888") 



# Registering with Eureka

When a client registers with Eureka, it provides meta-data with itself such as host and port, 
health indicator URL, home page etc. Eureka receives heartbeat messages from each instance 
belonging to a service. If the heartbeat fails over a configurable timetable, the instance is 
normally removed from the registry.

# Status Page and Health Indicator

The status page and health indicators for a Eureka instance default to "/info" and "/health" 
respectively, which are the default locations of useful endpoints in a Spring Boot Actuator 
application.  
 
 