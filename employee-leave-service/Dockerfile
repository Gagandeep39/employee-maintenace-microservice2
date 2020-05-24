FROM openjdk:8-jdk-alpine
ADD target/employee-leave-service-0.0.1-SNAPSHOT.jar employee-leave-service.jar 
EXPOSE 9300
ENTRYPOINT ["java", "-jar", "employee-leave-service.jar", "--eureka.instance.hostname=192.168.99.100" ]

# Steps to run
# 1. Build jar file
# mvn package
# 3. Create a container from image
# docker build -t employee-leave-service:tagname .
# 4. Run th container
# docker run -p 9300:9300 employee-leave-service
# Here we are exclicitly specifying docer the url 
# Container does not run on localhost which cause eureka server to not comminicate with other

