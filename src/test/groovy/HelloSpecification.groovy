import spock.lang.Specification

class HelloSpecification extends Specification {
    def "two plus two should equals four"() {
        given:
        int left = 2
        int right = 2

        when:
        int result = left + right

        then:
        result == 4
    }

    def "should be able to remove from list"() {
        given:
        def lst = [1, 2, 3, 4]

        when:
        lst.remove(0)

        then:
//        lst == [2, 3, 4] // pass
        lst == [1, 3, 4] // fail
    }

    def "should get an index out of bounds when removing a non-existent item"() {
        given:
        def lst = [1, 23]

        when:
        lst.remove(20)

        then:
        thrown(IndexOutOfBoundsException)
        lst.size() == 2
    }
}