# 기술 스택 및 학습 로드맵 (Tech Stack & Study)

이 문서는 프로젝트에 도입된 기술과 검토 중인 기술의 원리를 정리하고 학습 상태를 관리합니다.

## ✅ 1. 현재 적용된 기술 (Current)

### 🚀 Jetpack Compose
- **목적**: 선언형 UI 프레임워크로 현대적인 안드로이드 UI 구현.
- **핵심 개념**: Composable 함수, State(상태) 기반 렌더링, Recomposition.
- **학습 포인트**: `State`와 `Remember`의 차이, `Canvas`를 이용한 커스텀 드로잉(트리맵/도넛 차트).

### 🛠 Kotlin Coroutines
- **목적**: 비동기 프로그래밍 및 멀티스레딩 관리.
- **핵심 개념**: Suspend 함수, CoroutineScope, Dispatchers.
- **학습 포인트**: UI 스레드 방해 없이 데이터를 로드하는 흐름(`collect`).

---

## 🔍 2. 검토 중인 기술 (Under Review)

### ① Hilt (의존성 주입)
- **도입 목적**: 객체 간의 결합도를 낮추고 유지보수 및 테스트 용이성 확보.
- **핵심 원리**: 필요한 객체를 직접 생성하지 않고 외부(Hilt)에서 주입받는 방식(DI).
- **학습 링크**: [안드로이드 공식 Hilt 가이드](https://developer.android.com/training/dependency-injection/hilt-android)

### ② Room (로컬 DB)
- **도입 목적**: 자산 데이터를 스마트폰 내부에 영구적으로 저장.
- **핵심 원리**: SQLite를 추상화하여 안전하게 데이터베이스 작업을 수행.
- **학습 링크**: [Room을 사용하여 로컬 데이터베이스에 데이터 저장](https://developer.android.com/training/data-storage/room)

### ③ Jetpack Navigation (화면 전환)
- **도입 목적**: 여러 화면(Home, Detail 등) 간의 이동 및 데이터 전달 관리.
- **핵심 원리**: 하나의 Activity에서 여러 Composable 화면을 교체하는 방식.
- **학습 링크**: [Compose를 사용한 탐색](https://developer.android.com/jetpack/compose/navigation)

---

## 📅 3. 추후 검토 예정 (Future)
- **Retrofit2**: 외부 금융 데이터 API 연동을 위한 통신 라이브러리.
- **Coil**: 자산 아이콘 등 이미지 로딩 최적화 라이브러리.

---
*최종 업데이트: 2026-05-11*
