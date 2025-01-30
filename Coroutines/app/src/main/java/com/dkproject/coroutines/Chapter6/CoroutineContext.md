## CoroutineContext
CoroutineContext는 코루틴을 실행하는 실행 환경을 설정하고 관리하는 인터페이스로 CoroutineContext 객체는 
CoroutineDispatcher, CoroutineName, Job 등의 객체를 조합해 코루틴의 실행 환경을 설정한다.
즉, CoroutineContext 객체는 코루틴을 실행하고 관리하는 데 핵심적인 역활을 하며, 코루틴의 실행과 관련된 모든 설정은 CoroutineContext 객체를 통해 이루어진다.

---
### CoroutineContext의 구성요소
- CoroutineName: 코루틴의 이름을 설정
- CoroutineDispatcher: 코루틴을 스레드에 할당해 실행
- Job: 코루틴의 추상체로 코루틴을 조작하는데 사용
- CoroutineExceptionHandler: 코루틴에서 발생한 예외를 처리한다

### CoroutineContext가 구성 요소를 관리하는 방법
CoroutineContext 객체는 키-값 쌍으로 각 구성요소를 관리한다
      key                            value
CoroutineName 키             | CoroutineName 객체
CoroutineDispatcher 키       | CoroutineDispatcher 객체
Job 키                       | Job 객체
CoroutineExceptionHandler 키 | CoroutineExceptionHandler 객체

키에 대해 중복된 값은 허용하지 않음
따라서 CoroutineContext CoroutineName, CoroutineDispatcher, Job, CoroutineExceptionHandler 객체를 한 개씩만 가질 수 있다.

---

### CoroutineContext 구성
키-값 쌍으로 구성 요소를 관리하지만 키에 값을 직접 대입하는 방법을 사용하지 않는다.
대신 CoroutineContext 객체 간에 더하기 연산자를(+) 사용해 CoroutineContext 객체를 구성한다.
```kotlin
val coroutineCOntext: CoroutineContext = newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")
```
위의 코드에서 
CoroutineName 키  값 = CoroutineName("MyCoroutine")
CoroutineDispatcher 키 값 = newSingleThreadContext("MyThread")
