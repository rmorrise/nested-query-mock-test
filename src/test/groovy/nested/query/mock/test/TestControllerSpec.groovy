package nested.query.mock.test

import grails.plugin.json.view.JsonViewGrailsPlugin
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import nested.query.mock.Child
import nested.query.mock.Grandchild
import nested.query.mock.Parent
import spock.lang.Specification

/**
 * Created by rmorrise on 4/18/2017.
 */
@TestFor(TestController)
@Mock([Parent, Child, Grandchild])
class TestControllerSpec extends Specification {
    //this makes JSON formatting work in the test environment
    def doWithSpring = new JsonViewGrailsPlugin().doWithSpring()

    void setup() {
        def parent = new Parent(parentCode: 'P1')
        parent.id = 1
        parent.save(flush: true, failOnError: true)

        def child = new Child(code: 'C1', parent: parent)
        child.id = 2
        child.save(flush: true, failOnError: true)

        def grandChild = new Grandchild(grandChildCode: 'G1', child: child)
        grandChild.id = 3
        grandChild.save(flush: true, failOnError: true)
    }

    void "index"() {
        when:
        controller.response.format = 'json'
        controller.index()

        then:
        response.status == 200
        response.json.size() == 1
        response.json[0].grandChildCode.toString() == "G1"
    }
}
