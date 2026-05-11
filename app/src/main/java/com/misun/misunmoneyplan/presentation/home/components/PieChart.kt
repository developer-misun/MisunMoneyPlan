package com.misun.misunmoneyplan.presentation.home.components

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

/**
 * 유형별 파이 차트
 */
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
        val strokeWidth = 100f // 좀 더 두껍게
        val chartSize = size.minDimension - strokeWidth
        val radius = chartSize / 2
        val arcCenter = Offset(size.width / 2f, size.height / 2f)

        // 차트가 그려질 정방형 영역 계산 (찌그러짐 방지)
        val topLeft = Offset(
            x = (size.width - chartSize) / 2f,
            y = (size.height - chartSize) / 2f
        )
        val arcRectSize = Size(chartSize, chartSize)

        var startAngle = -90f

        assets.forEach { asset ->
            val ratio = asset.amount.toFloat() / totalAmount
            val sweepAngle = ratio * 360f

            // 1. 차트 호(Arc) 그리기 (정방형 영역에 그려서 원형 유지)
            drawArc(
                color = asset.color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = topLeft,
                size = arcRectSize,
                style = Stroke(width = strokeWidth)
            )

            // 2. 비율 텍스트 그리기 (도넛 두께 정중앙)
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
                            // 그림자 효과로 가독성 향상
                            setShadowLayer(4f, 0f, 0f, Color.Black.copy(alpha = 0.5f).toArgb())
                        }
                    )
                }
            }

            startAngle += sweepAngle
        }
    }
}
