package com.misun.misunmoneyplan.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import com.misun.misunmoneyplan.presentation.ui.theme.MisunMoneyPlanTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


/**
 * 앱의 진입점
 * AndroidManifest.xml에서 android.intent.action.MAIN 지정
 * omponentActivity 상속 → Compose 사용 가능
 *
 * 1️⃣ 앱 시작점 (Launcher Activity)
 * 2️⃣ 전체 Theme 적용
 * 3️⃣ Navigation Host 제공
 * 4️⃣ Hilt Entry Point (@AndroidEntryPoint)
 * 5️⃣ 상태바/네비게이션바 설정
 *
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity(){

    /**
     * 앱 시작시 최초 1회 실행
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MisunMoneyPlanTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }

        // 초기 데이터 로드, STARTED 상태에서만 실행 / 실시간 데이터 수신, 화면 보일 때만 업데이트
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // 네트워크 요청, 데이터 로딩
                //viewModel.loadInitialData()

                // 자산 초기 로드
                //homeViewModel.loadAssets()
            }
        }
    }
}
