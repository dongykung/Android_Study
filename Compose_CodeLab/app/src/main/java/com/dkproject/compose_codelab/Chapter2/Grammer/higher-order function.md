함수가 함수를 반환하거나 또는 함수를 인수로 취하는 경우 고차함수라고 합니다.

```kotlin
fun main() {
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
    repeat(4) {

    }
}
```