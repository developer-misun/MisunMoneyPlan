# UI/UX 디자인 명세서 (Design Specifications)

## 🎨 1. 기초 스타일 (Foundations)

### 🎨 색상 팔레트 (Color Palette)
- **Primary**: `#6750A4` (주요 강조색)
- **Background**: `#F8F9FA` (화면 전체 배경 - 연한 그레이)
- **Surface**: `#FFFFFF` (카드 및 주요 콘텐츠 배경 - 순백색)
- **Outline**: MaterialTheme Outline 색상 (보조 텍스트 및 구분선)
- **Asset Types**:
    - CASH: `#81C784` (초록)
    - STOCK: `#E57373` (빨강)
    - ETF: `#FFFFB74D` (주황)
    - COIN: `#64B5F6` (파랑)
    - ETC: `#BA68C8` (보라)

### ✍️ 타이포그래피 (Typography)
- **Headlines**: `HeadlineMedium` (Bold) - 총 자산 금액 등 중요 수치.
- **Titles**: `TitleMedium` (Bold) - 섹션 타이틀.
- **Body**: `BodyLarge` (Medium/Regular) - 자산 명칭, 리스트 항목.
- **Labels**: `LabelSmall` (10.sp) - 업데이트 날짜 등 부가 정보.

### 📏 간격 및 레이아웃 (Spacing & Layout)
- **화면 패딩**: 기본 `16.dp`.
- **컴포넌트 간격**: 주요 섹션 간 `24.dp`, 리스트 항목 간 `12.dp`.

---

## 🧩 2. 주요 컴포넌트 명세 (Components)

### 📊 차트 (Charts)
#### 트리맵 (Treemap Chart)
- **용도**: 종목별 비중 시각화.
- **스타일**: 0.5dp 두께의 흰색(`Color.White.copy(alpha = 0.5f)`) 구분선 적용.
- **텍스트**: 영역 중앙에 종목명 및 비율(%) 표시. 공간 부족 시 자동 생략.

#### 도넛 차트 (Donut Chart)
- **용도**: 유형별 비중 시각화.
- **스타일**: 두께 `100f`, 완전한 정원(Square 영역) 유지.
- **텍스트**: 각 섹션 중앙에 비율(%) 표시. 흰색 텍스트에 투명도 50%의 검정 그림자 적용.


### 그래프 (Graph)
#### 선그래프
- **용도**: 자산 증가 추이 (월별)
- **입력**: List<StockAssetItem>
- **스타일**: 
    - 선: 4.dp 그라데이션 (Blue→Purple)
    - 포인트: 12.dp 원형 터치
    - X축: "25.01"~"26.05"
    - Y축: "10억"~"20억"
- **텍스트**:


 

### 🗂 자산 리스트 항목 (Asset List Items)
- **카드 스타일**: `ElevatedCard`, Elevation `2.dp`.
- **불릿(Bullet)**: 좌측에 44dp 크기의 원형 불릿 배치. 배경색은 `AssetType.color`.
- **내부 텍스트**: 불릿 중앙에 흰색 굵은 글씨로 비중(%) 표기.
- **업데이트 정보**: `StockAssetItem` 한정 우측 상단에 `yy.MM.dd` 형식 노출.

---

## 📱 3. 화면별 UI 구성 (Screens)

### HomeScreen (대시보드)
- **시각적 계층**: `TotalAssetCard`(강조) -> `TabRow` -> `Chart` -> `List Title` -> `AssetList`.
- **상호작용**: 
    - '종목별' 탭: 항목 클릭 시 `StockDetailScreen` 이동.
    - '유형별' 탭: 항목 클릭 시 `TypeDetailScreen` 이동.

### StockDetailScreen (종목 상세)
- **주요 요소**: 상단 종목요약, , 주식인 경우 종가 그래프,  일자별 히스토리 목록 
- **시각적 계층**: 종목카드 (강조) -> `Graph` -> `List Title` -> `AssetList`
- **상호작용**: 종목명 클릭 시 `AssetEditScreen`  이동.
- **스타일**:  

┌─────────────────────────────────────┐
│ 삼성전자 (AssetType.color)         │ ← 강조카드
│ 8.5억 (33%) ↑12.3%                │
├─────────────────────────────────────┤
│ [LineGraph: 종가추이]              │ ← 250.dp
├─────────────────────────────────────┤
│ 히스토리 (TitleLarge)             │
└─────────────────────────────────────┘
└── AssetList (거래내역)


### AssetEditScreen (자산 등록 관리)
- **주요 요소**: 종목명, 현재가/보유수량/총액 정보, 자산유형 태그, 업데이트 기록, 수정/삭제 버튼.
- **스타일**: 수정 가능 필드는 명확한 입력 폼(TextField) 스타일 적용.


### TypeDetailScreen (유형 상세)
- **주요 요소**: 유형 요약(총액, 비중), 해당 유형 내 종목 리스트(`StockAssetList` 재사용).
- **스타일**: 상단에 해당 유형의 테마 색상을 강조색으로 사용.

┌─────────────────────────────────────┐
│ 현금 (Green 배경)                  │ ← AssetType.color
│ 총 6.4억 (25%)                    │
├─────────────────────────────────────┤
│ 현금예금 │ 3,200만 │ 12.5%        │
│ 적금     │ 3,200만 │ 12.5%        │
└─────────────────────────────────────┘

### MyPortPolio 포트폴리오 관리 
- 유형별 포트폴리오를 만들어 실제 자산현황과 비교하는데 사용한다. 
- 분기별로 관리 
- 현재는 도넛 차트로 보여주고 흐름은 선그래프로 표기 

---
*최종 업데이트: 2026-05-11*
