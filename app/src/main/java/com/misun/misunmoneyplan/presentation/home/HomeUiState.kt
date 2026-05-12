package com.misun.misunmoneyplan.presentation.home

import androidx.compose.ui.graphics.Color
import com.misun.misunmoneyplan.domain.model.AssetType
import com.misun.misunmoneyplan.domain.model.AssetLocation

// data class (UI 전용 상태)
typealias AssetId = String

/**
 * AssetType에 대응하는 테마 색상을 반환하는 확장 프로퍼티
 */
val AssetType.color: Color
    get() = when (this) {
        AssetType.CASH -> Color(0xFF81C784)
        AssetType.STOCK -> Color(0xFFE57373)
        AssetType.ETF -> Color(0xFFFFB74D)
        AssetType.COIN -> Color(0xFF64B5F6)
        AssetType.ETC -> Color(0xFFBA68C8)
    }

data class HomeUiState(
    val name: String = "test",
    val assets: List<AssetUiModel> = emptyList(),
    val isLoading: Boolean = false
) {
    val totalAsset: Long = assets.sumOf { it.amount }
}



data class AssetUiModel(
    val id: AssetId,
    val name: String,
    val type: AssetType,
    val location: AssetLocation,
    val amount: Long,
    val updatedAt: Long,
    val color: Color = type.color
)

