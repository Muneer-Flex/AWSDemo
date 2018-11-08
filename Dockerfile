FROM tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/AWSDemo.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]