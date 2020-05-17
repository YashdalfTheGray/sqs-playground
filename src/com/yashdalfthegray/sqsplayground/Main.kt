package com.yashdalfthegray.sqsplayground

import com.yashdalfthegray.sqsplayground.config.Env

fun main(args: Array<String>): Unit {
    println(Env.awsAccessKeyId)
    println(Env.awsSecretAccessKey)
    println(Env.awsDefaultRegion)
    println(Env.sqsQueueName)
    println(Env.isConsumer)
    println(Env.isProducer)
}
