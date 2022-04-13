FROM openjdk:11

USER root

RUN mkdir -p /home/java/stub 

WORKDIR /home/java/stub

RUN apt-get update -y \
    && apt-get install -y maven
    
ENV PATH=/var/maven/bin:$PATH  
    
COPY . /home/java/stub

CMD ["spring-boot:run"]


