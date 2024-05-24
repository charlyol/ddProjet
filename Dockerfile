FROM maven:3.9.6-eclipse-temurin-22 as build

WORKDIR /app

COPY . /app

RUN mvn install

FROM eclipse-temurin:22.0.1_8-jre-alpine

WORKDIR /app

COPY --from=build /app/target/demojdbc.jar ./demojdbc.jar

CMD java -jar demojdbc.jar