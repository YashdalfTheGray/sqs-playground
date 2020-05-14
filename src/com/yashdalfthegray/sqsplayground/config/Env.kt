package com.yashdalfthegray.sqsplayground.config

import io.github.cdimascio.dotenv.dotenv

object Env {
  private val dotenv = dotenv {
    ignoreIfMalformed = false
    ignoreIfMissing = false
  }
    private get

  val awsAccessKeyId: String?
    get() = this.dotenv["AWS_ACCESS_KEY_ID"]

  val awsSecretAccessKey: String?
    get() = this.dotenv["AWS_SECRET_ACCESS_KEY"]

  val awsDefaultRegion: String?
    get() = this.dotenv["AWS_DEFAULT_REGION"]
}
