package com.misun.misunmoneyplan.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.misun.misunmoneyplan.domain.model.AssetType
import com.misun.misunmoneyplan.presentation.home.HomeScreen
import com.misun.misunmoneyplan.presentation.home.SampleData
import com.misun.misunmoneyplan.presentation.asset.StockDetailScreen
import com.misun.misunmoneyplan.presentation.asset.TypeDetailScreen
import com.misun.misunmoneyplan.presentation.asset.AssetDetailViewModel

/**
 * 앱의 전체 네비게이션 구조 정의
 */
@Composable
fun AppNavGraph(
    navController: NavHostController,
    // ViewModel은 임시로 주입 (Hilt 설정 전)
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // 1. 홈 대시보드
        composable("home") {
            HomeScreen(
                state = SampleData.dummyState,
                onStockClick = { assetId ->
                    navController.navigate("stockDetail/$assetId")
                },
                onTypeClick = { assetType ->
                    navController.navigate("typeDetail/${assetType.name}")
                }
            )
        }

        // 2. 종목 상세 화면
        composable(
            route = "stockDetail/{assetId}",
            arguments = listOf(navArgument("assetId") { defaultValue = "" })
        ) { backStackEntry ->
            val assetId = backStackEntry.arguments?.getString("assetId") ?: ""
            // ViewModel 생성 로직 (Hilt 미설정으로 임시 처리)
            // StockDetailScreen(assetId = assetId, viewModel = ..., onBackClick = { navController.popBackStack() })
            
            // 임시로 텍스트 출력하여 흐름 확인
            androidx.compose.material3.Text("종목 상세: $assetId (뒤로가려면 시스템 백버튼)")
        }

        // 3. 유형 상세 화면
        composable(
            route = "typeDetail/{typeName}",
            arguments = listOf(navArgument("typeName") { defaultValue = "CASH" })
        ) { backStackEntry ->
            val typeName = backStackEntry.arguments?.getString("typeName") ?: "CASH"
            val assetType = AssetType.valueOf(typeName)
            
            TypeDetailScreen(
                type = assetType,
                onBackClick = { navController.popBackStack() },
                onStockClick = { stockId ->
                    navController.navigate("stockDetail/$stockId")
                }
            )
        }
    }
}
