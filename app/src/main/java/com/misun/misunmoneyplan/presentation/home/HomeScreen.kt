package com.misun.misunmoneyplan.presentation.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.misun.misunmoneyplan.presentation.ui.theme.MisunMoneyPlanTheme
import java.text.NumberFormat
import java.util.Locale

/**
 * 자산배분 파이 차트 + 리스트 표시
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
        state.assets.sortedByDescending { it.amount }.take(10)
    } else {
        state.assets.groupBy { it.type }.map { (type, items) ->
            AssetUiModel(
                id = type.name,
                name = type.displayName,
                type = type,
                amount = items.sumOf { it.amount },
                percent = items.fold(0f) { acc, item -> acc + item.percent },
                color = type.color
            )
        }.sortedByDescending { it.amount }
    }

    Scaffold(
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
                    TreemapChart(assets = displayAssets, modifier = Modifier.fillMaxSize())
                } else {
                    PieChart(assets = displayAssets)
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
                    text = if (selectedTabIndex == 0) "자산 목록" else "유형 목록",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${displayAssets.size}개 항목",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            AssetList(
                assets = displayAssets,
                onAssetClick = { id ->
                    if (selectedTabIndex == 0) onAssetClick(id)
                }
            )
        }
    }
}

@Composable
fun TotalAssetCard(totalAsset: Long) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "총 자산",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Text(
                text = formatCurrency(totalAsset),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Composable
fun TreemapChart(assets: List<AssetUiModel>, modifier: Modifier = Modifier) {
    if (assets.isEmpty()) {
        Box(
            modifier = modifier
                .clip(MaterialTheme.shapes.medium)
                .background(Color.LightGray.copy(alpha = 0.3f)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "데이터 없음", style = MaterialTheme.typography.bodySmall)
        }
        return
    }

    BoxWithConstraints(modifier = modifier.clip(MaterialTheme.shapes.medium)) {
        TreemapNode(
            assets = assets,
            width = maxWidth,
            height = maxHeight
        )
    }
}

@Composable
fun TreemapNode(assets: List<AssetUiModel>, width: Dp, height: Dp) {
    if (assets.isEmpty()) return

    if (assets.size == 1) {
        val asset = assets.first()
        Box(
            modifier = Modifier
                .size(width, height)
                .background(asset.color)
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = asset.name,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (width > 50.dp && height > 30.dp) {
                    Text(
                        text = "${(asset.percent * 100).toInt()}%",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }
        }
        return
    }

    val totalAmount = assets.sumOf { it.amount }
    if (totalAmount == 0L) return

    var currentAmount = 0L
    var splitIndex = 0
    for (i in assets.indices) {
        currentAmount += assets[i].amount
        if (currentAmount >= totalAmount / 2) {
            splitIndex = i + 1
            break
        }
    }

    if (splitIndex == assets.size) splitIndex--
    if (splitIndex == 0) splitIndex = 1

    val firstPart = assets.subList(0, splitIndex)
    val secondPart = assets.subList(splitIndex, assets.size)

    val firstPartAmount = firstPart.sumOf { it.amount }
    val ratio = firstPartAmount.toFloat() / totalAmount

    if (width > height) {
        Row {
            TreemapNode(firstPart, width * ratio, height)
            TreemapNode(secondPart, width * (1 - ratio), height)
        }
    } else {
        Column {
            TreemapNode(firstPart, width, height * ratio)
            TreemapNode(secondPart, width, height * (1 - ratio))
        }
    }
}

@Composable
fun PieChart(assets: List<AssetUiModel>) {
    if (assets.isEmpty()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = Color.LightGray.copy(alpha = 0.3f),
                style = Stroke(width = 40f)
            )
        }
        return
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        var startAngle = -90f
        assets.forEach { asset ->
            val sweepAngle = asset.percent * 360f
            drawArc(
                color = asset.color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = 40f)
            )
            startAngle += sweepAngle
        }
    }
}

@Composable
fun AssetList(
    assets: List<AssetUiModel>,
    onAssetClick: (AssetId) -> Unit
) {
    if (assets.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "등록된 자산이 없습니다.", color = MaterialTheme.colorScheme.outline)
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(assets) { asset ->
                AssetItem(asset = asset, onClick = { onAssetClick(asset.id) })
            }
        }
    }
}

@Composable
fun AssetItem(asset: AssetUiModel, onClick: () -> Unit) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(asset.color)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = asset.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = formatCurrency(asset.amount),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${(asset.percent * 100).toInt()}%",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}

private fun formatCurrency(amount: Long): String {
    val format = NumberFormat.getCurrencyInstance(Locale.KOREA)
    return format.format(amount)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val dummyAssets = listOf(
        AssetUiModel("1", "삼성전자", AssetType.STOCK, 5000000, 0.5f),
        AssetUiModel("2", "생활비 계좌", AssetType.CASH, 3000000, 0.3f),
        AssetUiModel("3", "비트코인", AssetType.COIN, 2000000, 0.2f)
    )
    val dummyState = HomeUiState(
        totalAsset = 10000000,
        assets = dummyAssets
    )

    MisunMoneyPlanTheme {
        HomeScreen(state = dummyState, onAssetClick = {})
    }
}
