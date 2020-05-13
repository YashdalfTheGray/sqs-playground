package com.yashdalfthegray.sqsplayground

import io.github.cdimascio.dotenv.dotenv

fun main(args: Array<String>): Unit {
  val dotenv = dotenv {
    ignoreIfMalformed = true
    ignoreIfMissing = true
  }

  println(dotenv["AWS_ACCESS_KEY_ID"])
  println(dotenv["AWS_SECRET_ACCESS_KEY"])
  println(dotenv["AWS_DEFAULT_REGION"])
}
