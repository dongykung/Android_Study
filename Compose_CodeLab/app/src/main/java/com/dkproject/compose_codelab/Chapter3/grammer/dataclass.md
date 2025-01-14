## data class
클래스를 데이터 클래스로 정의하면 코틀린 컴파일러에서 특정 가정을 하고 일부 메서드를 자동으로 구현할 수 있습니다.
예를 들어 `toString()`은 `println` 함수에 의해 내부적으로 호출됩니다.
데이터 클래스를 사용하면 `toString()` 및 기타 메서드가 클래스의 속성에 따라 자동으로 구현됩니다.

```kotlin
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

```