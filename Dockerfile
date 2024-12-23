FROM openjdk:17
EXPOSE 8080
COPY target/Springboot-3.2.3.war Springboot-3.2.3.war
ENTRYPOINT ["java","-war","/Springboot-3.2.3.war"]

