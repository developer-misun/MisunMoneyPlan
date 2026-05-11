package com.misun.misunmoneyplan.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.misun.misunmoneyplan.presentation.home.AssetUiModel

@Composable
fun TreemapChart(assets: List<AssetUiModel>, totalAmount: Long, modifier: Modifier = Modifier) {
    if (assets.isEmpty() || totalAmount == 0L) {
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
            totalAmount = totalAmount,
            width = maxWidth,
            height = maxHeight
        )
    }
}

@Composable
fun TreemapNode(assets: List<AssetUiModel>, totalAmount: Long, width: Dp, height: Dp) {
    if (assets.isEmpty()) return

    if (assets.size == 1) {
        val asset = assets.first()
        Box(
            modifier = Modifier
                .size(width, height)
                .background(asset.color)
                .border(0.5.dp, Color.White.copy(alpha = 0.5f))
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
                    val percent = if (totalAmount > 0) asset.amount.toFloat() / totalAmount else 0f
                    Text(
                        text = "${(percent * 100).toInt()}%",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }
        }
        return
    }

    val currentTotal = assets.sumOf { it.amount }
    if (currentTotal == 0L) return

    var currentAmount = 0L
    var splitIndex = 0
    for (i in assets.indices) {
        currentAmount += assets[i].amount
        if (currentAmount >= currentTotal / 2) {
            splitIndex = i + 1
            break
        }
    }

    if (splitIndex == assets.size) splitIndex--
    if (splitIndex == 0) splitIndex = 1

    val firstPart = assets.subList(0, splitIndex)
    val secondPart = assets.subList(splitIndex, assets.size)

    val firstPartAmount = firstPart.sumOf { it.amount }
    val ratio = firstPartAmount.toFloat() / currentTotal

    if (width > height) {
        Row {
            TreemapNode(firstPart, totalAmount, width * ratio, height)
            TreemapNode(secondPart, totalAmount, width * (1 - ratio), height)
        }
    } else {
        Column {
            TreemapNode(firstPart, totalAmount, width, height * ratio)
            TreemapNode(secondPart, totalAmount, width, height * (1 - ratio))
        }
    }
}
