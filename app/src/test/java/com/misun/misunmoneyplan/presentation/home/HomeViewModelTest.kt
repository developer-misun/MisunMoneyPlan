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
}
