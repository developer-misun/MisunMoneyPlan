package com.misun.misunmoneyplan.presentation.asset

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.misun.misunmoneyplan.domain.model.Asset
import com.misun.misunmoneyplan.domain.usecase.GetAssetByIdUseCase
import com.misun.misunmoneyplan.domain.usecase.UpdateAssetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 자산 상세 및 편집 로직을 담당하는 ViewModel
 */
@HiltViewModel
class AssetDetailViewModel @Inject constructor(
    private val getAssetByIdUseCase: GetAssetByIdUseCase,
    private val updateAssetUseCase: UpdateAssetUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<AssetDetailUiState>(AssetDetailUiState.Loading)
    val uiState: StateFlow<AssetDetailUiState> = _uiState.asStateFlow()

    /**
     * 특정 자산 데이터를 로드한다.
     */
    fun loadAsset(assetId: String) {
        viewModelScope.launch {
            _uiState.value = AssetDetailUiState.Loading
            val asset = getAssetByIdUseCase(assetId)
            if (asset != null) {
                _uiState.value = AssetDetailUiState.Success(asset)
            } else {
                _uiState.value = AssetDetailUiState.Error("자산을 찾을 수 없습니다.")
            }
        }
    }

    /**
     * 자산 정보를 업데이트한다.
     */
    fun updateAsset(updatedAsset: Asset) {
        viewModelScope.launch {
            updateAssetUseCase(updatedAsset)
            _uiState.value = AssetDetailUiState.Success(updatedAsset, isEditing = false)
        }
    }
    
    /**
     * 편집 모드 전환
     */
    fun setEditing(isEditing: Boolean) {
        val currentState = _uiState.value
        if (currentState is AssetDetailUiState.Success) {
            _uiState.value = currentState.copy(isEditing = isEditing)
        }
    }
}
