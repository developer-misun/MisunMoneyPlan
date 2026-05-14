# UI/UX 디자인 시스템 (Design System)

이 문서는 프로젝트 전반에 적용되는 시각적 스타일과 공통 UI 가이드라인을 정의합니다. 화면별 상세 구성은 `screens/` 폴더 내 개별 문서를 참조하십시오.

## 1. 기초 스타일 (Foundations)

### 색상 팔레트 (Color Palette)
- **Primary**: `#6750A4` (주요 강조색)
- **Background**: `#F8F9FA` (화면 전체 배경)
- **Surface**: `#FFFFFF` (카드 및 주요 콘텐츠 배경)
- **Outline**: MaterialTheme Outline (보조 텍스트 및 구분선)

### 자산 유형별 테마색 (Asset Type Colors)
- **CASH**: `#81C784` (초록)
- **STOCK**: `#E57373` (빨강)
- **ETF**: `#FFFFB74D` (주황)
- **COIN**: `#64B5F6` (파랑)
- **ETC**: `#BA68C8` (보라)

### 지역 속성 배지 (Location Badges)
- **국내(DOMESTIC)**: `OutlineVariant` 배경 (30% 투명도)
- **국외(OVERSEAS)**: `PrimaryContainer` 배경 (50% 투명도)

### 타이포그래피 (Typography)
- **Headlines**: `HeadlineMedium` (Bold) - 총 자산 금액 등 중요 수치.
- **Titles**: `TitleMedium` (Bold) - 섹션 타이틀.
- **Body**: `BodyLarge` (Medium/Regular) - 자산 명칭, 리스트 항목.
- **Labels**: `LabelSmall` (10.sp) - 부가 정보.

---

## 2. 공통 컴포넌트 명세 (Common Components)

### 시각화 (Visualization)
- **트리맵 (Treemap)**: 종목별 비중 시각화. 흰색 구분선(50% Alpha) 적용.
- **도넛 차트 (Donut)**: 유형/지역별 비중 시각화. 두께 `100f` 고정.
- **선 그래프 (Line Graph)**: 자산/주가 추이. 그라데이션 선 및 포인트 강조.

### 리스트 및 카드 (List & Card)
- **AssetItem**: `OutlinedCard` 기반. 44dp 원형 불릿(타입색) + 비중(%) 포함.
- **Action Buttons**: 
  - 긍정/저장: `Button` (Filled)
  - 부정/삭제: `TextButton` (Error 색상)
  - 보조/스냅샷: `OutlinedButton`

---
*최종 업데이트: 2026-05-14*
