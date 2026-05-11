package com.misun.misunmoneyplan.presentation.home

import androidx.compose.ui.graphics.Color

// data class (UI 전용 상태)
typealias AssetId = String



//data class Message(val author: String, val body: String)

data class HomeUiState(
    val name : String = "test",
    val totalAsset: Long = 0L,
    val assets: List<AssetUiModel> = emptyList(),
    val isLoading: Boolean = false
)



enum class AssetType(val displayName: String, val color: Color) {
    CASH("현금", Color(0xFF81C784)),
    STOCK("주식", Color(0xFFE57373)),
    ETF("ETF", Color(0xFFFFB74D)),
    COIN("코인", Color(0xFF64B5F6)),
    ETC("기타", Color(0xFFBA68C8))
}

data class AssetUiModel(
    val id: AssetId,
    val name: String,
    val type: AssetType,
    val amount: Long,
    val percent: Float,
    val color: Color = type.color
)

