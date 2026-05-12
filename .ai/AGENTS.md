# 프로젝트 설계 지침 및 요구사항 (Project Rules)

## 📌 프로젝트 개요
- **이름:** MisunMoneyPlan
- **목적:** 자산배분을 관리하는 앱이다.
- **기술 스택:** Kotlin, Jetpack Compose, Retrofit2, Room DB
- **아키텍처:** MVVM

## 💡 Gemini 에이전트를 위한 지침
- 모든 코드는 **Kotlin** 스타일 가이드를 준수할 것.
- UI는 반드시 **Jetpack Compose**로 작성할 것.
- **학습 우선 원칙 (Study First)**: 코드 작성이 목적이 아니다. 새로운 라이브러리, 플러그인, 복잡한 로직을 도입하기 전 반드시 그 필요성과 원리를 먼저 설명하고 사용자의 확인을 받은 후 진행한다.
- **설계 후 구현 (Design before Code)**: 큰 그림(패키지, 인터페이스)을 먼저 그리고, 세부 구현은 단계별로 진행한다. 코드 작성 시에는 한 번에 많은 양을 수정하지 않고 작은 단위로 나누어 설명과 함께 진행한다.
- **상세 주석 및 참조**: 복잡한 로직이나 아키텍처 결정 시 상세한 주석과 학습용 참고 링크를 포함한다.

## 🏗️ 패키지 구조 및 역할 (Architecture)
- **`app`**: 앱의 진입점 및 전역 설정을 담당한다.
    - `MainActivity.kt`, `MoneyPlanApp.kt` (Application 클래스)
- **`presentation`**: UI 레이어. 화면, 상태 관리, 테마를 담당한다.
    - `home/`: 메인 대시보드 (`HomeScreen.kt`, `HomeUiState.kt`, `HomeViewModel.kt`)
    - `asset/`: 자산 상세 및 관리 (`StockDetailScreen.kt`, `AssetDetailViewModel.kt`)
    - `portfolio/`: 포트폴리오 관리 (`PortfolioScreen.kt`, `PortfolioViewModel.kt`)
    - `components/`: 공통 재사용 컴포넌트 (`PieChart.kt`, `TotalAssetCard.kt`)
    - `ui.theme/`: 디자인 시스템 정의 (`Color.kt`, `Theme.kt`)
- **`domain`**: 순수 비즈니스 로직 레이어 (가장 안쪽 계층).
    - `model/`: 비즈니스 데이터 모델 (`Asset.kt`, `AssetType.kt`)
    - `usecase/`: 단일 비즈니스 로직 단위 (`GetAssetsUseCase.kt`, `UpdateAssetUseCase.kt`)
    - `repository/`: 데이터 접근 인터페이스 정의 (`AssetRepository.kt`)
- **`data`**: 데이터 소스 구현 레이어.
    - `local/`: Room DB 관련 (`AssetDatabase.kt`, `AssetDao.kt`)
    - `repository/`: Domain 인터페이스의 실제 구현부 (`AssetRepositoryImpl.kt`)
    - `mapper/`: Data 모델과 Domain 모델 간 변환 (`AssetMapper.kt`)
- **`di`**: Hilt 의존성 주입 설정 파일들.

## 🔄 AI 협업 및 컨텍스트 유지 규칙 (Mandatory)
- **학습 우선**: 새로운 라이브러리나 기술 도입 전 **`TECH_STACK.md`**에 원리와 목적을 정리하고 사용자의 승인을 받는다.
- **실시간 동기화**: 요구사항 확정 시 `AGENTS.md` 및 `UI_UX_SPEC.md`를 즉시 업데이트한다.
- **TODO 관리**: `AGENTS.md`의 **TODO** 섹션에 추가된 아이디어를 수시로 확인하여 `STORYBOARD.md` 및 작업 계획에 반영하고, 반영이 완료된 항목은 즉시 삭제한다.
- **상태 기록**: 작업 완료 후 변경 사항과 다음 할 일을 `PROJECT_STATUS.md`에, 테스트 결과는 `TEST_LOG.md`에 기록한다.
- **의도 파악**: 기술적/디자인적 결정 배경은 `DECISION_LOG.md`를, 화면 흐름은 `STORYBOARD.md`를 참조한다.
- **우선순위**: AI는 `.ai/` 폴더 내의 모든 파일을 최우선 컨텍스트로 간주한다.

## 📋 설계 및 구현 원칙
- **테스트 케이스 우선 정의**: 모든 작업 시작 전, 해당 기능을 검증할 테스트 케이스를 먼저 정의하고 `.ai/TEST_LOG.md`에 `READY` 상태로 기록한다.
- **테스트 우선 원칙 (Test-Driven Development)**: 정의된 테스트 케이스를 바탕으로 구현 전 또는 구현 직후 반드시 테스트 코드(Unit Test)를 작성한다.
    - 도메인 로직: JUnit 기반 Unit Test
    - UI 컴포넌트: Compose Preview 또는 Screenshot Test (필요 시)
    - 데이터 레이어: Room 관련 로직은 테스트 DB를 활용한 검증
- **데이터 모델링**: `HomeUiState` 등 UI 상태 모델 설계 시 데이터 간 정합성과 자동 계산 로직을 우선한다.
- **UI/UX 명세**: 시각적 디자인, 간격, 컴포넌트 스타일은 **`UI_UX_SPEC.md`**를 절대적으로 준수한다.
- **유형 속성**: 모든 자산은 `AssetType` enum을 가지며, 이를 통해 명칭과 테마 색상을 결정한다.



## TODO


---
*최종 업데이트: 2026-05-11*
