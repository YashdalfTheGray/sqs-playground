# sqs-playground

A project just to allow me to mess around with SQS queue types, and also learn some Kotlin.

There are two ways to build (and run) this project - you can do it on your computer or you can do it inside a docker container. We'll go over both below, starting with the Docker way because you don't have to install anything for the docker way.

As with any project that uses AWS, you're going to want to give the AWS SDK some credentials to work with. This project does it through environment variables because it has to run under Docker. So create a new file in the root of the project called `.env` and put these three keys in it.

```
AWS_ACCESS_KEY_ID=<access_key_id>
AWS_SECRET_ACCESS_KEY=<secret_access_key>
AWS_DEFAULT_REGION=<valid_aws_region_name>
SQS_QUEUE_NAME=<sqs_queue_name>
MODE={PRODUCER|CONSUMER}
```

## The way of the container

### Building

With Docker, you can just build the container with `docker build -t sqs-playground .`. This build uses the Docker builder pattern. We build the code in a separate container and we run it in a separate container.

The advantage being that the builder container can be thrown away once a binary has been compiled for the runner container to use. And we don't need to drag all the build tooling into the runtime container.

### Running

Then running the container is as simple as `docker run --env-file <path_to_env_file> -it --rm --name sqs-test sqs-playground:latest`. This will run a fully built jar of your code in a runner container.

## The way of the host

You can, of course, build and run this project on your computer if you so choose. The project uses gradle so running a `gradle clean build` and then a `gradle run` will not only build the project and get everything set up but also run it for you as an application.

### `fatjar`

This project has the ability to zip up everything that it needs to run into a single jar that can be executed using the `java -jar <path_to_singular_jar>` command. You can create this "fatjar" (as it's called in the java world) by running `gradle fatjar`. A `gradle clean build` before the `fatjar` command is recommended, although not entirely required.
