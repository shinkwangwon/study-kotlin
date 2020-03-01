package ex11_dsl



fun main() {
    val map = mutableMapOf(1 to "one")

    /* apply 함수
    public inline fun <T> T.apply(block: T.() -> Unit): T {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        block() // this.block()와 같음 -> apply의 수신객체를 수신객체로 지정해 람다(block())를 호출한다
        return this //  this를 리턴함 
    }
    */
    // apply 메소드는 수신객체타입에 대한 확장함수로 선언됐기 때문에 수신 객체의 메소드처럼 호출할 수 있고, 수신객체를 다시 반환함
    map.apply { this[2] = "two"}


    /* with 함수
    public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        return receiver.block() // 람다를 호출(block())해 얻은 결과를 반환함
    }
    */
    // with는 람다를 호출해 얻은 결과를 반환 한다. apply와 with 모두 수신 객체를 묵시적 인자(this)로 받는다
    with(map) { this[3] = "three" }
    println(map)    // {1=one, 2=two, 3=three}
}