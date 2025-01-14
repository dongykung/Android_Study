## 싱글톤 객체 사용
개발자가 클래스에 인스턴스가 하나만 포함되기를 바라는 시나리오가 많이 있습니다.

객체를 싱글톤으로 정의하여 객체에는 인스턴스가 하나만 있어야 함을 코드에서 명확하게 전달할 수 있습니다.
싱글톤은 인스턴스를 하나만 가질 수 있는 클래스 입니다.
코틀린은 싱글톤 클래스를 만드는데 사용할 수 있는 객체라는 특수 구조를 제공합니다.

`object`키워드를 사용하면 됩니다. 
싱글톤 객체에는 생성자를 포함할 수 없습니다.
개발자가 인스턴스를 직접 만들 수 없기 때문입니다.
대신 모든 속성이 중괄호 안에 정의되며 초깃값이 부여됩니다,

```kotlin
object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}
```

싱글톤 객체의 인스턴스를 직접 만들 수 없다는 것을 기억하시나요?  그렇다면 그 속성에 어덯게 엑세스 할가요?
한 번에 인스턴스가 하나만 있으므로 객체 자체의 이름, 점 연산자, 속성 이름을 차례로 참조하여 속성에 엑세스 합니다.
```kotlin
StudentProgress.totl
```

---

## 객체를 컴패니언(companion) 객체로 선언
Kotlin의 클래스와 객체는 다른 유형 내에서 정의할 수 있고 코드를 구성하는 좋은 방법이 될 수 있습니다.
컴패니언 객체를 사용하여 다른 클래스 내에서 싱글톤 객체를 정의할 수 있습니다.
컴패니언 객체를 사용하면 클래스 내에서 속성과 메서드에 액세스할 수 있으므로(객체의 속성과 메서드가 해당 클래스에 속한 경우)문법이 더 간결해집니다.

컴패니언 객체를 선언하려면 object 키워드 앞에 `companion` 키워드를 추가하기만 하면 됩니다.

```kotlin
class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

   companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}
fun main() {
    println("${Quiz.answered} of ${Quiz.total} answered.")
}
```