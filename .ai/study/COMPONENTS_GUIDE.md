# 공통 컴포넌트 가이드 (Components Guide)

이 문서는 프로젝트 전반에서 사용되는 재사용 가능한 UI 컴포넌트의 목적과 사용법을 설명합니다.

## 1. 개요
모든 공통 컴포넌트는 `com.misun.misunmoneyplan.presentation.components` 패키지에 위치하며, Jetpack Compose로 구현되어 있습니다.

## 2. 주요 컴포넌트 목록

### TotalAssetCard
- **목적**: 사용자의 총 자산 합계를 강조하여 보여주는 카드.
- **주요 매개변수**: `totalAmount: Long`
- **위치**: `TotalAssetCard.kt`

### LocationBadge
- **목적**: 자산의 지역(국내/국외)을 나타내는 작은 태그 배지.
- **주요 매개변수**: `location: AssetLocation`
- **위치**: `LocationBadge.kt`

### TreemapChart
- **목적**: 종목별 비중을 면적으로 시각화하는 커스텀 차트.
- **주요 매개변수**: `assets: List<AssetUiModel>`, `totalAmount: Long`
- **위치**: `TreemapChart.kt`

### PieChart
- **목적**: 유형별/지역별 비중을 나타내는 도넛 모양의 차트.
- **주요 매개변수**: `assets: List<AssetUiModel>`, `totalAmount: Long`
- **위치**: `PieChart.kt`

### StockAssetList / TypeAssetList
- **목적**: 자산 목록을 리스트 형태로 표시 (종목별/유형별 특화).
- **위치**: `StockAssetList.kt`, `TypeAssetList.kt`

## 3. 개발 규칙
- **Preview 필수**: 새로운 컴포넌트 추가 시 반드시 `@Preview`를 작성하여 독립적인 확인이 가능하게 합니다.
- **Stateless 지향**: 내부 상태를 가지지 않고 외부에서 데이터를 주입받는 구조를 유지합니다.

---
*최종 업데이트: 2026-05-13*
