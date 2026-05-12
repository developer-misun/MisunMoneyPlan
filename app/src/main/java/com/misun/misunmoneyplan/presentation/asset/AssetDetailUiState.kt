package com.misun.misunmoneyplan.presentation.asset

import com.misun.misunmoneyplan.domain.model.Asset

/**
 * 자산 상세 화면의 UI 상태
 */
sealed interface AssetDetailUiState {
    object Loading : AssetDetailUiState
    
    data class Success(
        val asset: Asset,
        val isEditing: Boolean = false
    ) : AssetDetailUiState
    
    data class Error(val message: String) : AssetDetailUiState
}
