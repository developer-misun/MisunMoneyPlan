package com.misun.misunmoneyplan.presentation.asset

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * 개별 종목의 상세 정보 및 편집 화면
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockDetailScreen(
    assetId: String,
    viewModel: AssetDetailViewModel,
    onBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    // 화면 진입 시 데이터 로드
    LaunchedEffect(assetId) {
        viewModel.loadAsset(assetId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("종목 상세", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "뒤로가기")
                    }
                },
                actions = {
                    if (uiState is AssetDetailUiState.Success) {
                        IconButton(onClick = { viewModel.setEditing(true) }) {
                            Icon(Icons.Default.Edit, contentDescription = "수정")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (val state = uiState) {
                is AssetDetailUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
                is AssetDetailUiState.Success -> {
                    StockDetailContent(
                        asset = state.asset,
                        isEditing = state.isEditing
                    )
                }
                is AssetDetailUiState.Error -> {
                    Text(text = state.message, color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }
}

@Composable
fun StockDetailContent(
    asset: com.misun.misunmoneyplan.domain.model.Asset,
    isEditing: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // TODO: 상세 UI 구성 (종목명, 금액, 메모 등)
        Text(text = "종목명: ${asset.name}", style = MaterialTheme.typography.headlineSmall)
        Text(text = "현재가: ${asset.amount}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "메모: ${asset.memo}")
    }
}
