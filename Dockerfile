FROM java
COPY target/authentication-service.jar /
EXPOSE 8081
CMD ["java","-jar","authentication-service.jar"]