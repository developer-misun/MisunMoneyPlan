package com.misun.misunmoneyplan.presentation.home

import androidx.lifecycle.ViewModel
import com.misun.misunmoneyplan.domain.model.SortOrder
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
    private val _uiState = MutableStateFlow(HomeUiState(isLoading = true))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadAssets()
    }

    /**
     * [F1-2] 탭 전환 제어
     */
    fun onTabSelected(index: Int) {
        _selectedTabIndex.value = index
    }

    /**
     * [F1-9] 정렬 순서 토글 (내림차순 <-> 오름차순)
     */
    fun onSortOrderToggle() {
        val currentOrder = _uiState.value.sortOrder
        val newOrder = if (currentOrder == SortOrder.DESC) SortOrder.ASC else SortOrder.DESC
        _uiState.value = _uiState.value.copy(sortOrder = newOrder)
    }

    /**
     * [F1-1] 자산 목록 초기 로드 (현재는 SampleData 사용)
     */
    fun loadAssets() {
        _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
        try {
            // 추후 UseCase 연동 예정 (현재는 즉시 로드)
            _uiState.value = _uiState.value.copy(
                assets = SampleData.dummyAssets,
                isLoading = false,
                errorMessage = null
            )
        } catch (e: Exception) {
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                errorMessage = "데이터를 불러오지 못했습니다."
            )
        }
    }
}
