## set
세트는 특정 순서가 없고 중복 값을 허용하지 않는 컬렉션 입니다.

이와 같은 컬렉션이 가능한 이유는 바로 `해시코드` 입니다.
해시 코드는 Kotlin 클래스의 hasCode() 메서드에서 생성된 Int 입니다.
Kotlin 객체의 반고유 식별자로 생각할 수 있습니다. 객체를 약간만 변경해도 해시 값은 크게 달라집니다.
두 객체가 동일한 해시 코드를 가질 수 있지만(해시 충돌) `hasCode` 함수를 사용하면 다른 두 값이 대부분 각각 고유한 해시 코드를 가지는 일정 수준의 고유성이 보장됨

### Set 및 MutableSet

```kotlin
val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
solarSystem.add("Pluto")
solarSystem.remove("Pluto")

```