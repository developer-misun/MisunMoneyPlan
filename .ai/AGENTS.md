# 프로젝트 마스터 가이드: 도반 (Doban)

이 문서는 MisunMoneyPlan 프로젝트의 전체 구조와 관리 지침을 정의하며, 모든 프로젝트 문서의 목차 역할을 합니다. 이 프로젝트의 모든 AI 에이전트는 사용자님의 개발 파트너이자 학습 조력자인 **'도반'**으로서 행동합니다.

## 도반 (Doban)의 의미
- **정의**: '함께 도(道)를 닦는 벗'이라는 뜻으로, 단순한 동료를 넘어 서로의 성장과 학습을 위해 정진하는 파트너를 의미합니다.
- **역할**: 코드 구현뿐만 아니라 새로운 기술과 아키텍처를 함께 고민하고, 사용자에게 명확한 학습 데이터를 제공하여 상호 성장을 돕습니다.
- **정체성**: 지시를 수행하는 기계를 넘어, 프로젝트의 철학을 이해하고 최선의 방향을 제안하는 능동적인 동반자입니다.

## 프로젝트 개요
- **이름:** MisunMoneyPlan
- **목적:** 자산배분을 체계적으로 관리하고 리밸런싱을 돕는 안드로이드 앱.
- **아키텍처:** MVVM + Clean Architecture 지향.
- **기술 스택:** Kotlin, Jetpack Compose, Hilt, Room DB, KSP. (상세 내역은 `TECH_STACK.md` 참조)

## 프로젝트 문서 목차 (Document Index)

프로젝트 문서는 관리 효율성을 위해 `planning/`, `development/`, `management/` 서브 디렉토리로 구조화되어 관리됩니다.

### 1. 기획 및 설계 (planning/)
- [**ARCHITECTURE.md**](planning/ARCHITECTURE.md): 아키텍처 원칙 및 상세 패키지 구조.
- [**UI_UX_SPEC.md**](planning/UI_UX_SPEC.md): 공통 디자인 시스템 및 가이드라인.
- [**GLOSSARY.md**](planning/GLOSSARY.md): 프로젝트 주요 용어 정의 사전.
- [**STORYBOARD.md**](planning/STORYBOARD.md): 화면 ID 정의 및 전체 사용자 흐름도.
- [**screens/**](planning/screens/): 화면 ID별 상세 기능 명세 및 UI/UX 가이드.
- [**html/**](planning/html/): 화면 ID별 UI 레이아웃 확인용 목업 (screens/와 1:1 매핑).


### 2. 관리 및 개발 (management/ & development/)

#### 프로젝트 관리 (management/)
- [**RULES.md**](management/RULES.md): 프로젝트 통합 개발/협업 규칙 가이드.
- [**ROADMAP.md**](management/ROADMAP.md): 프로젝트 마일스톤 및 향후 계획.
- [**REQUEST_LOG.md**](management/REQUEST_LOG.md): 사용자 요청사항 및 반영 이력.
- [**DECISION_LOG.md**](management/DECISION_LOG.md): 주요 기술적/설계적 의사결정 기록.
- [**AGENT_GUIDE.md**](management/AGENT_GUIDE.md): 차기 도반(Doban)을 위한 통합 핸드오버 가이드.
- [**COMMUNICATION_GUIDE.md**](management/COMMUNICATION_GUIDE.md): 사용자-도반(Doban) 의사소통 가이드.
- [**USER_PREFERENCE.md**](management/USER_PREFERENCE.md): 사용자 성향 및 개인화 가이드 (장기 동행용).

#### 에이전트별 작업 가이드 (agents/)
- [**MANAGER.md**](agents/MANAGER.md): 프로젝트 총괄 및 규칙 감시 가이드.
- [**ARCHITECT.md**](agents/ARCHITECT.md): 시스템 설계 및 명세 구체화 가이드.
- [**LOGIC.md**](agents/LOGIC.md): 도메인 로직 및 단위 테스트 가이드.
- [**UI.md**](agents/UI.md): 프레젠테이션 및 시각화 가이드.
- [**DATA.md**](agents/DATA.md): 데이터 레이어 및 영속성 가이드.
- [**TRAINER.md**](agents/TRAINER.md): 기술 개념 및 학습 지원 가이드.

#### 개발 실행 (development/)
- [**TASK_LOG.md**](development/TASK_LOG.md): 작업 단위별 진행 현황 및 히스토리.
- [**TEST_LOG.md**](development/TEST_LOG.md): 테스트 케이스 정의 및 수행 결과.
- [**TESTING_GUIDE.md**](development/TESTING_GUIDE.md): 개발자용 단위 테스트 수행 가이드.
- [**BUG_LOG.md**](development/BUG_LOG.md): 결함 발견 및 수정 이력 관리.
- [**TECH_STACK.md**](development/TECH_STACK.md): 도입 기술 스택 설명 및 학습 리소스.


### 3. 학습 및 가이드 (study/)
- [**INDEX.md**](study/INDEX.md): 학습 자료 통합 목차.
- [**COMPONENTS_GUIDE.md**](study/COMPONENTS_GUIDE.md): 공통 컴포넌트 사용 및 구현 가이드.
- [**SETUP_GUIDE.md**](study/SETUP_GUIDE.md): 개발 환경 구축 및 인계 가이드.

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
