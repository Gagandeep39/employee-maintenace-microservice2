FROM openjdk:8-jdk-alpine
ADD target/employee-eureka-server-0.0.1-SNAPSHOT.jar employee-eureka-server.jar 
EXPOSE 9000
ENTRYPOINT [ "java", "-jar", "employee-eureka-server.jar" ]

# Steps to run
# 1. Build jar file
# mvn package
# 3. Create a container from image
# docker build -t employee-eureka-server:tagname .
# 4. Run th container
# docker run -p 9000:9000 employee-eureka-server
# Here we are exclicitly specifying docer the url 
# Container does not run on localhost which cause eureka server to not comminicate with other

