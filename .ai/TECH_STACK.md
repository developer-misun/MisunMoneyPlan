# 프로젝트 기술 스택 및 학습 가이드 (Tech Stack & Study Guide)

이 문서는 MisunMoneyPlan 프로젝트에 도입된 핵심 라이브러리와 플러그인의 역할, 도입 배경 및 학습 포인트를 정리합니다.

## 🛠️ 핵심 라이브러리 (Dependencies)

### 1. Jetpack Compose
- **목적**: 선언형 UI 프레임워크로 현대적인 안드로이드 UI 구현.
- **핵심 개념**: Composable 함수, State(상태) 기반 렌더링, Recomposition.
- **학습 포인트**: `State`와 `Remember`의 차이, `Canvas`를 이용한 커스텀 드로잉(트리맵/도넛 차트).
- **추천 리소스**: [Android Developers - Jetpack Compose Guide](https://developer.android.com/jetpack/compose)

### 2. Dagger Hilt (v2.59.2)
- **목적**: 의존성 주입(Dependency Injection) 자동화 및 객체 생명주기 관리.
- **도입 배경**: 수동 DI의 복잡함을 해결하고, 테스트 코드 작성 시 Mock 객체 주입을 용이하게 하기 위함.
- **학습 포인트**: `@HiltAndroidApp`, `@AndroidEntryPoint`, `@Inject`, `@Module`/`@Binds`를 이용한 인터페이스 바인딩.
- **추천 리소스**: [Hilt Dependency Injection Guide](https://developer.android.com/training/dependency-injection/hilt-android)

### 3. Room DB (v2.8.4)
- **목적**: SQLite 상위의 추상화 레이어로 로컬 데이터 영속성 관리.
- **핵심 개념**: Entity(테이블), DAO(쿼리 인터페이스), Database(진입점).
- **학습 포인트**: Flow를 활용한 DB 데이터 실시간 관찰, TypeConverter를 이용한 Enum 처리.
- **추천 리소스**: 
    - [Room Persistence Library Guide](https://developer.android.com/training/data-storage/room)
    - [Google Codelabs - Testing Room Database](https://developer.android.com/codelabs/android-room-with-a-view-kotlin#10)

### 4. Kotlin Coroutines & Flow
- **목적**: 비동기 프로그래밍 및 멀티스레딩 관리.
- **핵심 개념**: Suspend 함수, CoroutineScope, Dispatchers.
- **학습 포인트**: `StateFlow`와 `SharedFlow`의 차이점, `collectAsStateWithLifecycle()`을 이용한 안전한 데이터 수집.
- **추천 리소스**: [Kotlin Flows on Android Guide](https://developer.android.com/kotlin/flow)

## 🔌 빌드 플러그인 (Plugins)

### 1. KSP (Kotlin Symbol Processing) - v2.3.7
- **목적**: 주석 처리(Annotation Processing)를 위한 차세대 도구.
- **장점**: KAPT 대비 빌드 속도가 빠르고 Kotlin 코드에 최적화됨.
- **특이사항**: 본 프로젝트는 Kotlin 2.3.21과 KSP2 환경을 사용하여 최신 분석 엔진을 활용함.
- **추천 리소스**: [KSP Overview](https://kotlinlang.org/docs/ksp-overview.html)

### 2. Android Gradle Plugin (AGP) - v9.2.1
- **목적**: 안드로이드 앱 빌드 시스템 관리.
- **특이사항**: 실험적인 9.x 버전을 사용하여 최신 빌드 최적화 기능을 테스트함.
- **추천 리소스**: [Android Gradle Plugin Release Notes](https://developer.android.com/build/releases/gradle-plugin)

---
*마지막 업데이트: 2026-05-12*
