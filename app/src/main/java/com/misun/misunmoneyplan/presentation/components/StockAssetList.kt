package com.misun.misunmoneyplan.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.misun.misunmoneyplan.presentation.home.AssetId
import com.misun.misunmoneyplan.presentation.home.AssetUiModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun StockAssetList(
    assets: List<AssetUiModel>,
    totalAmount: Long,
    onAssetClick: (AssetId) -> Unit
) {
    if (assets.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "등록된 종목이 없습니다.", color = MaterialTheme.colorScheme.outline)
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(assets) { asset ->
                StockAssetItem(
                    asset = asset,
                    totalAmount = totalAmount,
                    onClick = { onAssetClick(asset.id) }
                )
            }
        }
    }
}

@Composable
fun StockAssetItem(asset: AssetUiModel, totalAmount: Long, onClick: () -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = formatUpdateDate(asset.updatedAt),
                style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 12.dp)
            )

            Row(
                modifier = Modifier
                    .padding(start = 12.dp, top = 16.dp, end = 12.dp, bottom = 12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    val percent = if (totalAmount > 0) (asset.amount.toFloat() / totalAmount) else 0f
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(asset.color),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${(percent * 100).toInt()}%",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = asset.name,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                }
                Text(
                    text = formatCurrency(asset.amount),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

private fun formatUpdateDate(timestamp: Long): String {
    if (timestamp == 0L) return ""
    val sdf = SimpleDateFormat("yy.MM.dd", Locale.getDefault())
    return "최근 업데이트: ${sdf.format(Date(timestamp))}"
}

private fun formatCurrency(amount: Long): String {
    val format = NumberFormat.getCurrencyInstance(Locale.KOREA)
    return format.format(amount)
}
