FROM openjdk:8-jre-alpine
ADD target/*.jar employee-gateway-service.jar 
EXPOSE 9900
ENTRYPOINT [ "java", "-jar", "employee-gateway-service.jar", "--eureka.instance.hostname=139.59.72.125", "--eureka.instance.port=7000" ]

# Steps to run
# 1. Build jar file
# mvn package
# 3. Create a container from image
# docker build -t employee-gateway-service:tagname .
# 4. Run th container
# docker run -p 9900:9900 employee-gateway-service
# Here we are exclicitly specifying docer the url 
# Container does not run on localhost which cause eureka server to not comminicate with other

