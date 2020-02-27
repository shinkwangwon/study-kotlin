package ex8_high_order_function

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val logs = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 10.0, OS.LINUX),
    SiteVisit("/login", 22.0, OS.MAC),
    SiteVisit("/signup", 13.0, OS.IOS),
    SiteVisit("/", 15.0, OS.ANDROID)
)

// 1. 하드코딩으로 모바일의 평균 접속 시간 계산
val averageMobileDuration = logs
    .filter{ it.os in setOf(OS.IOS, OS.ANDROID)}
    .map(SiteVisit::duration)
    .average()


// 2. 확장함수와 고차함수를 이용하여 특정 기기의 평균 접속시간 계산
// List<SiteVisit> : 수신객체 타입
// averageDurationFor : 확장 함수
// predicate: (SiteVisit) -> Boolean : 함수타입으로 된 파라미터 ==> predicate:파라미터이름, (SiteVisit): 함수타입의 파라미터타입, Boolean: 함수타입의 반환타입
fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) = filter(predicate).map(SiteVisit::duration).average()

fun main() {
    println(averageMobileDuration)
    println(logs.averageDurationFor { it.os in setOf(OS.IOS, OS.ANDROID) }) // 람다를 파라미터로 던짐
}
