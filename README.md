
## 미선머니플랜
자산배분 관리 앱 (Kotlin + Compose + Room)

## 기능
- 자산 목록 관리
- 배분 비율 시각화



## AGENTS.md (설계 지침서)
- AI가 코드를 작성할 때 반드시 준수해야 하는 불변의 규칙과 UI/UX 가이드라인을 담고 있습니다. (프로젝트의 헌법 역할)

## PROJECT_STATUS.md (작업 현황판)
- 현재 세션에서 무엇을 수정했는지, 
- 다음 작업은 무엇인지 등 실시간 진행 상태를 기록합니다. (AI의 단기 기억 역할)


MODEL (데이터 계층)
├── 데이터 + 비즈니스 로직
├── Room DB, API 응답
└── UI와 독립적 (순수함수)

VIEW (UI 계층)  
├── Compose 화면 (HomeScreen)
├── 사용자 입력 받기
└── ViewModel 상태만 표시

VIEWMODEL (중개자)
├── Model ←→ View 연결
├── StateFlow<State>
├── 사용자 이벤트 처리
└── 생명주기 인식
