FROM amazoncorretto:8 as builder

# set up an arg to switch the language on a whim
ARG lang=kotlin

# install some dependencies
RUN yum install -y vim wget unzip tree

# install gradle
RUN wget -nv https://services.gradle.org/distributions/gradle-5.0-bin.zip -P /tmp && unzip -q -d /opt/gradle /tmp/gradle-*.zip
ENV GRADLE_HOME=/opt/gradle/gradle-5.0
ENV PATH=${GRADLE_HOME}/bin:${PATH}

# set up the app workspace
RUN mkdir -p /usr/sqs-playground
WORKDIR /usr/sqs-playground

# copy over our project
COPY . /usr/sqs-playground/

RUN gradle clean build

# FROM amazoncorretto:8 as runner
