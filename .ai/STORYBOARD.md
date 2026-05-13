# 화면 맵 및 네비게이션 (Storyboard & Navigation)

이 문서는 프로젝트의 전체 화면 구조(Screen ID)와 화면 간의 이동 흐름을 정의합니다.

## 🗺️ 화면 ID 정의 (Screen ID Map)

| ID | 화면명 | 설명 | 상세 명세 |
|:---|:---|:---|:---|
| **SCR-01** | **HomeScreen** | 메인 대시보드 (자산 요약 및 목록) | [`SCR-01_HOME.md`](screens/SCR-01_HOME.md) |
| **SCR-02** | **StockDetailScreen** | 종목 상세 및 편집 | [`SCR-02_STOCK_DETAIL.md`](screens/SCR-02_STOCK_DETAIL.md) |
| **SCR-03** | **PortfolioScreen** | 포트폴리오 관리 및 리밸런싱 | [`SCR-03_PORTFOLIO.md`](screens/SCR-03_PORTFOLIO.md) |
| **SCR-04** | **TypeDetailScreen** | 유형별 필터링 상세 목록 | [`SCR-04_TYPE_DETAIL.md`](screens/SCR-04_TYPE_DETAIL.md) |

## 🔄 네비게이션 흐름 (Navigation Flow)

### 1. 메인 흐름
- **앱 시작** -> **SCR-01 (Home)**
- **SCR-01** -> (포트폴리오 아이콘 클릭) -> **SCR-03 (Portfolio)**
- **SCR-01** -> (FAB 클릭) -> **SCR-02 (StockDetail - 추가 모드)**

### 2. 상세 탐색 흐름
- **SCR-01** (종목별 탭) -> (종목 클릭) -> **SCR-02 (StockDetail)**
- **SCR-01** (유형별 탭) -> (유형 클릭) -> **SCR-04 (TypeDetail)**
- **SCR-04** -> (종목 클릭) -> **SCR-02 (StockDetail)**

### 3. 편집 및 연동
- **SCR-02** -> (저장/삭제 완료) -> **SCR-01 (Home)** 데이터 갱신 및 복귀
- **SCR-03** -> (스냅샷 저장) -> 데이터 갱신

---
*최종 업데이트: 2026-05-13*
