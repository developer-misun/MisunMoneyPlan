package com.misun.misunmoneyplan.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misun.misunmoneyplan.domain.model.AssetType
import com.misun.misunmoneyplan.presentation.components.TotalAssetCard
import com.misun.misunmoneyplan.presentation.components.TreemapChart
import com.misun.misunmoneyplan.presentation.components.PieChart
import com.misun.misunmoneyplan.presentation.components.StockAssetList
import com.misun.misunmoneyplan.presentation.components.TypeAssetList
import com.misun.misunmoneyplan.presentation.ui.theme.MisunMoneyPlanTheme

/**
 * [F1] HomeScreen (메인 대시보드)
 * 사용자의 실시간 자산 배분 현황을 시각화하고 관리하는 메인 화면
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeUiState,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    onPortfolioClick: () -> Unit,
    onAddAssetClick: () -> Unit,
    onStockClick: (AssetId) -> Unit,
    onTypeClick: (AssetType) -> Unit,
    modifier: Modifier = Modifier
) {
    val tabs = listOf("종목별", "유형별", "지역별")

    val displayAssets = if (selectedTabIndex == 0) {
        state.assets.sortedByDescending { it.amount }
    } else {
        // [F1-7a], [F1-8b] 탭에 따른 그룹화 로직 (임시)
        state.assets.groupBy { it.type }.map { (type, items) ->
            AssetUiModel(
                id = type.name,
                name = type.displayName,
                type = type,
                location = items.firstOrNull()?.location ?: com.misun.misunmoneyplan.domain.model.AssetLocation.DOMESTIC,
                amount = items.sumOf { it.amount },
                updatedAt = items.maxOfOrNull { it.updatedAt } ?: 0L,
                color = type.color
            )
        }.sortedByDescending { it.amount }
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            // [F1-3b] 포트폴리오 관리 이동 버튼이 포함된 TopAppBar
            TopAppBar(
                title = { Text("자산 관리", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                actions = {
                    IconButton(onClick = onPortfolioClick) {
                        Icon(Icons.Default.PieChart, contentDescription = "포트폴리오 관리")
                    }
                }
            )
        },
        floatingActionButton = {
            // [F1-3a] 신규 자산 추가를 위한 FAB
            FloatingActionButton(
                onClick = onAddAssetClick,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
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
            // [F1-1] 총 자산 요약 정보 카드
            TotalAssetCard(state.totalAsset)

            Spacer(modifier = Modifier.height(16.dp))

            // [F1-2] 메인 탭 네비게이션 (종목별 / 유형별 / 지역별)
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.primary,
                divider = {}
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { onTabSelected(index) },
                        text = { Text(text = title) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            
            // ... 차트 및 리스트 영역 (Phase 2-3에서 고도화 예정)
        }
    }
}

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
                    onAssetClick = onStockClick
                )
            } else {
                TypeAssetList(
                    assets = displayAssets,
                    totalAmount = state.totalAsset,
                    onTypeClick = onTypeClick
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
            onStockClick = {},
            onTypeClick = {}
        )
    }
}
