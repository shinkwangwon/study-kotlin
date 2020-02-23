package ex3_collection

// 코틀린 컬렉션은 자바 컬렉션과 똑같은 클래스다.
// 코틀린에서의 collection은 자바의 collection을 사용한다. 즉, 자바 collection의 기능을 kotlin에서도 그대로 사용할 수 있다.
// 코틀린이 자체 컬렉션을 제공하지 않는 이유는 표준 자바 컬렉션을 활용하면 자바 코드와 상호작용하기 훨씬 더 쉽기 때문이다.
// 하지만 코틀린에서는 자바 보다 더 많은 기능을 쓸 수 있다. 예를들어 리스트의 마지막 원소를 가져오거나, 숫자로 이루어진 컬렉션의 최대값을 찾을 수 있다.
fun main() {
    val setCol = hashSetOf(1, 7, 53)
    println(setCol) // [1, 53, 7] -> 자바의 set과 마찬가지로 순서를 보장하지 않음
    // 자바의 getClass() 와 동일한 메소드
    println(setCol.javaClass)   // class java.util.HashSet
    println(setCol.max())   // 53

    val listCol = arrayListOf(1, 7, 53)
    println(listCol)    // [1, 7, 53]
    println(listCol.javaClass)  // class java.util.ArrayList
    println(listCol.last()) // 53 - 코틀린 컬렉션의 기능
    println(listCol.max())  // 53 - 코틀린 컬렉션의 기능

    // to 는 언어가 제공하는 특별한 키워드가 아니라 일반 함수임
    val mapCol = hashMapOf(1 to "one", 7 to "seven")
    println(mapCol) // {1=one, 7=seven}
    println(mapCol.javaClass)   // class java.util.HashMap
}