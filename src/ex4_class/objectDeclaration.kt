package ex4_class


// data class 생성
data class Person(val name: String) {

    // data class 안에 객체 선언 => Person 클래스 인스턴스가 여러개 만들어져도 NameComparator객체는 하나만 만들어짐
    // Person이라는 클래스에 대한 Comparator를 구현한 것이기 때문에 Person클래스 내부에 정의하는게 바람직하다.
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person) : Int {
            return p1.name.compareTo(p2.name)
        }
    }
}

fun main() {
    val persons = listOf(Person("shin"), Person("park"), Person("lee"))
    println(persons.sortedWith(Person.NameComparator))
    // [Person(name=lee), Person(name=park), Person(name=shin)]

    val p1 = Person("kwang")
    val p2 = Person("won")
    val p3 = Person("won")
    println(Person.NameComparator.compare(p1, p2))  // 음수
    println(Person.NameComparator.compare(p2, p1))  // 양수
    println(Person.NameComparator.compare(p2, p3))  // 0
}