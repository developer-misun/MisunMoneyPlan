package com.misun.misunmoneyplan.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import com.misun.misunmoneyplan.presentation.home.AssetUiModel
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun PieChart(assets: List<AssetUiModel>, totalAmount: Long) {
    if (assets.isEmpty() || totalAmount == 0L) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = Color.LightGray.copy(alpha = 0.3f),
                style = Stroke(width = 60f)
            )
        }
        return
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        val strokeWidth = 100f
        val chartSize = size.minDimension - strokeWidth
        val radius = chartSize / 2
        val arcCenter = Offset(size.width / 2f, size.height / 2f)

        val topLeft = Offset(
            x = (size.width - chartSize) / 2f,
            y = (size.height - chartSize) / 2f
        )
        val arcRectSize = Size(chartSize, chartSize)

        var startAngle = -90f

        assets.forEach { asset ->
            val ratio = asset.amount.toFloat() / totalAmount
            val sweepAngle = ratio * 360f

            drawArc(
                color = asset.color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = topLeft,
                size = arcRectSize,
                style = Stroke(width = strokeWidth)
            )

            if (sweepAngle > 25f) {
                val middleAngle = Math.toRadians((startAngle + sweepAngle / 2).toDouble())
                val textX = (arcCenter.x + radius * cos(middleAngle)).toFloat()
                val textY = (arcCenter.y + radius * sin(middleAngle)).toFloat()

                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        "${(ratio * 100).toInt()}%",
                        textX,
                        textY + 12f,
                        android.graphics.Paint().apply {
                            color = android.graphics.Color.WHITE
                            textSize = 34f
                            textAlign = android.graphics.Paint.Align.CENTER
                            isFakeBoldText = true
                            setShadowLayer(4f, 0f, 0f, Color.Black.copy(alpha = 0.5f).toArgb())
                        }
                    )
                }
            }

            startAngle += sweepAngle
        }
    }
}
