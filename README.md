# sqs-playground

A project just to allow me to mess around with SQS queue types, and also learn some Kotlin.

There are two ways to build (and run) this project - you can do it on your computer or you can do it inside a docker container. We'll go over both below, starting with the Docker way because you don't have to install anything for the docker way.

## The way of the container

### Building

With Docker, you can just build the container with `docker build -t sqs-playground .`. This build uses the Docker builder pattern. We build the code in a separate container and we run it in a separate container.

The advantage being that the builder container can be thrown away once a binary has been compiled for the runner container to use. And we don't need to drag all the build tooling into the runtime container.

### Running

Then running the container is as simple as `docker run -it --rm --name sqs-test sqs-playground:latest`. This will run a fully built jar of your code in a runner container.

## The way of the host

You can, of course, build and run this project on your computer if you so choose. The project uses gradle so running a `gradle clean build` and then a `gradle run` will not only build the project and get everything set up but also run it for you as an application.

### ShadowJar

The ability to create what's called a "fat jar" (a jar with all the dependencies packaged in) is still coming. There is an issue that the ShadowJar library is having with the latest version of Gradle. Once that is resolved, then we shall have ourselves a "fat jar" to run just through Java.
