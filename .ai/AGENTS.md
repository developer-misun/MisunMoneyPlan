# 프로젝트 마스터 가이드 (Project Master Index)

이 문서는 MisunMoneyPlan 프로젝트의 전체 구조와 관리 지침을 정의하며, 모든 프로젝트 문서의 목차 역할을 합니다.

## 프로젝트 개요
- **이름:** MisunMoneyPlan
- **목적:** 자산배분을 체계적으로 관리하고 리밸런싱을 돕는 안드로이드 앱.
- **아키텍처:** MVVM + Clean Architecture 지향.
- **기술 스택:** Kotlin, Jetpack Compose, Hilt, Room DB, KSP. (상세 내역은 `TECH_STACK.md` 참조)

## 프로젝트 문서 목차 (Document Index)

프로젝트 문서는 관리 효율성을 위해 `planning/`, `development/`, `management/` 서브 디렉토리로 구조화되어 관리됩니다.

### 1. 기획 및 설계 (planning/)
- [**STORYBOARD.md**](planning/STORYBOARD.md): 화면 ID 정의 및 전체 사용자 흐름도.
- [**screens/**](planning/screens/): 화면 ID별 상세 기능 명세 및 UI/UX 가이드.
- [**ARCHITECTURE.md**](planning/ARCHITECTURE.md): 아키텍처 원칙 및 상세 패키지 구조.
- [**UI_UX_SPEC.md**](planning/UI_UX_SPEC.md): 공통 디자인 시스템 및 가이드라인.
- [**GLOSSARY.md**](planning/GLOSSARY.md): 프로젝트 주요 용어 정의 사전.

### 2. 개발 및 관리 (development/ & management/)

#### 개발 실행 (development/)
- [**TASK_LOG.md**](development/TASK_LOG.md): 작업 단위별 진행 현황 및 히스토리.
- [**TEST_LOG.md**](development/TEST_LOG.md): 테스트 케이스 정의 및 수행 결과.
- [**TESTING_GUIDE.md**](development/TESTING_GUIDE.md): 개발자용 단위 테스트 수행 가이드.
- [**BUG_LOG.md**](development/BUG_LOG.md): 결함 발견 및 수정 이력 관리.
- [**TECH_STACK.md**](development/TECH_STACK.md): 도입 기술 스택 설명 및 학습 리소스.

#### 프로젝트 관리 (management/)
- [**ROADMAP.md**](management/ROADMAP.md): 프로젝트 마일스톤 및 향후 계획.
- [**REQUEST_LOG.md**](management/REQUEST_LOG.md): 사용자 요청사항 및 반영 이력.
- [**DECISION_LOG.md**](management/DECISION_LOG.md): 주요 기술적/설계적 의사결정 기록.
- [**RULES.md**](management/RULES.md): 프로젝트 통합 개발/협업 규칙 가이드.

## 핵심 협업 원칙 (Core Principles)
상세한 규칙은 [**management/RULES.md**](management/RULES.md)를 참조하십시오.
- **문서 & UI 우선**: 모든 작업은 문서 확인에서 시작하며, UI/UX 검증을 최우선으로 한다.
- **TDD & 계층 분리**: 테스트 우선 원칙과 클린 아키텍처의 계층 분리를 철저히 준수한다.
- **리소스화 & 빌드 필수**: 하드코딩을 배제하고 항상 빌드 성공 상태를 유지한다.
- **기록 & 추적**: 기능 번호 주석과 로그 기록을 통해 작업의 추적성을 보장한다.

## 시스템 아키텍처 및 패키지
상세한 아키텍처 설계 및 패키지 역할 정의는 [**planning/ARCHITECTURE.md**](planning/ARCHITECTURE.md)를 참조하십시오.
- **아키텍처**: Clean Architecture + MVVM
- **핵심 원칙**: Domain 중심의 계층 분리, 기능별 패키징

---
*최종 업데이트: 2026-05-13*
