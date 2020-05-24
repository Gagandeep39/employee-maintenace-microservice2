FROM openjdk:8-jre-alpine
ADD target/*.jar employee-management-service.jar 
EXPOSE 9200
# Here we are exclicitly specifying docer the url 
# Container does not run on localhost which cause eureka server to not comminicate with other
ENTRYPOINT [ "java", "-jar", "employee-management-service.jar", "--eureka.instance.hostname=139.59.72.125", "--eureka.instance.port=7000", "--mysql.hostname=remote-mysql", "--spring.profiles.active=prod" ]

# Steps to run
# 1. Build jar file
# mvn package
# 3. Create a container from image
# docker build -t employee-management-service:tag_name .
# 4. Run the container
# docker run -p 9200:9200 employee-management-service
# If there is eror then useo image instead of name
