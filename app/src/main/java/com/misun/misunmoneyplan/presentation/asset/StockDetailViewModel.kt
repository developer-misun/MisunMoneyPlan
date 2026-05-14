package com.misun.misunmoneyplan.presentation.asset

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * [SCR-02] 종목 상세 화면의 상태 관리
 */
@HiltViewModel
class StockDetailViewModel @Inject constructor() : ViewModel() {

    // 현재는 껍데기 구현을 위해 최소한의 상태만 정의
    private val _assetName = MutableStateFlow("삼성전자")
    val assetName: StateFlow<String> = _assetName.asStateFlow()

    /**
     * 특정 자산 ID로 데이터 로드 (추후 구현)
     */
    fun loadAsset(assetId: String) {
        // 비즈니스 로직 연동 예정
    }
}
