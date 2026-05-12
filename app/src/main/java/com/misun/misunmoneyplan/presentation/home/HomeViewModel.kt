package com.misun.misunmoneyplan.presentation.home


import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * 메인 대시보드 상태 관리 및 비즈니스 로직 연동
 */
@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    // [F1-2] 메인 탭 네비게이션 상태 (0: 종목별, 1: 유형별, 2: 지역별)
    private val _selectedTabIndex = MutableStateFlow(0)
    val selectedTabIndex: StateFlow<Int> = _selectedTabIndex.asStateFlow()

    // [F1-1] 전체 자산 상태 관리
    private val _uiState = MutableStateFlow(HomeUiState(assets = SampleData.dummyAssets))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    /**
     * [F1-2] 탭 전환 제어
     */
    fun onTabSelected(index: Int) {
        _selectedTabIndex.value = index
    }

    /**
     * [F1-1] 자산 목록 초기 로드 (현재는 SampleData 사용)
     */
    fun loadAssets() {
        // 추후 UseCase 연동 예정
        _uiState.value = HomeUiState(assets = SampleData.dummyAssets)
    }
}
