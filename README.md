# sqs-playground

A project just to allow me to mess around with SQS queue types, and also learn some Kotlin

## Building

This project uses Docker to do everything. So building is relatively simple, running a simple `docker build -t sqs-playground .`.

## Running

We'll use Docker to run stuff again. Running a `docker run -it --rm --name test-sqs sqs-playground` will run the container. Once started, Gradle and Java are all set up, you can run a `gradle build` to start the build.
