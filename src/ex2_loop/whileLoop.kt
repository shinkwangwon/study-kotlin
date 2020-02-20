package ex2_loop


fun loop(n: Int) {
    var idx = n // 파라미터로 받은 n은 immutable

    // kotlin의 while, do-while 문은 java와 동일
    while(idx > 0) {
        println(idx--)
    }
}

fun main() {
    loop(3)
}