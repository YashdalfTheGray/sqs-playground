package com.yashdalfthegray.sqsplayground.config

import java.lang.RuntimeException

@Throws(RuntimeException::class)
fun run() {
    var message = ""

    if ((Env.awsAccessKeyId == "") || (Env.awsSecretAccessKey == "")) {
        message = "No AWS credentials found"
    }
    if (Env.awsDefaultRegion == "") {
        message = "No region defined for the application"
    }
    if (Env.sqsQueueName == "") {
        message = "This application needs an SQS queue to operate"
    }
    if (!Env.isConsumer && !Env.isProducer) {
        message = "The MODE environment variable was not defined"
    }

    if (message.isNotEmpty()) {
        throw RuntimeException(message)
    }
}