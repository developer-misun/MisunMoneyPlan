# 프로젝트 작업 현황 (Project Status)

## 📌 현재 단계: [Phase 1] 기초 인프라 및 도메인 모델링
- **목표**: 앱의 기반이 되는 데이터 구조와 DI, 네비게이션 체계를 안정화함.
- **최근 이슈**: KSP2 및 Hilt 버전 호환성 문제 해결 (Hilt 2.59.2 업데이트로 해결).

## ✅ 완료된 작업
- `[T2-1]` HomeViewModel 설계 및 상태 관리 구현 (완료)
    - `[F1-2]` 탭 전환 로직 및 `[F1-1]` 총 자산 계산 로직 구현
    - `HomeViewModelTest`를 통해 초기 로딩 및 탭 상태 검증 완료
    - 기능 번호 주석 표기 규칙 적용
- `[T2-3]` 종목별 뷰 고도화 (완료)
    - `AssetUiModel`에 `location` 필드 추가
    - `AssetItem`에 `LocationBadge` 적용하여 지역 정보(국내/국외) 노출
    - `SampleData` 업데이트 및 빌드 안정성 확보
- `[T3-1]` StockDetailScreen UI 및 데이터 모델 확장 (완료)
    - `Asset` 모델 및 Room 엔티티에 `location`(국내/국외) 속성 추가
    - 강조 카드 및 지역 배지 스타일을 적용한 상세 화면 구현
    - 전체 빌드 및 KSP 연동 검증 완료
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
- `[T2-1]` HomeViewModel 설계 및 상태 관리 구현
    - `[F1-2]` 탭 전환 로직 및 `[F1-4~7]` 데이터 매핑 로직 구현 중.
    - TDD 원칙에 따라 ViewModel 단위 테스트 우선 작성 예정.

## 📋 향후 작업 계획 (Next Steps)
1. **`[T2-1]` ViewModel 테스트 및 구현**: 탭 상태 변경 시 리스트 데이터가 올바르게 필터링/그룹화되는지 검증.
2. **`[T2-2]` HomeScreen 공통 UI**: 총 자산 카드 및 탭 레이아웃 고도화.
3. **`[T2-3/4]` 차트 연동**: 트리맵 및 파이 차트 컴포넌트 실제 데이터 연결.

---
*마지막 업데이트: 2026-05-11*
