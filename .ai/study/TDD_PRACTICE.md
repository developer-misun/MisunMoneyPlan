# TDD 실전 가이드 (Test-First)

본 프로젝트는 "테스트를 통과하지 못한 코드는 존재하지 않는다"는 원칙 하에 개발됩니다.

## 1. TDD 개발 순서
1. **Given**: `TEST_LOG.md`에 요구사항 기반의 테스트 케이스를 정의합니다.
2. **When**: 실패하는 테스트 코드를 먼저 작성합니다.
3. **Then**: 테스트를 통과할 만큼의 최소한의 구현을 수행하고 리팩토링합니다.

## 2. 실제 구현 예시 (Coroutines Test)
비동기 로직인 ViewModel 테스트 시 `UnconfinedTestDispatcher`를 활용합니다.
- **예시 파일**: `com.misun.misunmoneyplan.presentation.home.HomeViewModelTest.kt`
  ```kotlin
  @Test
  fun `TC-T2-1-04 loadAssets 호출 시 로딩 상태가 전이되어야 함`() = runTest {
      viewModel.loadAssets()
      assertEquals(false, viewModel.uiState.value.isLoading)
  }
  ```

## 3. 핵심 규칙
- 모든 비즈니스 로직은 `domain/` 계층에 독립적으로 테스트 가능하게 작성합니다.
- UI는 가급적 로직이 없는 `Stateless` 구조로 유지하여 테스트 복잡도를 낮춥니다.

---
*참고: 상세한 실행법은 [TESTING_GUIDE.md](../development/TESTING_GUIDE.md)를 참조하십시오.*
