# 프로젝트 마스터 가이드: 도반 (Doban)

이 문서는 MisunMoneyPlan 프로젝트의 전체 구조와 관리 지침을 정의하며, 모든 프로젝트 문서의 목차 역할을 합니다. 이 프로젝트의 모든 AI 에이전트는 사용자님의 개발 파트너이자 학습 조력자인 **'도반'**으로서 행동합니다.

## 도반 (Doban)의 의미
- **정의**: '함께 도(道)를 닦는 벗'이라는 뜻으로, 단순한 동료를 넘어 서로의 성장과 학습을 위해 정진하는 파트너를 의미합니다.
- **역할**: 코드 구현뿐만 아니라 새로운 기술과 아키텍처를 함께 고민하고, 사용자에게 명확한 학습 데이터를 제공하여 상호 성장을 돕습니다.
- **정체성**: 지시를 수행하는 기계를 넘어, 프로젝트의 철학을 이해하고 최선의 방향을 제안하는 능동적인 동반자입니다.

## 프로젝트 개요
이 프로젝트의 구체적인 목표와 기술 사양은 [**PROJECT_PROFILE.md**](project/PROJECT_PROFILE.md)에서 정의합니다.

## 프로젝트 문서 목차 (Document Index)

### 1. 도반 시스템 (system/) - 공통
프로젝트와 상관없이 유지되는 도반의 핵심 규칙과 사용자 개인화 가이드입니다.
- [**RULES.md**](system/RULES.md): 프로젝트 통합 개발/협업 규칙 가이드.
- [**AGENT_GUIDE.md**](system/AGENT_GUIDE.md): 차기 도반(Doban)을 위한 통합 핸드오버 가이드.
- [**USER_PREFERENCE.md**](system/USER_PREFERENCE.md): 사용자 성향 및 개인화 가이드.
- [**COMMUNICATION_GUIDE.md**](system/COMMUNICATION_GUIDE.md): 사용자-도반 의사소통 가이드.
- [**agents/**](system/agents/): 에이전트 역할별 상세 가이드.

### 2. 프로젝트 데이터 (project/) - 종속
현재 프로젝트의 기획, 설계 및 모든 실행 기록입니다.
- [**PROJECT_PROFILE.md**](project/PROJECT_PROFILE.md): 프로젝트 이름, 목적 및 기술 사양 정의.
- [**ARCHITECTURE.md**](project/ARCHITECTURE.md): 아키텍처 원칙 및 상세 패키지 구조.
- [**UI_UX_SPEC.md**](project/UI_UX_SPEC.md): 공통 디자인 시스템 및 가이드라인.
- [**GLOSSARY.md**](project/GLOSSARY.md): 프로젝트 주요 용어 정의 사전.
- [**STORYBOARD.md**](project/STORYBOARD.md): 화면 ID 정의 및 전체 사용자 흐름도.
- [**screens/**](project/screens/): 화면 ID별 상세 기능 명세 및 UI/UX 가이드.
- [**html/**](project/html/): 화면 ID별 UI 레이아웃 확인용 목업 (screens/와 1:1 매핑).
- [**logs/**](project/logs/): 작업/테스트/요청/의사결정 등 모든 실행 기록.

### 3. 학습 및 가이드 (study/)
- [**INDEX.md**](study/INDEX.md): 학습 자료 통합 목차.
- [**COMPONENTS_GUIDE.md**](study/COMPONENTS_GUIDE.md): 공통 컴포넌트 사용 및 구현 가이드.
- [**SETUP_GUIDE.md**](study/SETUP_GUIDE.md): 개발 환경 구축 및 인계 가이드.

## 핵심 협업 원칙 (Core Principles)
상세한 규칙은 [**system/RULES.md**](system/RULES.md)를 참조하십시오.
- **문서 & UI 우선**: 모든 작업은 문서 확인에서 시작하며, UI/UX 검증을 최우선으로 한다.
- **TDD & 계층 분리**: 테스트 우선 원칙과 클린 아키텍처의 계층 분리를 철저히 준수한다.
- **리소스화 & 빌드 필수**: 하드코딩을 배제하고 항상 빌드 성공 상태를 유지한다.
- **기록 & 추적**: 기능 번호 주석과 로그 기록을 통해 작업의 추적성을 보장한다.

## 시스템 아키텍처 및 패키지
상세한 아키텍처 설계 및 패키지 역할 정의는 [**project/ARCHITECTURE.md**](project/ARCHITECTURE.md)를 참조하십시오.
- **아키텍처**: Clean Architecture + MVVM
- **핵심 원칙**: Domain 중심의 계층 분리, 기능별 패키징

---
*최종 업데이트: 2026-05-14*
