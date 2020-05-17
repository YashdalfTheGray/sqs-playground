package com.yashdalfthegray.sqsplayground

import com.yashdalfthegray.sqsplayground.config.run as runSanityTest;

fun main(args: Array<String>): Unit {
    try {
        runSanityTest()
        println("Sanity check completed.")
    } catch (t: Throwable) {
        println("Application encountered error: ")
        println(t)
    }

}
