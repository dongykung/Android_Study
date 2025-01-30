## withContext
withContext로 async-await 대체하기

withContext 함수를 사용하면 async-await 작업을 대체할 수 있다

```kotlin
public suspend fun <T> withContext(
    context: CoroutineContext,
    block: suspend CoroutineScope.() -> T
): T {}
```
- async-await 쌍을 withContext 함수로 대체할 수 있음

async - await 쌍이 withContext 함수로 대체되면 중간에 Deferred 객체가 생성되는 부분이 없어지고
결과가 바로 반환된다. 
이처럼 withContext 함수를 사용하면 async - await 쌍을 깔끔하게 만들 수 있다.

---
## withContext 동작 방식
async - await 쌍은 새로운 코루틴을 생성해 작업을 처리하지만 withContext 함수는 실행 중이던 코루틴을 그대로 유지한 채로
코루틴의 실행 환경만 변경해 작업을 처리한다.

> !! 실행 중이던 코루틴을 그래도 유지한 채로 !! 중요함

즉, 새로운 코루틴을 만드는 대신 기존의 코루틴에서 CoroutineContext 객체만 바꿔서 실행한다.

> 코루틴을 실행시키는 CoroutineDispatcher 객체가 변경돼 코루틴의 실행 스레드가 변화한다.

> withContext 함수가 block 람다식을 벗어나면 다시 원래의 CoroutineContext 객체를 사용해 실행된다.

---
## withContext 사용 시 주의점
새로운 코루틴을 만들지 않기 때문에 하나의 코루틴에서 withContext 함수가 여러 번 호출되면 순차적으로 실행된다.
즉 복수의 독릭접인 병렬로 실행돼야 하는 상황에 withContext를 사용할 경우 성능에 문제를 일으킬 수 있다.

!! withContext를 사용할 때는 새로운 코루틴을 만들지 않는다는 것을 명심하고 사용하자!!
