package ex6_type_system


// 어떤 타입이든 타입 이름뒤에 물음표를 붙이면 그 타입의 변수나 프로퍼티에 null 참조를 저장할 수 있다는 뜻이다.
// 널이 될 수 있는 값을 널이 될수없는 타입의 변수에 대입할 수 없다
// 널이 될수있는 타입의 값을 널이 될수 없는 타입의 파라미터를 받는 함수에 전달할 수 없다.

// null이 될 수 있으면 null에 대한 처리를 해줘야 컴파일 에러가 안남
fun strLen(s: String?): Int = if(s != null) s.length else 0

// [?.] 안전한 호출 연산자 ==>> s가 null이 아니면 length 리턴. s가 null이면 null 리턴
// null을 리턴할 수 있기 때문에 함수의 반환타입을 Int? 로 지정해야한다. (Int or Null)
fun strLen2(s: String?): Int? = s?.length

// [?:] 엘비스(Elvis)연산자 ==>> null 대신 default값 사용 가능 ==> ?: 를 기준으로 좌항이 null이 아니면 좌항 리턴. 좌항이 null이면 우항 리턴
// s가 null이 아니면 length반환(?.) ==> s가 널이면 ?. 연산자가 null을 반환하게 되고, 그 결과 ?: 로 인해 0이 리턴된다
fun strLen3(s: String?): Int = s?.length ?: 0

fun main() {
    println(strLen(null))   // 0
    println(strLen2("abc")) // 3
    println(strLen2(null))  // null
    println(strLen3(null))  // 0


    // let 키워드는 수신객체가 null이 아니면 let뒤에오는 람다를 수행함
    // 수신객체가 null이면 람다 수행안하고 끝나버림
    val foo: String? = null
    foo?.let { println("foo는 null이 아니다") }

    // 람다 안에서 this를 사용할 경우에는 let은 this가 널인지 체크해주지 않는다. 따라서 람다 안에서 NullPointerException이 발생할 수 있다.
    // 그러므로 람다 전에 안전한 호출 연산인 ?. 을 사용하자 ==> foo. (X) //  foo?. (O)
    foo.let { println("오잉") }
}