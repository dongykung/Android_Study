## list 목록
목록은 순서가 지정되고 크기 조절이 가능한 컬렉션으로, 일반적으로 크기 조절 가능한 배열로 구현됩니다.
배열이 용량까지 채워졌는데 새 요소를 삽입하려고 하면 배열이 더 큰 새 배열에 복사됩니다.

목록을 사용하면 특정 색인의 다른 요소 사이에 새 요소를 삽입할 수도 있습니다.

### List 및 MutableList
- List는 순서가 지정된 읽기 전용 항목 컬렉션과 관련된 속성과 메서드를 정의하는 인터페이스 입니다.
- MutableList는 요소 추가 및 삭제와 같이 목록을 수정하는 메서드를 정의하여 `List` 인터페이스를 확장합니다.

이러한 인터페이스는 `List` 또는 `MutableList`의 속성과 메서드만 지정합니다. 각 속성과 메서드의 구현 방법을 결정하는 것은 이를 확장하는 클래스 입니다.
```kotlin
fun main() {
    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem[2])
    println(solarSystem.get(3))

    //Earth
    //Mars

    println(solarSystem.indexOf("Earth"))
    println(solarSystem.indexOf("Pluto"))
    /*
    2
    - 1
     */

    for (planet in solarSystem) {
        println(planet)
    }

    val solarSystem2 = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystem2.add("Pluto")
    solarSystem2.add(3, "Theia")

    solarSystem2.removeAt(9)
    solarSystem2.remove("Future Moon")



}
```