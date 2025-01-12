package com.glowstudio.android.blindsjn.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.glowstudio.android.blindsjn.ui.navigation.TopBar
import com.glowstudio.android.blindsjn.ui.navigation.BottomNavigationBar
import com.glowstudio.android.blindsjn.ui.screens.*

@Composable
fun MainScreen() {
    // 네비게이션 컨트롤러 생성
    val navController = rememberNavController()

    // 상단바 상태 관리
    var title by remember { mutableStateOf("홈 화면") }
    var showBackButton by remember { mutableStateOf(false) }
    var showSearchButton by remember { mutableStateOf(true) }

    // Scaffold로 전체 레이아웃 구성
    Scaffold(
        // 상단 바
        topBar = {
            TopBar(
                title = title,
                showBackButton = showBackButton,
                showSearchButton = showSearchButton,
                onBackClick = { navController.navigateUp() },
                onSearchClick = { /* TODO: 검색 동작 */ }
            )
        },
        // 하단 네비게이션 바
        bottomBar = {
            BottomNavigationBar(navController)
        },
        content = { paddingValues ->
            // NavHost로 화면 전환 관리
            NavHost(
                navController = navController,
                startDestination = "home", // 시작 화면 설정
                modifier = Modifier.padding(paddingValues)
            ) {
                composable("home") {
                    title = "홈 화면"
                    showBackButton = false
                    showSearchButton = false
                    HomeScreen()
                }
                composable("board") {
                    title = "게시판"
                    showBackButton = false
                    showSearchButton = true
                    BoardScreen()
                }
                composable("popular") {
                    title = "인기글"
                    showBackButton = false
                    showSearchButton = false
                    PopularScreen()
                }
                composable("message") {
                    title = "메시지"
                    showBackButton = false
                    showSearchButton = true
                    MessageScreen()
                }
                composable("profile") {
                    title = "프로필"
                    showBackButton = false
                    showSearchButton = false
                    ProfileScreen()
                }
            }
        }
    )
}
