# MisunMoneyPlan

자산배분을 체계적으로 관리하고 리밸런싱을 돕는 안드로이드 애플리케이션입니다.

## AI 에이전트 협업 시스템
이 프로젝트는 AI 에이전트와 인간 개발자가 고도의 규칙 기반으로 협업하도록 설계되었습니다.

### 핵심 문서 (Brain of Project)
- 모든 프로젝트 관리 및 설계 명세는 [**.ai/AGENTS.md**](.ai/AGENTS.md)를 기점으로 관리됩니다.
- 새로운 개발자나 AI 에이전트는 작업 시작 전 반드시 [**AGENT_GUIDE.md**](.ai/management/AGENT_GUIDE.md)를 숙지해야 합니다.

## 기술 스택
- **언어**: Kotlin 2.3.21
- **UI**: Jetpack Compose (Material 3)
- **아키텍처**: MVVM + Clean Architecture
- **DI**: Hilt 2.59.2
- **DB**: Room 2.8.4

## 프로젝트 구조
- `app/`: 안드로이드 앱 모듈
- `.ai/`: 프로젝트 설계, 규칙, 교육 및 에이전트 가이드 자료 (가장 중요)

---
*자세한 내용은 .ai/ 폴더 내의 문서들을 참조하십시오.*
