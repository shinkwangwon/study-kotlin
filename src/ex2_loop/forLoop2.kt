package ex2_loop

import java.util.*

fun main() {
    val binaryReps = TreeMap<Char, String>()
    for(c in 'A'..'D') {    // 문자에 대한 반복
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary  // 자바에서 binaryReps.put(c, binary) 와 동일
    }
    for((letter, binary) in binaryReps) {   // key & value 이터레이션
        println("$letter : $binary")
    }
}

// in과 !in은 조건검사용으로도 쓰일 수 있음
fun isDigit(c: Char) = when(c) {
    in '0'..'9' -> "True!!"
    in 'a'..'z', in 'A'..'Z' -> "False!!"
    else -> "don't know"
}

fun isNotDigit(c: Char) = if(c !in '0'..'9') "True" else "false"