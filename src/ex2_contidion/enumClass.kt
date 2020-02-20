package ex2_contidion

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0 ,0),
    GREEN(0, 255, 0),
    BLUE(0,0,255);  // enum 클래스 안에 메소드를 정의하는 경우 반드시 enum 상수목록과 메소드 정의 사이에 세미콜론을 넣어주어야 함
    
    fun rgb() = (r * 256 + g) * 256 + b
}

fun main() {
    println(Color.BLUE.rgb())
}