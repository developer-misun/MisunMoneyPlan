package com.misun.misunmoneyplan.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * 자산배분 파이 차트 + 리스트 표시
 */
@Composable
fun HomeScreen(
    state: HomeUiState,
    onAssetClick: (AssetId) -> Unit, // 기본값
    //onAddAssetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "안녕하세요.")
    }
}