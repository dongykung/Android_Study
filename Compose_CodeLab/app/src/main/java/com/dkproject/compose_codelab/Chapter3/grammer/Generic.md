## 제네릭을 사용하여 재사용 가능한 클래스 만들기
클래스와 같은 데이터 유형이 속성 및 메서드와 함께 사용할 수 있는 알 수 없는 자리표시자 데이터 유형을 지정하도록 합니다.

```kotlin  
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")
}
```