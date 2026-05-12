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
    - 현재 `HomeViewModel`은 빈 클래스 상태.
    - `GetAssetsUseCase`를 연동하여 실제 데이터를 Flow로 관리하도록 구현 예정.

## 📋 향후 작업 계획 (Next Steps)
1. **`[T1-1/2]` 데이터 레이어 완성**: Room DB 엔티티 설계 및 `AssetDao` 구현.
2. **`[T2-1]` HomeViewModel 고도화**: UI 상태 모델(`HomeUiState`)과 실제 데이터 연동.
3. **`[F1-4]` 자산 추가 기능**: FAB 클릭 시 간단한 입력을 받을 수 있는 BottomSheet 또는 Dialog 구현.
4. **UI 컴포넌트 정리**: `presentation/components/` 내 중복된 차트 및 카드 컴포넌트 통합.

---
*마지막 업데이트: 2026-05-11*
