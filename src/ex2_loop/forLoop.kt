package ex2_loop

import java.util.*


// 코틀린에는 자바의 for루프 처럼 어떤 변수를 초기화하고 그 변수를 루프를 한번 실행할때마다 갱신하고 루프조건이 거짓이 될 때 반복을 마치는 형태의 루프가 없다
// 즉 초기값, 증가값, 최종값을 사용한 루프가 없다
// 코틀린에서는 범위(range)를 사용

fun main() {
    for(i in 1..5) {    // range(..) 을 사용하면 끝수(여기선 5)를 포함
        // 띄어쓰기 문자 포함하기 위해 문자열리터럴($) 사용
        print("$i ")    // result : 1 2 3 4 5
    }
    println()

    for(i in 10 downTo 1 step 2) {  // 10에서 1까지 2씩 감소 시킴
        print("$i ")    // result : 10 8 6 4 2
    }
}