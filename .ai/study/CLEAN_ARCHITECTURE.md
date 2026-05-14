# 클린 아키텍처 실전 가이드 (Clean Architecture)

본 프로젝트는 코드의 유지보수성과 테스트 용이성을 극대화하기 위해 계층화된 아키텍처를 채택하고 있습니다.

## 1. 계층 분리 원칙 (Layered Structure)
- **Domain 계층**: 비즈니스 규칙의 핵심. 외부 라이브러리(Android 포함)에 의존하지 않는 순수 Kotlin 코드로 구성됩니다.
- **Data 계층**: DB(Room), 서버 연동 등 실제 데이터 접근을 담당합니다.
- **Presentation 계층**: UI(Compose) 및 상태 관리(ViewModel)를 담당합니다.

## 2. 핵심 구성 요소 및 예시

### 매퍼 (Mapper)
- **이유**: DB 엔티티와 비즈니스 모델을 분리하여 데이터 구조 변경 시 비즈니스 로직이 깨지는 것을 방지합니다.
- **실제 예시**: `com.misun.misunmoneyplan.data.mapper.AssetMapper.kt`
  ```kotlin
  fun AssetEntity.toDomain(): Asset { ... }
  ```

### 유즈케이스 (UseCase)
- **이유**: ViewModel에 집중될 수 있는 복잡한 비즈니스 계산(그룹화, 필터링 등)을 단일 책임 단위로 캡슐화합니다.
- **실제 예시**: `com.misun.misunmoneyplan.domain.usecase.GetGroupedAssetsUseCase.kt`

## 3. 참고 자료
- [Android Developers - App Architecture Guide](https://developer.android.com/topic/architecture)
- [The Clean Architecture (by Uncle Bob)](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
