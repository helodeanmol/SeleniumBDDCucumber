FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . /app
RUN mvn clean install

FROM selenium/standalone-chrome
COPY --from=build /app /app
WORKDIR /app
CMD ["mvn", "test"]
