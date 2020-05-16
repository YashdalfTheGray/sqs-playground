package com.yashdalfthegray.sqsplayground.aws

import com.yashdalfthegray.sqsplayground.config.Env
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sqs.SqsAsyncClient

object Clients {
    private val credsProvider = EnvironmentVariableCredentialsProvider.create()

    val sqs = SqsAsyncClient
        .builder()
        .credentialsProvider(credsProvider)
        .region(Region.of(Env.awsDefaultRegion))
        .build()
}