package ex5_lambda

fun topFunc() = println("what?")

data class Person(val name: String, val age: Int)

fun main() {
    val people = listOf(Person("shin", 30), Person("park", 20), Person("lee", 15))

    println(people.maxBy({ p: Person -> p.age }))   // 람다의 정식 형태
    println(people.maxBy() {p: Person -> p.age})    // 1. 코틀린에는 람다 호출시 맨 뒤에 있는 인자가 람다 식이라면 그 람다를 괄호 밖으로 뺄 수 있다.
    println(people.maxBy {p: Person -> p.age})      // 2. 람다가 어떤 함수의 유일한 인자이고, 괄호뒤에 람다를 썼다면 호출시 괄호를 없애도 된다.
    println(people.maxBy {p -> p.age})              // 3. 파라미터 타입 생략 가능 컴파일러가 파라미터 타입을 추론할 수 있다.
    println(people.maxBy{it.age})                   // 4. 람다의 파라미터 이름을 디폴트 이름인 it 로 변경 => 람다의 파라미터가 하나뿐이고 그 타입을 컴파일러가 추론할 수 있는 경우 it를 바로 쓸 수 있다.
    println(people.maxBy(Person::age))      // 멤버 참조로 쓸 수 도 있다.

    val maxByAge = { p: Person -> p.age }   // 람다는 변수에 저장이 가능하다.
    println(people.maxBy(maxByAge))
    // 출력 결과 : Person(name=shin, age=30)

    run(::topFunc)  // 최상위 함수 참조(::topFunc). run은 인자로 받은 람다 실행해주는 메소드

    println(people.filter{it.age>20}.map{it.name})  // filter와 map 사용
}