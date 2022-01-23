# Dockerfile for sample service using embedded tomcat server
FROM centos:centos7
MAINTAINER yushin1402

RUN yum install -y \
    java-1.8.0-openjdk \
    java-1.8.0-openjdk-devel \
    wget tar iproute git

RUN wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
RUN sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
RUN yum install -y apache-maven
ENV JAVA_HOME /etc/alternatives/jre
RUN git clone https://github.com/yushin1402/aws-cloudnative-sqsapp.git /usr/local/aws-cloudnative-sqsapp
RUN mvn install -f /usr/local/aws-cloudnative-sqsapp/spring-batch/pom.xml
RUN mkdir /usr/local/aws-cloudnative-sqsapp/sqs-consumer/lib ; \
    cp /usr/local/aws-cloudnative-sqsapp/spring-batch/target/spring-batch-0.0.1-SNAPSHOT.jar /usr/local/aws-cloudnative-sqsapp/sqs-consumer/lib
RUN mvn clean install -f /usr/local/aws-cloudnative-sqsapp/sqs-consumer/pom.xml
RUN cp /etc/localtime /etc/localtime.org
RUN ln -sf  /usr/share/zoneinfo/Asia/Tokyo /etc/localtime
EXPOSE 8080

CMD java -jar -Dspring.profiles.active=dev /usr/local/aws-cloudnative-sqsapp/sqs-consumer/target/sqs-consumer-0.0.1-SNAPSHOT.jar