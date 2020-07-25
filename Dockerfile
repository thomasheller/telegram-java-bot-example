FROM openjdk:11-slim AS build
WORKDIR /java
COPY . .
RUN ./gradlew build

FROM gcr.io/distroless/java:11
COPY --from=build /java/build/libs/telegram-java-bot-example-1.0.0.jar /
ENTRYPOINT ["java", "-jar", "/telegram-java-bot-example-1.0.0.jar"]
