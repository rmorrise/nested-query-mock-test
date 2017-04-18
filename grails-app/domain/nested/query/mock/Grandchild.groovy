package nested.query.mock

class Grandchild {
    String grandChildCode

    static belongsTo = [child: Child]

    static constraints = {
    }
}
