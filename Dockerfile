FROM openjdk:latest
COPY ./target/sem-set08103.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "sem-set08103.jar", "db:33060"]