import com.example.testwithspock.Palette
import com.example.testwithspock.Polygon
import com.example.testwithspock.Renderer
import com.example.testwithspock.ShareFactory
import org.mockito.Mock
import spock.lang.Specification
import spock.lang.Subject

import java.awt.Color

/* 
Spock Cheatsheets
1. hello world
2. given-when-then
3. expect = when + then
4. exception
5. ddt and where label 1) data pipeline 2) datatables
6. mock
7. stub
8. helper methods
9. with verifyAll
10. setupSpec setup cleanup cleanupSpec
*/
class MockSpecification extends Specification {
//    @Subject
//    Polygon polygon = new Polygon(4)

    void setupSpec() {
        // setup code that needs to be run once at the start
    }
    void setup() {
        // setup code that needs to be run before every test method
    }

    def "should be able to mock a concrete class"() {
        given:
//        Renderer renderer = Mock() // for java developer
        def renderer = Mock(Renderer)
        @Subject
        def polygon = new Polygon(4, renderer)

        when:
        polygon.draw()

        then:
        4 * renderer.drawLine()
    }

    def "should be able to create a stub"() {
        given:
        Palette palette = Stub()
        palette.getPrimaryColor() >> Color.RED
        @Subject
        def renderer = new Renderer(palette)

        expect:
        renderer.getForegroundColour() == Color.RED
    }

    def "helper methods"() {
        given:
        def renderer = Mock(Renderer)
        def shapeFactory = new ShareFactory(renderer)

        when:
        def polygen = shapeFactory.createDefaultPolygon()

        then:
        checkDefaultPolygon(polygen, renderer)
    }

    private static void checkDefaultPolygon(Polygon polygen, Renderer renderer) {
        assert polygen.numberOfSides == 4
        assert polygen.renderer == renderer
    }

    def "use with() to testing multiple properties of a single object"() {
        given: "doc"
        def renderer = Mock(Renderer)
        and: "use and label to add doc and split code"
        def shapeFactory = new ShareFactory(renderer)

        when:
        def polygen = shapeFactory.createDefaultPolygon()

        then:
        with(polygen) {
            numberOfSides == 5 // 如果这里失败了，下面的验证就不会继续执行
            renderer == renderer
        }
    }

    // alternative approach to testing multiple properties of a single object, see alse with()
    def "should demonstrate verifyAll"() {
        // todo
    }

    void cleanup() {
        // code that tears down things at the end of a test method
    }
    void cleanupSpec() {
        // code that tears down things at the end of all tests have run
    }
}
