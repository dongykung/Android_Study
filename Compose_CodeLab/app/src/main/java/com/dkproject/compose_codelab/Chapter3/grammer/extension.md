## 새 속성 및 메서드로 클래스 확장
Kotlin 언어의 기능을 통해 다른 개발자는 기존 데이터 유형을 확장하여 해당 데이터 유형의 일부인 것처럼 점 문법으로 액세스할 수 있는
속성과 메서드를 추가할 수 있습니다.

```kotlin
val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered"
fun main() {
    println(Quiz.progressText)
}
// 3 of 10 answered.

fun Int.toMakeString(): String {
    return this.toString()
}
```