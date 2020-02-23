package ex4_class


class User(val name: String) {
    var address: String = "unspecified"
    set(value: String) {
        println("""Address was changed for $name:
            "$field" -> "$value".""".trimIndent())
        field = value
    }
}

fun main() {
    val user = User("alice")
    user.address = "ffffff"
}