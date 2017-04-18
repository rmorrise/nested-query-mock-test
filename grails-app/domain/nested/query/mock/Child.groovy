package nested.query.mock

class Child {
    String code

    static belongsTo = [parent: Parent]

    static constraints = {
    }
}
