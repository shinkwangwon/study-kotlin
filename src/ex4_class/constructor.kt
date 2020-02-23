package ex4_class

// 파라미터가 1개인 주 생성자 constructor(_nickName: String)
// 1. 주 생성자앞에 별다른 애노테이션이나 접근제어자가 없다면 constructor 키워드 생략가능
class User1 constructor(_nickName: String) {
    val nickName: String    // 2. 여기서 nickName 프로퍼티를 바로 초기화할 수 있으므로 초기화블럭이 필요 없음
    init {  // 초기화 블럭
        nickName = _nickName
    }
}

// User1 에서 1,2번에 해당하는 이유로 심플화가 가능
class User2(_nickName: String) {    // 3. 주 생성자의 파라미터로 프로퍼티를 초기화하는 것 뿐이라면 주 생성자 파라미터 앞에 val 키워드를 추가하고, 프로퍼티명으로 파라미터터 명을 변경하면 자동으로 초기화 시켜줌
    val nickName = _nickName
}

// User2에서 3번에 해당하는 이유로 심플화 가능
class User3(val nickName: String)

fun main() {
    val user1 = User1("shin")
    val user2 = User2("kwang")
    val user3 = User3("won")

    println("${user1.nickName} : ${user2.nickName} : ${user3.nickName}")
    // shin : kwang : won
}