package com.kotlinprotobuf

import com.google.protobuf.util.JsonFormat
import tutorial.classA
import tutorial.classB
import tutorial.classC
import tutorial.classD
import tutorial.person
import tutorial.personR

class ExProtobuf {
    fun run() {
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
            // false
            println(b.emails.hasTestB())
            // true

            println(JsonFormat.printer().print(b))
            /*
            {
              "name": "aa",
              "id": 123,
              "emails": { "testB": { "id": 1, "idB": 2 } }
            }
             */
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
            // true
            println(b.emails.hasTestB())
            // false

            println(JsonFormat.printer().print(b))
            /*
            {
              "name": "aa",
              "id": 123,
              "emails": { "testA": { "id": 1, "idA": 2 } }
            }
             */
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
            // false
            println(b.emails.hasTestB())
            // true

            println(JsonFormat.printer().print(b))
            /*
            {
              "name": "aa",
              "id": 123,
              "emails": { "testB": { "id": 1, "idB": 2 } }
            }
             */
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
            // false
            println(d.hasTestB())
            // true

            println(JsonFormat.printer().print(d))
            /*
            {
              "testB": { "id": 1, "idB": 2 },
              "id": 123
            }
             */
        }

        run {
            val b = personR {
                name = "aa"
                id = 123
                emails += classC {
                    testA = classA {
                        id = 1
                        idA = 2
                    }
                }
                emails += classC {
                    testB = classB {
                        id = 1
                        idB = 2
                    }
                }
            }

            println(JsonFormat.printer().print(b))
            /*
            {
              "name": "aa",
              "id": 123,
              "emails": [{ "testA": { "id": 1, "idA": 2 } }, { "testB": { "id": 1, "idB": 2 } }]
            }
             */
        }
    }
}
