# 프로젝트 작업 현황 (Project Status)

## 📌 현재 단계: [Phase 1] 기초 인프라 및 도메인 모델링
- **목표**: 앱의 기반이 되는 데이터 구조와 DI, 네비게이션 체계를 안정화함.
- **최근 이슈**: KSP2 및 Hilt 버전 호환성 문제 해결 (Hilt 2.59.2 업데이트로 해결).

## ✅ 완료된 작업
- `[T1-2]` Local DB(Room) 스키마 설계 및 DAO 구현 (완료)
    - `AssetEntity`, `AssetDao`, `AssetDatabase` 구현
    - `AssetDaoTest`를 통한 CRUD 기능 검증 완료 (3개 테스트 패스)
- `[T1-3]` Hilt 기반 의존성 주입(DI) 구조 설정
    - `MisunMoneyPlanApplication` 생성 및 `@HiltAndroidApp` 적용
    - `RepositoryModule`을 통한 인터페이스-구현체 바인딩
    - `MainActivity`에 `@AndroidEntryPoint` 적용
- **환경 설정**:
    - `compileSdk`/`targetSdk` 36 설정 및 Java 17 적용
    - `AssetType` 관련 패키지 경로 오류 수정 및 명시적 임포트 적용

## 🚧 진행 중인 작업
- `[T2-1]` HomeViewModel 및 UiState 설계
    - UI 흐름 우선 원칙에 따라 `SampleData`를 활용하여 화면 상태 관리 로직 구현 중.
    - 실제 DB 연동은 모든 화면 구성 완료 후 진행 예정.

## 📋 향후 작업 계획 (Next Steps)
1. **`[T2-1]` HomeViewModel 완성**: `SampleData`를 UI 상태로 변환하여 HomeScreen에 전달.
2. **`[T3-1]` StockDetailScreen UI**: 상세 화면 구성 및 네비게이션 연동.
3. **`[T3-2]` TypeDetailScreen UI**: 유형별 필터링 화면 구현.
4. **`[T4-1]` 데이터 레이어 고도화**: 화면 구성 완료 후 마지막 단계에서 Mapper 및 Repository 완성.

---
*마지막 업데이트: 2026-05-11*
