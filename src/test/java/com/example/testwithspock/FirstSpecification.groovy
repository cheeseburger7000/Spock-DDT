package com.example.testwithspock

import spock.lang.Specification
import spock.lang.Unroll

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

    // Data Driven Testing
    // http://spockframework.org/spock/docs/1.0/data_driven_testing.html
    @Unroll
    def "should expect an Exception to be thrown for invalid input: #sides"() {
        when:
        new Polygon(sides)

        then:
        def exception = thrown(TooFewSidesException)
        exception.numberOfSides == sides

        where:
        sides << [-99, 3, 1, 2]
    }

    @Unroll
    def "should be able to create a polygon with #sides sides"() {
        expect:
        new Polygon(sides).numberOfSides == sides

        where:
        sides << [3, 4, 5, -99, 14]
    }

    @Unroll
    def "should use data tables for calculating max. Max of #a and #b is #max"() {
        expect:
        Math.max(a, b) == max

        where:
        a | b || max
        1 | 3 || 3
        7 | 4 || 7
        0 | 0 || 4
    }
}
