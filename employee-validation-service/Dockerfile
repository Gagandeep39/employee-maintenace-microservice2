FROM openjdk:8-jre-alpine
ADD target/*.jar employee-validation-service.jar 
EXPOSE 9400
ENTRYPOINT [ "java", "-jar", "employee-validation-service.jar", "--eureka.instance.hostname=139.59.72.125", "--eureka.instance.port=7000", "--mysql.hostname=remote-mysql", "--spring.profiles.active=prod" ]

# Steps to run
# 1. Build jar file
# mvn package
# 3. Create a container from image
# docker build -t employee-validation-service:tagname .
# 4. Run th container
# docker run -p 9400:9400 employee-validation-service
# Here we are exclicitly specifying docer the url 
# Container does not run on localhost which cause eureka server to not comminicate with other

