# 환경 구축 및 인계 가이드 (Setup & Handover Guide)

이 문서는 다른 PC에서 동일한 개발 환경을 구축하고 프로젝트를 안정적으로 이어나가기 위한 절차를 설명합니다.

## 1. 필수 설치 요소
- **JDK 17+**: 프로젝트 빌드 및 실행을 위한 기본 환경.
- **Android Studio (Ladybug 이상 권장)**: 최신 Gradle 및 Kotlin 버전 대응.
- **Git**: 소스 코드 버전 관리.

## 2. 프로젝트 설정 절차

### 소스 코드 체크아웃
```bash
git clone [repository_url]
cd MisunMoneyPlan
```

### IDE 설정
1. Android Studio에서 `Open` 메뉴를 통해 프로젝트 루트 폴더를 선택합니다.
2. Gradle Sync가 완료될 때까지 대기합니다.
3. `Settings > Build, Execution, Deployment > Build Tools > Gradle`에서 JDK 버전이 17 이상으로 설정되어 있는지 확인합니다.

## 3. 핵심 기술 스택 및 버전
- **Kotlin**: 2.3.21
- **Gradle**: 9.5.0
- **Android Gradle Plugin (AGP)**: 9.2.1
- **Hilt**: 2.59.2
- **Room**: 2.8.4
- **Compose**: 최신 안정 버전 (BOM 관리)

## 4. 빌드 및 테스트 확인
정상적으로 세팅되었는지 확인하기 위해 다음 명령어를 수행합니다.
```bash
./gradlew compileDebugKotlin  # 빌드 성공 확인
./gradlew test               # 단위 테스트 성공 확인
```

## 5. 협업 도구 및 문서 (.ai/)
이 프로젝트는 `.ai/` 폴더 내의 문서들을 통해 모든 진행 상황과 규칙을 관리합니다. 새로운 환경에서도 `AGENTS.md`를 기점으로 기존 작업 이력과 설계 명세를 반드시 확인해야 합니다.

---
*최종 업데이트: 2026-05-13*
