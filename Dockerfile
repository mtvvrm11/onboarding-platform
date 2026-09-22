from maven:3.9-openjdk-17 as build
workdir /app
copy pom.xml .
run mvn dependency:go-offline -b
copy src ./src
run mvn clean package -dskiptests

from openjdk:17-jdk-slim
workdir /app
copy --from=build /app/target/vels-onboarding-platform-*.jar app.jar
expose 8082
entrypoint ["java", "-xmx512m", "-jar", "app.jar"]