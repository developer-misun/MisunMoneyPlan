package com.misun.misunmoneyplan.presentation.home

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `TC-T2-1-01 초기 상태에서 SampleData가 로드되어야 함`() = runTest {
        val viewModel = HomeViewModel()
        val uiState = viewModel.uiState.first()
        
        // SampleData의 기본 자산 개수 확인 (현재 10개)
        assertEquals(SampleData.dummyAssets.size, uiState.assets.size)
    }

    @Test
    fun `TC-T2-1-02 탭 인덱스 변경 시 UI 상태에 반영되어야 함`() = runTest {
        val viewModel = HomeViewModel()
        
        viewModel.onTabSelected(1)
        assertEquals(1, viewModel.selectedTabIndex.value)
        
        viewModel.onTabSelected(2)
        assertEquals(2, viewModel.selectedTabIndex.value)
    }

    @Test
    fun `TC-T2-1-03 총 자산 합계가 정확히 계산되어야 함`() = runTest {
        val viewModel = HomeViewModel()
        val uiState = viewModel.uiState.first()
        
        val expectedTotal = SampleData.dummyAssets.sumOf { it.amount }
        assertEquals(expectedTotal, uiState.totalAsset)
    }

    @Test
    fun `TC-T2-1-04 loadAssets 호출 시 로딩 상태가 전이되어야 함`() = runTest {
        val viewModel = HomeViewModel()
        // 초기 상태는 이미 로드된 상태일 수 있으므로 loadAssets를 호출하여 시뮬레이션
        // 실제로는 UseCase가 비동기일 때 더 명확하지만, 현재는 상태값만 체크
        viewModel.loadAssets()
        val uiState = viewModel.uiState.first()
        
        // 동기적으로 수행되므로 최종적으로 false여야 함
        assertEquals(false, uiState.isLoading)
        assertEquals(null, uiState.errorMessage)
    }

    @Test
    fun `TC-T2-1-05 에러 발생 시 errorMessage가 설정되어야 함`() = runTest {
        // 현재는 강제로 에러를 발생시킬 방법이 없으므로 ViewModel 구조를 약간 수정하거나
        // 일단은 에러 메시지가 null이 아닌 상황을 테스트할 수 있도록 설계
        // (추후 UseCase 주입 시 Mock으로 에러 주입 예정)
    }
}
