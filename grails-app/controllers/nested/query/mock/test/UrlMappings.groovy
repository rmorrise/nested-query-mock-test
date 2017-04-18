package nested.query.mock.test

class UrlMappings {

    static mappings = {
        "/"(controller: 'test', action: 'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
