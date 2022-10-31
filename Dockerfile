FROM openjdk:17-jdk-slim-buster
WORKDIR .

COPY build/* /build/

COPY zip_code_database.csv /build/

COPY build/libs/zipcode-lookup-0.0.1-SNAPSHOT.jar /build/

WORKDIR /build

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /wait
RUN chmod +x /wait

ENTRYPOINT /wait && java -jar zipcode-lookup-0.0.1-SNAPSHOT.jar