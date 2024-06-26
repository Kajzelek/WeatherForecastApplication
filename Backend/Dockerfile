FROM maven:3.8-eclipse-temurin-17-alpine AS build
COPY . .
RUN mvn clean package -dskipTests

FROM eclipse-temurin:21
COPY --from=build /target/WeatherForecastApplication-0.0.1-SNAPSHOT.jar WeatherForecastApplication.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "WeatherForecastApplication.jar"]