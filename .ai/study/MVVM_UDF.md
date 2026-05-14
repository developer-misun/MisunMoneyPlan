# MVVM 및 단방향 데이터 흐름 가이드 (MVVM & UDF)

Compose의 상태 관리 복잡도를 해결하고 예측 가능한 UI를 구축하기 위한 패턴입니다.

## 1. UDF (Unidirectional Data Flow) 원칙
- **State**: ViewModel에서 UI로 흐르는 데이터의 상태 (StateFlow).
- **Event**: UI에서 ViewModel로 전달되는 사용자 액션 (Function Call).

## 2. 실제 구현 예시

### UiState 정의
- **위치**: `com.misun.misunmoneyplan.presentation.home.HomeUiState.kt`
  ```kotlin
  data class HomeUiState(
      val assets: List<AssetUiModel> = emptyList(),
      val isLoading: Boolean = false,
      val errorMessage: String? = null
  )
  ```

### ViewModel 상태 관리
- **위치**: `com.misun.misunmoneyplan.presentation.home.HomeViewModel.kt`
  ```kotlin
  private val _uiState = MutableStateFlow(HomeUiState())
  val uiState = _uiState.asStateFlow()
  
  fun onTabSelected(index: Int) { ... } // Event 처리
  ```

## 3. 이점
- **가독성**: 데이터의 흐름이 한 방향으로만 움직여 상태 추적이 쉽습니다.
- **디버깅 용이**: UI가 직접 상태를 수정하지 않으므로 예기치 않은 상태 변경을 방지합니다.
