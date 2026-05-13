# 프로젝트 아키텍처 및 패키지 구조 (Architecture & Packages)

이 문서는 MisunMoneyPlan 프로젝트의 아키텍처 원칙과 패키지 간의 계층 구조 및 역할을 정의합니다.

## 🏛️ 아키텍처 개요 (Clean Architecture + MVVM)
본 프로젝트는 **Clean Architecture** 가이드라인에 따라 계층을 분리하여 유지보수성과 테스트 용이성을 극대화합니다.

### 계층 구조 및 데이터 흐름
`Data (Local DB)` ↔ `Domain (Logic)` ↔ `Presentation (UI)`
- **의존성 방향**: 모든 의존성은 안쪽(**Domain**)으로 향합니다. Domain 계층은 외부 라이브러리나 UI에 의존하지 않는 순수 Kotlin 코드로 구성됩니다.

---

## 📂 패키지별 상세 역할 (Package Responsibilities)

### 1. `:app` (Android Entry Point)
- **역할**: 앱의 최상위 설정 및 진입점.
- **주요 구성**: `MainActivity.kt`, `HiltApplication.kt`, 전역 네비게이션 설정.

### 2. `domain` (Business Logic - The Core)
- **`model/`**: 비즈니스에 필요한 핵심 데이터 모델 (`Asset`, `AssetType`, `Portfolio`).
- **`usecase/`**: 단일 비즈니스 로직 단위 (`CalculateAllocation`, `GetAssetList`).
- **`repository/`**: 데이터 접근을 위한 인터페이스 정의. (구현체는 `data` 레이어에 위치)

### 3. `data` (Data Source Implementation)
- **`local/`**: Room DB 엔티티, DAO, Database 설정.
- **`repository/`**: `domain`에서 정의한 레포지토리 인터페이스의 실제 구현체.
- **`mapper/`**: DB 엔티티(`AssetEntity`)와 도메인 모델(`Asset`) 간의 양방향 변환 로직.

### 4. `presentation` (UI Layer - Jetpack Compose)
특정 화면 단위(Feature)로 패키지를 구성하여 응집도를 높였습니다.
- **`home/`**: 메인 대시보드 (`SCR-01`). Screen, ViewModel, UiState 포함.
- **`asset/`**: 종목 상세 및 유형 상세 (`SCR-02, 04`).
- **`portfolio/`**: 포트폴리오 관리 및 리밸런싱 (`SCR-03`).
- **`components/`**: 전역적으로 재사용되는 공통 UI 컴포넌트 (Charts, Badges, Cards).
- **`navigation/`**: 화면 간 이동을 정의하는 Route 및 NavHost 설정.
- **`ui/theme/`**: 디자인 시스템 (색상, 타이포그래피, 테마).

---

## 📏 주요 개발 규칙 (Architecture Rules)
- **ViewModel 주소**: 각 ViewModel은 자신이 속한 기능 패키지(예: `presentation/home/`) 내부에 위치한다.
- **모델 변환**: `data` 레이어에서 가져온 데이터는 반드시 `mapper`를 거쳐 `domain` 모델로 변환된 후 `presentation`으로 전달되어야 한다.
- **의존성 주입**: 모든 객체 생성 및 주입은 **Hilt**를 통해 관리한다.

---
*마지막 업데이트: 2026-05-13*
