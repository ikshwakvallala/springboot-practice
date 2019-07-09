FROM java:8
ADD /customer-service-1.0-SNAPSHOT.jar //
ENTRYPOINT ["java", "-jar", "/customer-service-1.0-SNAPSHOT.jar", "-Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n"]
