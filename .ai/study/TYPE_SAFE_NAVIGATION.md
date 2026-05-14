# 타입 안전 네비게이션 가이드 (Type-Safe Navigation)

문자열 리터럴 기반의 Route 관리의 위험성을 제거하고, 오타나 파라미터 불일치로 인한 오류를 컴파일 시점에 방지합니다.

## 1. 핵심 개념
- **Sealed Class**: 각 화면(Route)과 파라미터 생성 로직을 하나의 클래스로 묶어 캡슐화합니다.

## 2. 실제 구현 예시

### Screen 정의
- **위치**: `com.misun.misunmoneyplan.presentation.navigation.Screen.kt`
  ```kotlin
  sealed class Screen(val route: String) {
      object Home : Screen("home")
      object StockDetail : Screen("stockDetail/{assetId}") {
          fun createRoute(assetId: String) = "stockDetail/$assetId"
      }
  }
  ```

### 사용법 (AppNavGraph)
- **위치**: `com.misun.misunmoneyplan.app.AppNavGraph.kt`
  ```kotlin
  composable(Screen.StockDetail.route) { // 정의 시
      ...
  }
  navController.navigate(Screen.StockDetail.createRoute(id)) // 이동 시
  ```

## 3. 참고 자료
- [Android Developers - Type-safe navigation in Compose](https://developer.android.com/guide/navigation/design/type-safety)
