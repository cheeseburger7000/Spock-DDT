package com.example.testwithspock

import spock.lang.Specification

class FirstSpecification extends Specification {
    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    // Using CMD + N to generate a Test Method
    // Using CMD + N to add new file in project navbar.
    def "should demonstrate given-when-then"() {
        given:
        def students = new ArrayList()

        when:
        students.add("Luca")
        students.add("Allen")
        students.add("Bruce")

        then:
        students.size() == 3
    }

    // Groovy Tips for Java Developers:
    // If we're calling a java getter from groovy code
    // we can miss out the get at the start of the method name
    // and groovy will still use the getter rather then the field.
    //
    // Install Plugin for Spock

    def "should expect exceptions"() {
        when:
        1/0

        then:
        def ex = thrown(ArithmeticException)
        ex.message == 'Division by zero'
//        ex.message == 'Division by zer'
//        thrown(ArrayIndexOutOfBoundsException)
    }
}
