package ex3_collection

// Collection<T>에 대한 확장함수 joinToString 정의
// 확장 함수가 정적 메소드와 같은 특징을 가지므로, 확장 함수를 하위 클래스에서 오버라이드 할 수는 없다.
fun <T> Collection<T>.joinToString(
    separator: String=", ",
    prefix: String = "",    // default 값 공백
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for((index, element) in this.withIndex()){   // this 생략 가능. collection의 withIndex 내장함수 사용
        if(index > 0) {
            result.append(separator)
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val list = listOf( 1,2,3)
    println(list.joinToString(";"))
}

