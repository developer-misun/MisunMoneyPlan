package com.misun.misunmoneyplan.presentation.home

import com.misun.misunmoneyplan.domain.model.AssetType
import com.misun.misunmoneyplan.domain.model.AssetLocation

object SampleData {
    private val now = System.currentTimeMillis()

    val dummyAssets = listOf(
        AssetUiModel("1", "삼성전자", AssetType.STOCK, AssetLocation.DOMESTIC, 5000000, now),
        AssetUiModel("2", "생활비 계좌", AssetType.CASH, AssetLocation.DOMESTIC, 3000000, now - 86400000 * 2), // 2일 전
        AssetUiModel("3", "비트코인", AssetType.COIN, AssetLocation.OVERSEAS, 2000000, now - 3600000), // 1시간 전
        AssetUiModel("4", "S&P500 ETF", AssetType.ETF, AssetLocation.OVERSEAS, 1500000, now),
        AssetUiModel("5", "카카오", AssetType.STOCK, AssetLocation.DOMESTIC, 1000000, now - 86400000 * 5),
        AssetUiModel("6", "이더리움", AssetType.COIN, AssetLocation.OVERSEAS, 800000, now),
        AssetUiModel("7", "청약저축", AssetType.CASH, AssetLocation.DOMESTIC, 2000000, now - 86400000 * 30), // 한달 전
        AssetUiModel("8", "나스닥100", AssetType.ETF, AssetLocation.OVERSEAS, 1200000, now),
        AssetUiModel("9", "금 현물", AssetType.ETC, AssetLocation.DOMESTIC, 500000, now),
        AssetUiModel("10", "비상금", AssetType.CASH, AssetLocation.DOMESTIC, 300000, now)
    )

    val dummyState = HomeUiState(
        assets = dummyAssets
    )
}
