import com.example.testwithspock.Palette
import com.example.testwithspock.Polygon
import com.example.testwithspock.Renderer
import com.example.testwithspock.ShareFactory
import org.mockito.Mock
import spock.lang.Specification
import spock.lang.Subject

import java.awt.Color


// Surround with: Opt + CMD + T or Ctrl + Alt + T
// 实时模版 fori
// 实用快捷键
// 1.快速提示: Opt + Enter
// 2.光标上/下一个位置: Opt + CMD + 左右
class MockSpecification extends Specification {
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
        given:
        def renderer = Mock(Renderer)
        def shapeFactory = new ShareFactory(renderer)

        when:
        def polygen = shapeFactory.createDefaultPolygon()

        then:
        with(polygen) {
            numberOfSides == 5 // 如果这里失败了，下面的验证就不会继续执行
            renderer == renderer
        }
    }

    // alternative approach to testing multiple properties of a single object
    def "should demonstrate verifyAll"() {
        // todo
    }

    // Move Statement Down: CMD + SHIFT + 下 or Ctrl + Shift + 下
    void cleanup() {
        // code that tears down things at the end of a test method
    }
    void cleanupSpec() {
        // code that tears down things at the end of all tests have runn
    }
}