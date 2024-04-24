# download the alpine linux with JDK as base image
FROM openjdk:17-alpine
# change the working directory to home, if directory doesn't exist, it will be created
WORKDIR /home
# copy the JAR files in the target directory to the WORKDIR
COPY /target/*.jar /home/
# define the default command to run when the container starts
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
