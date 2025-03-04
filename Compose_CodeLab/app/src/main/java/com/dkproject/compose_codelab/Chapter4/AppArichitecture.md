## 아키텍처 원칙

### 관심사 분리
관심사 분리 디자인 원칙은 각각 별개의 책임이 있는 여러 함수 클래스로 앱을 나눠야 한다는 원칙

### 모델에서 UI 만들기
모델(가능한 경우 영구 모델)에서 UI를 만들어야 한다는 원칙입니다.
모델은 앱의 데이터 처리를 담당하는 구성요소로, 앱의 UI 요소 및 앱 구성요소와 독립되어 있으므로 앱의 수명 주기 및 관련 문제의 영향을 받지 않습니다.

---

## 권장 앱 아키텍처

### UI레이어
화면에 앱 데이터를 표시하지만 데이터와는 무관한 레이어
화면에 데이터를 표시하는 것.
버튼 누르기와 같은 사용자 상호작용으로 인해 데이터가 변경될 때마다 UI가 변경사항을 반영하여 업데이트되어야 함.

- UI 요소: 화면에 데이터를 렌더링 하는 구성요소, 이러한 요소는 `JetPack Compose`를 사용하여 빌드
- 상태 홀더: 데이터를 보유하고 UI에 노출하며 앱 로직을 처리하는 구성요소. 상태 홀더의 예로 `ViewModel`

#### viewModel
`ViewModel`구성요소는 UI가 사용하는 상태를 보유하고 노출.
UI 상태는 `ViewModel`에 의해 변환된 애플리케이션 데이터임.

`ViewModel`은 안드로이드 프레임워크에서 활동이 소멸되고 다시 생성될 때 폐기되지 않는 앱 관련 데이터를 저장합니다.
활동 인스턴스와 달리 `ViewModel`객체는 소멸하지 않습니다. 앱은 구성 변경 중에 자동으로 ViewModel 객체를 유지하므로 객체가 보유하고 있는 
데이터는 재구성 후에 즉시 사용 가능합니다.

앱에 `ViewModel`을 구현하려면 아키텍처 구성요소 라이브러리에서 가져온 `ViewModel`클래스를 확장하고 이 클래스 내에 앱 데이터를 저장

#### UI 상태
사용자가 보는 항목이 UI라면 UI 상태는 앱에서 사용자가 봐야 한다고 지정하는 항목입니다.
UI는 UI 상태를 시각적으로 나타냅니다. UI 상태가 변경되면 변경사항이 즉시 UI에 반영되어야 함.

### 데이터 레이어
앱 데이터를 저장하고, 가져오고, 노출하는 레이어.

### 도메인 레이어
UI와 데이터 레이어 간의 상호작용을 간소화하고 재사용하기 위해 도메인 레이어라는 레이어를 추가할 수 있습니다.
이 레이어는 선택사항입니다.