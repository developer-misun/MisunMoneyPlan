# SCR-02: StockDetailScreen (종목 상세 및 편집)

개별 자산의 세부 정보를 조회하고 정보를 수정하거나 삭제하는 화면입니다.

**현재 상태: UI 껍데기 구현 완료 (Phase 3-1)**
- [x] 기본 레이아웃 구성 (Scaffold, TopBar, BottomBar)
- [x] 상단 강조 카드 UI 구현
- [x] 네비게이션 연동 확인용 ViewModel 연결
- [ ] 실제 데이터 로드 및 주가 추이 그래프 구현 예정

## 기능 명세 (Functional Units)

- **`[F2-1]` 상세 정보 조회**: 종목명, 금액, 유형, 지역(국내/국외), 메모 노출.
- **`[F2-2]` 정보 편집 기능**: 금액, 메모, 지역 등 필드 수정 기능. (숫자 키패드 연동)
- **`[F2-3a]` 자산 저장**: 수정된 내용을 DB에 영구 반영.
- **`[F2-3b]` 자산 삭제**: 해당 자산을 목록에서 영구 제거.

## UI/UX 디자인 가이드

### 레이아웃 구성
1. **상단 강조 카드**: 종목의 테마 색상을 배경으로 한 `ElevatedCard`.
   - 종목명 + 지역 배지 + 총액 (HeadlineMedium).
2. **시각화 영역**: 주가 추이 그래프 (LineGraph Placeholder).
3. **히스토리 영역**: 업데이트 이력 리스트 (`OutlinedCard` 기반).
4. **BottomBar**: "삭제" 및 "저장" 버튼 배치.

### 컴포넌트 스타일
- **LocationBadge**:
    - 국내(DOMESTIC): `OutlineVariant` (30% Alpha) 배경.
    - 국외(OVERSEAS): `PrimaryContainer` (50% Alpha) 배경.

---
*마지막 업데이트: 2026-05-13*
