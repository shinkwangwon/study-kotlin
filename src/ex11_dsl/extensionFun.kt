package ex11_dsl


// 파라미터로 일반람다를 받는 함수
fun buildString_일반람다(builderAction: (StringBuilder) -> Unit) : String {
    val sb = StringBuilder()
    builderAction(sb)   // 람다 인자로 StringBuilder 인스턴스를 넘긴다
    return sb.toString()
}


// 수신객체 지정람다를 파라미터로 받는 함수
// 확장함수 타입을 사용 StringBuilder.() -> Unit  => StringBuilder이 수신객체 타입이고 거기에 대응하는 확장함수타입을 정의.
// 즉, 수신객체타입이 StringBuilder이고 파라미터가 없으며 Unit타입을 리턴하는 확장함수타입을 정의함
fun buildString_수신객체지정람다(builderAction: StringBuilder.() -> Unit) : String {
    val sb = StringBuilder()
    sb.builderAction()  // StringBuilder 인스턴스를 람다의 수신객체로 넘긴다
    return sb.toString()
}

// 확장함수 정의 => 위의 buildString_수신객체지정람다 함수의 파라미터와 동일한 형태임
val appendString : StringBuilder.() -> Unit = { this.append("확장함수!!") }


fun main() {
    val s1 = buildString_일반람다 {
        it.append("Hello,") // 일반람다를 받는 파라미터인 함수에 람다를 전달할 때는 매번 it를 사용해 StringBuilder 인스턴스를 참조해야 한다.
        it.append("일반람다")
    }
    println(s1) // Hello,일반람다

    val s2 = buildString_수신객체지정람다 {
        this.append("Hello,")   // this 는 StringBuilder 인스턴스를 가리킨다
        append("수신객체지정람다") //  this는 생략가능 하다
    }
    println(s2)

    val s3 = StringBuilder("hello~~ ")
    s3.appendString()   // 확장함수 호출
    println(s3) // hello~~ 확장함수!!
    println(buildString_수신객체지정람다(appendString)) // 확장함수!! ==> 이렇게 buildString_수신객체지정람다 함수가 확장함수타입을 파라미터로 받기 때문에 확장함수를 인자로 전달할 수 있음

}