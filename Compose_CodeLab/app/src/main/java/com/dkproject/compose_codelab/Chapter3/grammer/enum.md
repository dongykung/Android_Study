## enum 클래스 사용
가능한 값 집합이 제한되어 있는 유형을 만드는데 사용됩니다.

```kotlin
enum class Difficulty {
    EASY, MEDIUM, HARD
}
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
```