# 프로젝트 마스터 가이드 (Project Master Index)

이 문서는 MisunMoneyPlan 프로젝트의 전체 구조와 관리 지침을 정의하며, 모든 프로젝트 문서의 목차 역할을 합니다.

## 📌 프로젝트 개요
- **이름:** MisunMoneyPlan
- **목적:** 자산배분을 체계적으로 관리하고 리밸런싱을 돕는 안드로이드 앱.
- **아키텍처:** MVVM + Clean Architecture 지향.
- **기술 스택:** Kotlin, Jetpack Compose, Hilt, Room DB, KSP. (상세 내역은 `TECH_STACK.md` 참조)

## 🗂️ 프로젝트 문서 목차 (Document Index)
1. **기획 및 설계**
   - [`STORYBOARD.md`](STORYBOARD.md): 화면 ID 정의 및 전체 사용자 흐름도.
   - [**`screens/`**](screens/): 화면 ID별 상세 기능 명세 및 UI/UX 가이드.
   - [`ARCHITECTURE.md`](ARCHITECTURE.md): 아키텍처 원칙 및 상세 패키지 구조.
   - [`UI_UX_SPEC.md`](UI_UX_SPEC.md): 공통 디자인 시스템 및 가이드라인.

2. **개발 및 관리**
   - [`TASK_LOG.md`](TASK_LOG.md): 작업 단위별 진행 현황 및 히스토리.
   - [`TEST_LOG.md`](TEST_LOG.md): 테스트 케이스 정의 및 수행 결과.
   - [`REQUEST_LOG.md`](REQUEST_LOG.md): 사용자 요청사항 및 반영 이력.
   - [`DECISION_LOG.md`](DECISION_LOG.md): 주요 기술적/설계적 의사결정 기록.
   - [`TECH_STACK.md`](TECH_STACK.md): 도입 기술 스택 설명 및 학습 리소스.

## 💡 Gemini 에이전트 협업 규칙 (Core Rules)
- **문서 최우선**: 모든 작업 시작 전 관련 문서를 확인하고, 작업 완료 후 문서를 즉시 갱신한다.
- **기능 번호 주석**: 코드 구현 시 해당 로직에 연결된 기능 번호(예: `[F1-1]`)를 반드시 주석으로 명시한다.
- **테스트 필수**: 모든 작업 단위는 `TEST_LOG.md`에 정의된 테스트 케이스를 통과해야 한다.
- **학습 우선**: 새로운 기술 도입 전 `TECH_STACK.md`에 원리를 정리하고 승인을 받는다.

## 🏗️ 시스템 아키텍처 및 패키지
상세한 아키텍처 설계 및 패키지 역할 정의는 **[`ARCHITECTURE.md`](ARCHITECTURE.md)**를 참조하십시오.
- **아키텍처**: Clean Architecture + MVVM
- **핵심 원칙**: Domain 중심의 계층 분리, 기능별 패키징

---
*최종 업데이트: 2026-05-13*
