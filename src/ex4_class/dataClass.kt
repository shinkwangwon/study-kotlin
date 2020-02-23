package ex4_class


// data class는 equals, hashCode, toString 을 자동으로 만들어준다.
// equals는 주 생성자에 나열된 모든 프로퍼티의 값을 비교해준다.
// hashCode는 주 생성자에 나열된 모든 프로퍼티의 해시 값을 바탕으로 계산한 해시 값을 반환한다.
// 이때 주 생성자 밖에 정의 된 프로퍼티는 equals 나 hashCode를 계산할때 고려의 대상이 아니라는 사실에 유의하자!
data class Client(val name: String, val age: Int)

fun main() {
    val c1 = Client("shin", 30)
    val c2 = Client("shin", 30)
    println(c1.toString())  // Client(name=shin, age=30)
    println(c1.hashCode())  // true
    println(c2.hashCode())  // true
    println(c1 == c2)       // true
    println(c1.equals(c2))  // true
    println(c1) // Client(name=shin, age=30)
    println(c2) // Client(name=shin, age=30)
}