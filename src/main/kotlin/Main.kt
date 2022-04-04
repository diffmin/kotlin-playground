package com.kotlinprotobuf

import com.google.protobuf.util.JsonFormat
import tutorial.classA
import tutorial.classB
import tutorial.classC
import tutorial.classD
import tutorial.person
import tutorial.personR

fun main(args: Array<String>) {
    run {
        val b = person {
            name = "aa"
            id = 123
            emails = classC {
                testB = classB {
                    id = 1
                    idB = 2
                }
            }
        }

        println(b.emails.hasTestA())
        println(b.emails.hasTestB())

        println(JsonFormat.printer().print(b))
    }

    run {
        val b = person {
            name = "aa"
            id = 123
            emails = classC {
                testA = classA {
                    id = 1
                    idA = 2
                }
            }
        }

        println(b.emails.hasTestA())
        println(b.emails.hasTestB())

        println(JsonFormat.printer().print(b))
    }

    run {
        val b = person {
            name = "aa"
            id = 123
            emails = classC {
                testA = classA {
                    id = 1
                    idA = 2
                }
                testB = classB {
                    id = 1
                    idB = 2
                }
            }
        }

        println(b.emails.hasTestA())
        println(b.emails.hasTestB())

        println(JsonFormat.printer().print(b))
    }

    run {
        val d = classD {
            id = 123
            testB = classB {
                id = 1
                idB = 2
            }
        }

        println(d.hasTestA())
        println(d.hasTestB())

        println(JsonFormat.printer().print(d))
    }

    run {
        val b = personR {
            name = "aa"
            id = 123
            emails = ???
        }

//        println(b.emails.hasTestA())
//        println(b.emails.hasTestB())

        println(JsonFormat.printer().print(b))
    }
}
