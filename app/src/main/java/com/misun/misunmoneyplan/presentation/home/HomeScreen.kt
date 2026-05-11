package com.misun.misunmoneyplan.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misun.misunmoneyplan.presentation.components.*
import com.misun.misunmoneyplan.presentation.ui.theme.MisunMoneyPlanTheme

/**
 * 자산배분 파이 차트 + 리스트 표시
 * 전체적인 화면 레이아웃과 상태 전환(탭 전환) 로직만 담당
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeUiState,
    onAssetClick: (AssetId) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("종목별", "유형별")

    val displayAssets = if (selectedTabIndex == 0) {
        state.assets.sortedByDescending { it.amount }
    } else {
        state.assets.groupBy { it.type }.map { (type, items) ->
            AssetUiModel(
                id = type.name,
                name = type.displayName,
                type = type,
                amount = items.sumOf { it.amount },
                updatedAt = items.maxOfOrNull { it.updatedAt } ?: 0L,
                color = type.color
            )
        }.sortedByDescending { it.amount }
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("자산 관리", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: 자산 추가 기능 */ }) {
                Icon(Icons.Default.Add, contentDescription = "자산 추가")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 총 자산 정보
            TotalAssetCard(state.totalAsset)

            Spacer(modifier = Modifier.height(16.dp))

            // 탭 메뉴
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.primary,
                divider = {}
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(text = title) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 차트 섹션
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                if (selectedTabIndex == 0) {
                    TreemapChart(
                        assets = displayAssets,
                        totalAmount = state.totalAsset,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    PieChart(
                        assets = displayAssets,
                        totalAmount = state.totalAsset
                    )
                    Text(
                        text = tabs[selectedTabIndex],
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 자산 리스트 섹션 타이틀
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (selectedTabIndex == 0) "상위 자산 목록" else "유형 목록",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                val listAssets = if (selectedTabIndex == 0) displayAssets.take(10) else displayAssets
                Text(
                    text = "${listAssets.size}개 항목",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            if (selectedTabIndex == 0) {
                StockAssetList(
                    assets = displayAssets.take(10),
                    totalAmount = state.totalAsset,
                    onAssetClick = onAssetClick
                )
            } else {
                TypeAssetList(
                    assets = displayAssets,
                    totalAmount = state.totalAsset
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MisunMoneyPlanTheme {
        HomeScreen(
            state = SampleData.dummyState,
            onAssetClick = {}
        )
    }
}
