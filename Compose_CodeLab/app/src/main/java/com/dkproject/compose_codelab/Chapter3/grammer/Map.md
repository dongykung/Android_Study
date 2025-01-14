## 맵 
`Map`은 키와 값으로 구성된 컬렉션입니다.
고유 키가 다른 값에 매핑되므로 맵이라고 함. 키와 그에 수반되는 값을 key-value pair 라고도 함.

맵의 키는 고유합니다. 하지만 맵의 값은 그렇지 않습니다.
다른 두 키가 동일한 값에 매핑될 수 있습니다.

맵에서 키로 값에 액세스하는 것이 일반적으로 `indexOf`를 사용하는 등 큰 목록을 검색하는 것보다 더 빠릅니다.

### 맵은 mapOf 또는 mutableMapOf 함수를 사용하여 선언
```kotlin
val solarSystem = mutableMapOf(
    "Mercury" to 0,
    "Venus" to 0,
    "Earth" to 1,
    "Mars" to 2,
    "Jupiter" to 79,
    "Saturn" to 82,
    "Uranus" to 27,
    "Neptune" to 14
)
solarSystem["Pluto"] = 5
```