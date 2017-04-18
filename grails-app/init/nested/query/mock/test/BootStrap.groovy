package nested.query.mock.test

import nested.query.mock.Child
import nested.query.mock.Grandchild
import nested.query.mock.Parent

class BootStrap {

    def init = { servletContext ->
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
    def destroy = {
    }
}
