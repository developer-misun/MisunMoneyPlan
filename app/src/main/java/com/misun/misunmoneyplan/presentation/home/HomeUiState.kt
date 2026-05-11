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


data class AssetUiModel(
    val id: AssetId,
    val name: String,
    val amount: Long,
    val percent: Float,
    val color: Color
)

