package com.yashdalfthegray.sqsplayground.config

import io.github.cdimascio.dotenv.dotenv

object Env {
    private val dotenv = dotenv {
        ignoreIfMalformed = false
        ignoreIfMissing = false
    }

    val awsAccessKeyId: String?
        get() = this.dotenv["AWS_ACCESS_KEY_ID"]

    val awsSecretAccessKey: String?
        get() = this.dotenv["AWS_SECRET_ACCESS_KEY"]

    val awsDefaultRegion: String?
        get() = this.dotenv["AWS_DEFAULT_REGION"]

    val sqsQueueName: String?
        get() = this.dotenv["SQS_QUEUE_NAME"]

    val isProducer: Boolean
        get() = this.dotenv["MODE"] == "PRODUCER"

    val isConsumer: Boolean
        get() = this.dotenv["MODE"] == "CONSUMER"
}
