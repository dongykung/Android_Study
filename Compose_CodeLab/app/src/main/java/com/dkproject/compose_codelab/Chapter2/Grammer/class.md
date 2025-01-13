## IS-A관계
SmartDevice 슈퍼클래스와 SmartTvDevice 서브클래스 간의 IS-A 관계를 지정하면
SmartDevice 슈퍼클래스가 할 수 있는 모든 작업을 SmartTvDevice 서브클래스가 할 수 있습니다.
관계는 단방향이므로, 모든 스마트 TV가 스마트 기기에 해당한다고 말 할 수 있지만 모든 스마트 기기가 스마트 TV에 해당한다고 말할 수는 없습니다.

코드의 재사용성을 확보하기 위해서만 상속을 사용하지는 마세요. 결정하기 전에 두 클래스가 서로 관련이 있는지 확인
관계가 어느 정도 존재하는 경우 실제로 IS-A 관계에 해당하는지 확인

Smart TV IS-A smart device

## HAS-A 관계
스마트 TV를 사용하는 경우 스마트 TV와 집 사이에 관계가 있습니다.
집에 스마트 기기가 포함됩니다.
즉, 집에 스마트 기기가 존재합니다. 두 클래스 간의 HAS-A 관계를 컴포지션이라고 합니다.

다음과 같이 HAS-A 관계를 사용하여 SmartHome 클래스를 정의
```kotlin
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
        

}

class SmartHome(val smartTvDevice: SmartTvDevice) {

}

fun main() {
}
```
