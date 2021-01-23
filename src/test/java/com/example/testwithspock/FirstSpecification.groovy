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
}
