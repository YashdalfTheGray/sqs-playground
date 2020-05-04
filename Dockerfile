FROM amazoncorretto:8

# set up an arg to switch the language on a whim
ARG lang=kotlin

# install some dependencies
RUN yum install -y vim wget unzip

# install gradle
RUN wget -nv https://services.gradle.org/distributions/gradle-5.0-bin.zip -P /tmp && unzip -q -d /opt/gradle /tmp/gradle-*.zip
ENV GRADLE_HOME=/opt/gradle/gradle-5.0
ENV PATH=${GRADLE_HOME}/bin:${PATH}

# set up the app workspace
RUN mkdir -p /usr/sqs-playground
WORKDIR /usr/sqs-playground

# initialze an empty kotlin project
RUN gradle --no-daemon init --type ${lang}-library --dsl kotlin
COPY build.gradle.kts /usr/sqs-playground/build.gradle.kts
