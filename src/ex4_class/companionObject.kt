package ex4_class


data class Person2 private constructor(val name: String) {
    companion object {
        fun newPerson(name: String) = Person2(name)
    }
}

fun main() {
    val p1 = Person2.newPerson("shin")
    println(p1)

    // val p2 = Person2("kwang") // 에러 => 주 생성자를 비공개키로 만들었기 때문
}