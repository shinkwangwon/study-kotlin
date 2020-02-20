package ex2_loop

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException


// 코틀린에서는 체크예외와 언체크예외를 구별하지 않는다.
// 코틀린에서는 함수가 던지는 예외를 지정하지 않고 발생한 예외를 잡아내도 되고 잡아내지 않아도 된다. (자바는 체크예외 처리를 강제함)
// 대부분 자바에서 체크예외를 잡아봤자 의미만 변경된 예외를 다시 던지거나 무시하도록 코딩하는 버릇이 있어 이를 고려해 설계했다고 함
// 코틀린의 try 키워드는 if나 when 처럼 "문(Statement)"이 아닌 "식(Expression)"이다. 따라서 try의 값을 변수에 대입할 수 있다.

// 자바와 달리 메소드에 throws ~~Exception 처럼 메소드가 던질 수 있는 예외를 명시할 필요가 없다
fun readNumber(reader: BufferedReader): Int? {  // "?"가 붙어 있으니 return값이 nullable 이다.
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }
    catch (e: NumberFormatException) {  // 예외 타입을 콜론(:) 옆에 명시
        return null
    }
    finally {
        reader.close()  // 여기서 IOException이 발생할 수 있기 때문에 자바였다면 메소드선언부에 throws IOException을 명시해줬어야 함
    }
}

fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine()) // try의 마지막 식의 값이 결과 값 (if,when도 마찬가지)
    }
    catch (e: NumberFormatException) {  // 예외 타입을 콜론(:) 옆에 명시
        // return  // 이렇게 return만 해버리면 아래 println(number)에서 아무것도 출력하지 않음
        null    // 문제가 발생하면 null을 리턴하도록 했음
    }
    println(number)
}
fun main() {
    val reader = BufferedReader(StringReader("123"))
    println(readNumber(reader))

    val reader2 = BufferedReader(StringReader("abc"))   // 숫자가 아닌 문자들을 넘김 -> NumberFormatException 발생
    readNumber2(reader2)
}

