package com.glowstudio.android.blindsjn.ui.navigation

/**
 * 스크린 간 전환 로직
 *
 * TODO: 남은 스크린 구현
 **/

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.glowstudio.android.blindsjn.ui.MainScreen
import com.glowstudio.android.blindsjn.ui.screens.LoginScreen
import com.glowstudio.android.blindsjn.ui.screens.SignupScreen
import com.glowstudio.android.blindsjn.ui.screens.HomeScreen
import com.glowstudio.android.blindsjn.ui.screens.BoardScreen
import com.glowstudio.android.blindsjn.ui.screens.BoardDetailScreen
import com.glowstudio.android.blindsjn.ui.screens.PopularScreen
import com.glowstudio.android.blindsjn.ui.screens.MessageScreen
import com.glowstudio.android.blindsjn.ui.screens.ProfileScreen
import com.glowstudio.android.blindsjn.ui.screens.WritePostScreen

@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        // 로그인 화면
        composable("login") {
            LoginScreen(
                onLoginClick = { navController.navigate("main") },
                onSignupClick = { navController.navigate("signup") },
                onForgotPasswordClick = { /* TODO: 비밀번호 찾기 화면 이동 */ }
            )
        }

        // 회원가입 화면
        composable("signup") {
            SignupScreen(
                onSignupClick = { phoneNumber, password ->
                    // TODO: 서버와 연동하여 회원가입 처리
                    navController.navigate("home") // 회원가입 후 홈 화면으로 이동
                },
                onBackToLoginClick = { navController.navigateUp() }
            )
        }

        // 메인 화면: 아래 5개 페이지의 상위 관리
        composable("main") {
            MainScreen()
        }

        // 홈 화면
        composable("home") {
            HomeScreen()
        }

        // 게시판 목록 화면
        composable("board") {
            BoardScreen(navController = navController)
        }

        // 게시판 화면 - 게시판 목록 화면에서 받은 값을 기반으로 이동
        composable("boardDetail/{title}") { backStackEntry ->
            val postTitle = backStackEntry.arguments?.getString("title") ?: "게시글" // 네비게이션 매개변수 추출
            BoardDetailScreen(navController = navController, title = postTitle) // title 전달
        }

        // 게시글 쓰기 화면
        composable("writePost") {
            WritePostScreen(navController = navController   )
        }

        // 인기글 화면
        composable("popular") {
            PopularScreen()
        }

        // 메시지 화면
        composable("message") {
            MessageScreen()
        }

        // 프로필 화면
        composable("profile") {
            ProfileScreen()
        }
    }
}