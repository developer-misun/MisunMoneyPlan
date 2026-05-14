# 리소스 관리 전략 가이드 (Resource Strategy)

하드코딩을 배제하고 유지보수와 일관성을 확보하기 위한 문자열 및 테마 관리 원칙을 설명합니다.

## 1. 하드코딩 금지 규칙
- 모든 사용자 노출 문자열은 반드시 `res/values/strings.xml`에 정의해야 합니다.
- 색상, 폰트 크기 등은 Compose의 `MaterialTheme`과 연동된 테마 시스템을 사용합니다.

## 2. 실제 구현 예시

### strings.xml 활용
- **위치**: `app/src/main/res/values/strings.xml`
  ```xml
  <string name="home_title">자산 관리</string>
  <string name="home_list_count_format">%d개 항목</string>
  ```

### Compose에서 참조
- **위치**: `com.misun.misunmoneyplan.presentation.home.HomeScreen.kt`
  ```kotlin
  Text(text = stringResource(R.string.home_title))
  ```

## 3. 이점
- **일관성**: 동일한 단어를 여러 곳에서 일관되게 표현할 수 있습니다.
- **다국어 대응**: 추후 `values-en/strings.xml` 추가만으로 쉽게 글로벌 대응이 가능합니다.
- **테마 변경**: 색상 상수를 한곳에서 수정하여 앱 전체의 톤을 바꿀 수 있습니다.
