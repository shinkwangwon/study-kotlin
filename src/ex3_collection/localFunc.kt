package ex3_collection


class User(val id: Int, val name: String, val addr: String)

fun User.validate() {
    fun isNotValid(value: String, filed: String) {
        if(value.isEmpty()) {
            throw IllegalArgumentException("empty $filed")
        }
    }

    println("$id : $name : $addr")
    isNotValid(name, "Name")
    isNotValid(addr, "Address")
    println("검증 성공")
}

fun saveUser(user: User) {
    // 검증 후 DB에 저장
    user.validate()
}

fun main() {
    val user = User(1, "shin", "신림")
    saveUser(user)
}