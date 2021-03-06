FROM maven:3.6.3-openjdk-11 AS MAVEN_BUILD

MAINTAINER Cássio Leodegário

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:11

WORKDIR /app
EXPOSE 9999

COPY --from=MAVEN_BUILD /build/target/product-ms-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "product-ms-0.0.1-SNAPSHOT.jar"]
