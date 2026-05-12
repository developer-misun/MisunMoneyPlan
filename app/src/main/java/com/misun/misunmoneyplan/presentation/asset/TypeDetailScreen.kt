package com.misun.misunmoneyplan.presentation.asset

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.misun.misunmoneyplan.domain.model.AssetType
import com.misun.misunmoneyplan.presentation.home.HomeUiState

/**
 * 특정 자산 유형(AssetType)의 상세 정보 및 포함된 종목 리스트 화면
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypeDetailScreen(
    type: AssetType,
    onBackClick: () -> Unit,
    onStockClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("${type.displayName} 상세", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "뒤로가기")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // TODO: 해당 유형의 요약 정보 및 종목 리스트 구현
            Text(text = "${type.displayName} 그룹화 정보가 표시될 예정입니다.")
        }
    }
}
