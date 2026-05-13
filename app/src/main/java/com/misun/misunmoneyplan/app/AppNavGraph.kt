package com.misun.misunmoneyplan.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.misun.misunmoneyplan.domain.model.AssetType
import com.misun.misunmoneyplan.presentation.home.HomeScreen
import com.misun.misunmoneyplan.presentation.home.HomeViewModel
import com.misun.misunmoneyplan.presentation.asset.TypeDetailScreen
import com.misun.misunmoneyplan.presentation.navigation.Screen

/**
 * 앱의 전체 네비게이션 구조 정의
 */
@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        // 1. 홈 대시보드
        composable(Screen.Home.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            val state by viewModel.uiState.collectAsState()
            val selectedTabIndex by viewModel.selectedTabIndex.collectAsState()

            HomeScreen(
                state = state,
                selectedTabIndex = selectedTabIndex,
                onTabSelected = viewModel::onTabSelected,
                onPortfolioClick = { 
                    navController.navigate(Screen.Portfolio.route)
                },
                onAddAssetClick = { 
                    navController.navigate(Screen.StockDetail.createRoute("")) 
                },
                onStockClick = { assetId ->
                    navController.navigate(Screen.StockDetail.createRoute(assetId))
                },
                onTypeClick = { assetType ->
                    navController.navigate(Screen.TypeDetail.createRoute(assetType))
                },
                onRetryClick = viewModel::loadAssets
            )
        }

        // 2. 종목 상세 화면
        composable(
            route = Screen.StockDetail.route,
            arguments = listOf(navArgument("assetId") { defaultValue = "" })
        ) { backStackEntry ->
            val assetId = backStackEntry.arguments?.getString("assetId") ?: ""
            // 임시로 텍스트 출력하여 흐름 확인
            androidx.compose.material3.Text("종목 상세: $assetId (뒤로가려면 시스템 백버튼)")
        }

        // 3. 포트폴리오 관리 화면
        composable(Screen.Portfolio.route) {
            // PortfolioScreen() 호출 예정
            androidx.compose.material3.Text("포트폴리오 관리 화면 (준비 중)")
        }

        // 4. 유형 상세 화면
        composable(
            route = Screen.TypeDetail.route,
            arguments = listOf(navArgument("typeName") { defaultValue = "CASH" })
        ) { backStackEntry ->
            val typeName = backStackEntry.arguments?.getString("typeName") ?: "CASH"
            val assetType = AssetType.valueOf(typeName)
            
            TypeDetailScreen(
                type = assetType,
                onBackClick = { navController.popBackStack() },
                onStockClick = { stockId ->
                    navController.navigate(Screen.StockDetail.createRoute(stockId))
                }
            )
        }
    }
}
