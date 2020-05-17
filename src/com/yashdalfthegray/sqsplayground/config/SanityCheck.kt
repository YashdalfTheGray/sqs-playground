package com.yashdalfthegray.sqsplayground.config

import java.lang.RuntimeException

@Throws(RuntimeException::class)
fun run() {
    val credsFound = (Env.awsAccessKeyId != "") && (Env.awsSecretAccessKey != "");
    val regionFound = Env.awsDefaultRegion != ""
    val sqsQueueFound = Env.sqsQueueName != ""
    val modeFound = Env.isConsumer || Env.isProducer

    if (!credsFound) {
        throw RuntimeException("No AWS credentials found")
    }
    if (!regionFound) {
        throw RuntimeException("No region defined for the application")
    }
    if (!sqsQueueFound) {
        throw RuntimeException("This application needs an SQS queue to operate")
    }
    if (!modeFound) {
        throw RuntimeException("The MODE environment variable was not defined")
    }
}