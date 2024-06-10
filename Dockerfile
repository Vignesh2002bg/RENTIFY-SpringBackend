FROM maven:3.8.5-openjdk-17 As build
COPY . .
Run mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/RentifyAppJar.jar RentingBackendHost.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","RentingBackendHost.jar"]