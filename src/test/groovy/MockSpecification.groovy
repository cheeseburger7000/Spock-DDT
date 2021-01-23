import com.example.testwithspock.Polygon
import com.example.testwithspock.Renderer
import spock.lang.Specification
import spock.lang.Subject


// Surround with: Opt + CMD + T or Ctrl + Alt + T
// 实时模版 fori
class MockSpecification extends Specification {
    def "should be able to mock a concrete class"() {
        given:
        Renderer renderer = Mock()
        @Subject
        def polygon = new Polygon(4, renderer)

        when:
        polygon.draw()

        then:
        4 * renderer.drawLine()
    }
}