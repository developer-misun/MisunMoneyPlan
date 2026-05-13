package com.misun.misunmoneyplan.presentation.navigation

import com.misun.misunmoneyplan.domain.model.AssetType

/**
 * 앱의 각 화면 경로를 정의하는 타입 안전한 구조
 */
sealed class Screen(val route: String) {
    object Home : Screen("home")
    
    object StockDetail : Screen("stockDetail/{assetId}") {
        fun createRoute(assetId: String) = "stockDetail/$assetId"
    }
    
    object Portfolio : Screen("portfolio")
    
    object TypeDetail : Screen("typeDetail/{typeName}") {
        fun createRoute(type: AssetType) = "typeDetail/${type.name}"
    }
}
