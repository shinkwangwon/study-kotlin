package ex2_contidion

import java.lang.Exception

interface Number  // 인터페이스 생성
class OneNum(val value: Int) : Number   // 파라미터가 Int타입 1개, 반환형이 Number인터페이스 타입인 클래스
class SumNum(val num1: Number, val num2: Number) : Number // 파라미터가 Number타입 2개, 반환형이 Number인터페이스 타입

// kotlin에서 if, when은 "문(Statement)"이 아니라 "식(Expression)"이다
// 식은 값을 만들어 내며 다른 식의 하위요소로 계산에 참여할 수 있는 반면 문은 자신을 둘러싸고 있는 가장 안쪽 블록의 최상위 요소로 존재하며 아무런 값을 만들어내지 않는다.
fun calculate(num: Number) : Int =  // when은 "식"이기 때문에 "="로 함수 정의 가능
    when(num) {
        // is 검사는 자바의 instanceof 검사와 비슷함 => 자바에서는 instanceof검사 후 직접 캐스팅을 한 후에 사용했음. 코틀린은 추가적으로 타입검사뿐만 아니라 캐스팅까지 한번에 진행
        // 즉 num이라는 변수가 OneNum 타입인지 검사하고 맞다면 num을 OneSum 타입으로 자동 캐스팅 해줌 => 스마트 캐스트라고 함
        is OneNum -> num.value  // num 파라미터가 OneNum 타입이면 value 리턴

        is SumNum -> {
            calculate(num.num1) + calculate(num.num2)   // num 파라미터가 SumNum 타입이면 calculate 다시 호출해서 value값 받아서 더한값 리턴
        }

        else -> throw Exception()   // 둘다 아니면 에러
    }

fun main() {
    println(calculate(SumNum(OneNum(1), OneNum(2))))
}