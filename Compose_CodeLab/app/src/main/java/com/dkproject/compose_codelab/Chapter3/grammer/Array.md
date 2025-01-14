## 배열
프로그래매에서 임의의 수의 값을 그룹화하는 가장 간단한 방법

- 색인을 통해 배열 요소에 빠르게 액세스할 수 있습니다.
- 배열의 크기는 고정되어 있습니다. 즉, 이 크기를 초과하여 배열에 요소를 추가할 수는 없습니다.

코드에서 배열을 선언하려면 `arrayOf()` 함수를 사용하세요

```kotlin
val rockPlanets = arrayOf("Mercury", "Venus", "Earth", "Mars")
val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")

val solarSystem = rockPlanets + gasPlanets
```