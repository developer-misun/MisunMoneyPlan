package com.misun.misunmoneyplan.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.misun.misunmoneyplan.domain.model.AssetLocation

@Composable
fun LocationBadge(location: AssetLocation, modifier: Modifier = Modifier) {
    val backgroundColor = when (location) {
        AssetLocation.DOMESTIC -> MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f)
        AssetLocation.OVERSEAS -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
    }
    val contentColor = when (location) {
        AssetLocation.DOMESTIC -> MaterialTheme.colorScheme.outline
        AssetLocation.OVERSEAS -> MaterialTheme.colorScheme.primary
    }

    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
    ) {
        Text(
            text = location.displayName,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
            style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
            color = contentColor,
            fontWeight = FontWeight.Bold
        )
    }
}
