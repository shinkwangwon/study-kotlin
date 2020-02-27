package ex8_high_order_function


class Person(val name: String)

// forEach에 람다대신 무명함수를 사용
fun lookForAliceWithNonNameFunc(people: List<Person>) {
    people.forEach(fun(person) {
        if(person.name == "shin") return    // 여기서는 forEach가 반환된다.
    })
    println("lookForAliceWithNonNameFunc : forEach 만 반환")   // forEach에서 return되고 여기에 도달함
}

// forEach 는 inline함수로 정의되어 있고, 함수를 파라미터로 받기 때문에 람다를 인자로 받을 수 있다
// inline함수이면서 람다를 인자로 받는 경우 return이 바깥쪽 함수를 반환시킬 수 있다.
fun lookForAliceWithLambda(people: List<Person>) {
    people.forEach {
        if(it.name == "shin") return    // 여기서 return한 경우는, forEach 를 종료하는게 아니라 lookForAliceWithLambda 함수가 반환된다.
    }
    println("lookForAliceWithLambda : forEach 만 반환")    // forEach의 return문으로 함수가 반환되기 때문에 여기에 도달하지 못함
}

fun main() {
    lookForAliceWithNonNameFunc(listOf(Person("shin")))
    lookForAliceWithLambda(listOf(Person("shin")))
}