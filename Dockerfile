FROM openjdk:11
VOLUME /tmp
EXPOSE 9999
ADD ./target/product-ms-0.0.1-SNAPSHOT.jar product-ms.jar
ENTRYPOINT ["java", "-jar", "product-ms.jar"]