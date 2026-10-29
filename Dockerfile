# ---------- Stage 1: build with Gradle on an official JDK image ----------
FROM eclipse-temurin:17-jdk AS build
WORKDIR /workspace

COPY gradlew settings.gradle build.gradle ./
COPY gradle gradle
RUN chmod +x gradlew && ./gradlew --no-daemon dependencies > /dev/null

COPY src src
RUN ./gradlew --no-daemon bootJar -x test

# ---------- Stage 2: small Java runtime image ----------
FROM eclipse-temurin:17-jre
LABEL maintainer="Zhansaya Kalymova" \
      app="kalymova-zhansaya-student-api"
WORKDIR /app
COPY --from=build /workspace/build/libs/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
