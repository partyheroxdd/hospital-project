FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD

COPY ./ ./

RUN mvn clean package -DskipTests

FROM openjdk:17

COPY --from=MAVEN_BUILD /target/miras-azhar-midka.jar /miras-azhar-midka.jar

CMD ["java", "-jar", "/miras-azhar-midka.jar"]

