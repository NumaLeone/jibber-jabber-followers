FROM gradle:7.4.2-jdk8
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/gradle/src/build/libs/jibber-jabber-posts-0.0.1-SNAPSHOT.jar"]