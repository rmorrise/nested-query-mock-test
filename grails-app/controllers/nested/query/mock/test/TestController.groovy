package nested.query.mock.test

import nested.query.mock.Grandchild

class TestController {
    static responseFormats = ['json']

    def index() {
        def resultList = Grandchild.where {
            child {
                eq('code', 'C1')
                parent {
                    eq('parentCode', 'P1')
                }
            }
        }.list(params)
        respond resultList
    }
}
