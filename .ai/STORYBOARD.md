# 스토리보드 및 화면 흐름 (Storyboard)

## 🗺️ 전체 화면 맵 (Screen Map)

### 1. HomeScreen (메인 대시보드)
- **기능 요약**: 사용자의 전체 자산 현황을 한눈에 파악하는 화면
- **상세 기능**:
    - `[F1-1]` **총 자산 카드**: 현재 보유한 모든 자산의 합계를 통화 형식으로 표시
    - `[F1-2]` **자산 시각화 (탭 전환)**:
        - **종목별(Treemap)**: 비중에 따른 사각형 크기로 자산 분포 시각화
        - **유형별(Pie Chart)**: 자산 유형(현금, 주식 등) 비율 시각화
    - `[F1-3]` **자산 리스트**:
        - **종목 리스트**: 개별 자산 명칭, 금액, 비중 표시 (클릭 시 `StockDetailScreen` 이동)
        - **유형 리스트**: 유형별 합계, 비중 표시 (클릭 시 `TypeDetailScreen` 이동)
    - `[F1-4]` **자산 추가**: FAB 클릭 시 빠른 추가 다이얼로그 노출

### 2. StockDetailScreen (종목 상세 및 편집)
- **기능 요약**: 특정 종목의 상세 정보를 확인하고 수정/삭제하는 화면
- **상세 기능**:
    - `[F2-1]` **상세 정보 표시**: 종목명, 현재가(금액), 유형, 메모, 최종 업데이트일 노출
    - `[F2-2]` **수정 모드**: 금액 및 메모 수정 기능, 저장 시 유효성 검사
    - `[F2-3]` **삭제 기능**: 해당 종목을 자산 목록에서 제거

### 3. TypeDetailScreen (유형별 상세)
- **기능 요약**: 특정 카테고리(예: 주식)에 속한 자산들만 모아서 보는 화면
- **상세 기능**:
    - `[F3-1]` **유형 통계**: 해당 유형의 총액 및 전체 자산 대비 비중 표시
    - `[F3-2]` **그룹 리스트**: 해당 유형에 속한 모든 종목 리스트 노출

## 🔄 네비게이션 흐름 (User Flow)

- **Entry**: 앱 실행 -> `HomeScreen`
- **View Stock Detail**: `HomeScreen` (종목별 탭) -> 종목 클릭 -> `StockDetailScreen`
- **View Type Detail**: `HomeScreen` (유형별 탭) -> 유형 클릭 -> `TypeDetailScreen`
- **Edit & Sync**: `StockDetailScreen` -> 수정/저장 -> `HomeScreen`으로 돌아가며 데이터 갱신
- **Add**: `HomeScreen` -> FAB 클릭 -> 추가 팝업 -> 완료 -> 리스트 자동 갱신

## 🛠️ 작업 단위 (Task Units)

### [Phase 1] 기초 인프라 및 도메인 모델링
- `[T1-1]` 자산(Asset) 및 자산유형(AssetType) 도메인 모델 확정
- `[T1-2]` Local DB(Room) 스키마 설계 및 Repository 인터페이스 정의
- `[T1-3]` Hilt 기반 의존성 주입(DI) 구조 완성 (완료)

### [Phase 2] 메인 대시보드 (HomeScreen) 흐름 완성
- `[T2-1]` HomeViewModel 및 UiState 설계 (진행 중 - SampleData 활용)
- `[T2-2]` 총 자산 카드 및 공통 UI 컴포넌트 고도화
- `[T2-3]` Treemap 및 Pie Chart 시각화 로직 구현
- `[T2-4]` 탭 전환 및 리스트 연동

### [Phase 3] 상세 및 관리 화면 완성
- `[T3-1]` StockDetailScreen UI 및 데이터 전달 로직
- `[T3-2]` TypeDetailScreen UI 및 필터링 로직
- `[T3-3]` 네비게이션 흐름 연결 및 화면 전환 검증

### [Phase 4] 데이터 레이어 아키텍처 완성 (최종 단계)
- `[T4-1]` AssetMapper 도입 및 Domain/Data 모델 격리
- `[T4-2]` Repository 실제 DB 연동 (가짜 데이터 제거)
- `[T4-3]` 전체 비즈니스 로직 검증 및 통합 테스트

---
