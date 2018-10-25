FROM tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/java/apache-tomcat-8.5.34/webapps/*
COPY ./target/AWSDemo.war /usr/java/apache-tomcat-8.5.34/webapps/AWSDemo.war
CMD ["catalina.sh","run"] 