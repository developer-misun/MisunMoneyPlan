# 단위 테스트 수행 가이드 (Unit Testing Guide)

이 문서는 개발자가 프로젝트의 비즈니스 로직을 검증하기 위해 단위 테스트를 수행하는 방법과 규칙을 설명합니다.

## 1. 테스트 실행 방법

### IDE (Android Studio)에서 실행
- **개별 테스트 실행**: 테스트 클래스나 함수 좌측의 '재생(▶️)' 아이콘을 클릭합니다.
- **패키지 단위 실행**: `app/src/test` 폴더에서 마우스 우클릭 후 'Run Tests in...'을 선택합니다.

### 터미널 (Gradle)에서 실행
프로젝트 루트 디렉토리에서 다음 명령어를 사용합니다.
- **전체 유닛 테스트 실행**:
  ```bash
  ./gradlew test
  ```
- **특정 모듈 테스트 실행**:
  ```bash
  ./gradlew :app:testDebugUnitTest
  ```
- **특정 클래스만 실행**:
  ```bash
  ./gradlew :app:testDebugUnitTest --tests com.misun.misunmoneyplan.presentation.home.HomeViewModelTest
  ```

## 2. 테스트 작성 규칙 (TDD)

### 파일 위치
- **단위 테스트**: `app/src/test/java/` 하위의 대응되는 패키지에 위치합니다.
- **파일명**: 테스트 대상 클래스명 뒤에 `Test`를 붙입니다. (예: `HomeViewModel` -> `HomeViewModelTest`)

### 테스트 구조 (Given-When-Then)
모든 테스트 함수는 다음 구조를 지향합니다.
- **Given**: 테스트에 필요한 데이터나 환경을 설정합니다.
- **When**: 실제 검증하고자 하는 동작을 수행합니다.
- **Then**: 기대하는 결과와 실제 결과를 비교 검증(Assertion)합니다.

### 네이밍 규칙
테스트 함수명은 한글을 사용하여 의도를 명확히 드러냅니다.
```kotlin
@Test
fun `[ID] 테스트_시나리오_설명`() {
    // 예: `TC-T2-1-01 초기 데이터 로드 확인`
}
```

## 3. 주요 도구 및 라이브러리
- **JUnit4**: 표준 테스트 프레임워크.
- **Kotlin Coroutines Test**: 비동기 로직 검증을 위한 `runTest`, `UnconfinedTestDispatcher` 사용.
- **MockK / Mockito**: 의존성 객체를 가짜(Mock)로 대체하기 위해 사용 (도입 예정).

## 4. 테스트 결과 기록
테스트 수행 후 결과는 반드시 [`.ai/TEST_LOG.md`](TEST_LOG.md)에 업데이트하여 팀 전체가 공유할 수 있도록 합니다.

---
*최종 업데이트: 2026-05-13*
