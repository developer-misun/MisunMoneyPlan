package com.misun.misunmoneyplan.presentation.asset

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.misun.misunmoneyplan.domain.model.Asset
import com.misun.misunmoneyplan.domain.model.AssetLocation
import com.misun.misunmoneyplan.presentation.components.LocationBadge
import com.misun.misunmoneyplan.presentation.home.color
import java.text.NumberFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockDetailScreen(
    assetId: String,
    viewModel: AssetDetailViewModel,
    onBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

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
                        IconButton(onClick = { /* TODO: 수정 화면으로 이동 */ }) {
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
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is AssetDetailUiState.Success -> {
                    StockDetailContent(asset = state.asset)
                }
                is AssetDetailUiState.Error -> {
                    Text(
                        text = state.message,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun StockDetailContent(asset: Asset) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // 1. 강조 카드 (종목명, 지역 태그, 금액)
        item {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = asset.type.color.copy(alpha = 0.1f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = asset.name,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                        LocationBadge(location = asset.location)
                    }
                    
                    Text(
                        text = formatCurrency(asset.amount),
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    
                    if (asset.memo.isNotEmpty()) {
                        Text(
                            text = asset.memo,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // 2. 그래프 영역 (Placeholder)
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray.copy(alpha = 0.2f))
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("주가 추이 그래프 (준비 중)", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }

        // 3. 히스토리 섹션 타이틀
        item {
            Text(
                text = "거래 히스토리",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        // 4. 히스토리 목록 (Placeholder)
        items(5) { index ->
            OutlinedCard(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(text = "업데이트 #$index", fontWeight = FontWeight.Medium)
                        Text(text = "26.05.${12-index}", style = MaterialTheme.typography.labelSmall)
                    }
                    Text(text = formatCurrency(asset.amount), fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

private fun formatCurrency(amount: Long): String {
    val format = NumberFormat.getCurrencyInstance(Locale.KOREA)
    return format.format(amount)
}
