package com.gigabyte.bookstore.presentation.navigation

import android.app.Application
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gigabyte.bookstore.presentation.bookdetails.BookDetailsScreen
import com.gigabyte.bookstore.presentation.bookdetails.BookDetailsViewModel
import com.gigabyte.bookstore.presentation.library.LibraryScreen
import com.gigabyte.bookstore.presentation.library.LibraryViewModel
import com.gigabyte.bookstore.presentation.player.PlayerScreen
import com.gigabyte.bookstore.presentation.player.PlayerViewModel
import com.gigabyte.bookstore.presentation.reader.TextReaderScreen
import com.gigabyte.bookstore.presentation.reader.TextReaderViewModel
import com.gigabyte.bookstore.presentation.search.SearchScreen
import com.gigabyte.bookstore.presentation.search.SearchViewModel
import com.gigabyte.bookstore.presentation.settings.SettingsScreen
import com.gigabyte.bookstore.presentation.settings.SettingsViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val application = LocalContext.current.applicationContext as Application

    NavHost(
        navController = navController,
        startDestination = Screen.Library.route,
        modifier = modifier,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(300)
            ) + fadeIn(animationSpec = tween(300))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth / 4 },
                animationSpec = tween(300)
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth / 4 },
                animationSpec = tween(300)
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(300)
            ) + fadeOut(animationSpec = tween(300))
        }
    ) {
        // 1. Library Screen
        composable(Screen.Library.route) {
            val viewModel: LibraryViewModel = viewModel(factory = SimpleViewModelFactory {
                LibraryViewModel(application)
            })
            LibraryScreen(
                viewModel = viewModel,
                onBookClick = { bookId ->
                    navController.navigate(Screen.BookDetails.createRoute(bookId))
                },
                onPlayClick = { bookId, chapterIdx ->
                    navController.navigate(Screen.Player.createRoute(bookId, chapterIdx))
                },
                onOpenPlayer = {
                    val currentBookId = viewModel.playbackState.value.bookId
                    if (currentBookId.isNotBlank()) {
                        val currentChapIdx = viewModel.playbackState.value.chapterIndex
                        navController.navigate(Screen.Player.createRoute(currentBookId, currentChapIdx))
                    }
                },
                onOpenReader = { bookId, chapterIdx ->
                    navController.navigate(Screen.TextReader.createRoute(bookId, chapterIdx))
                },
                onOpenSearch = {
                    navController.navigate(Screen.Search.createRoute())
                },
                onOpenSettings = {
                    navController.navigate(Screen.Settings.route)
                }
            )
        }

        // 2. Book Details Screen
        composable(
            route = Screen.BookDetails.route,
            arguments = listOf(navArgument("bookId") { type = NavType.StringType })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId") ?: ""
            val viewModel: BookDetailsViewModel = viewModel(
                key = "details_$bookId",
                factory = SimpleViewModelFactory {
                    BookDetailsViewModel(application, bookId)
                }
            )
            BookDetailsScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onPlayChapter = { chapterIdx ->
                    navController.navigate(Screen.Player.createRoute(bookId, chapterIdx))
                },
                onOpenPlayer = {
                    val currentBookId = viewModel.playbackState.value.bookId.ifBlank { bookId }
                    val currentChapIdx = viewModel.playbackState.value.chapterIndex
                    navController.navigate(Screen.Player.createRoute(currentBookId, currentChapIdx))
                },
                onOpenReader = { chapterIdx ->
                    navController.navigate(Screen.TextReader.createRoute(bookId, chapterIdx))
                },
                onSearchInBook = { bId ->
                    navController.navigate(Screen.Search.createRoute(bId))
                }
            )
        }

        // 3. Player Screen
        composable(
            route = Screen.Player.route,
            arguments = listOf(
                navArgument("bookId") { type = NavType.StringType },
                navArgument("chapterIndex") { type = NavType.IntType; defaultValue = 0 }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId") ?: ""
            val chapterIndex = backStackEntry.arguments?.getInt("chapterIndex") ?: 0
            val viewModel: PlayerViewModel = viewModel(
                key = "player_${bookId}_$chapterIndex",
                factory = SimpleViewModelFactory {
                    PlayerViewModel(application, bookId, chapterIndex)
                }
            )
            PlayerScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onOpenReader = { bId, cIdx ->
                    navController.navigate(Screen.TextReader.createRoute(bId, cIdx))
                }
            )
        }

        // 4. Text Reader Screen
        composable(
            route = Screen.TextReader.route,
            arguments = listOf(
                navArgument("bookId") { type = NavType.StringType },
                navArgument("chapterIndex") { type = NavType.IntType; defaultValue = 0 }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId") ?: ""
            val chapterIndex = backStackEntry.arguments?.getInt("chapterIndex") ?: 0
            val viewModel: TextReaderViewModel = viewModel(
                key = "reader_${bookId}_$chapterIndex",
                factory = SimpleViewModelFactory {
                    TextReaderViewModel(application, bookId, chapterIndex)
                }
            )
            TextReaderScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onOpenPlayer = {
                    navController.navigate(Screen.Player.createRoute(bookId, viewModel.currentChapterIndex.value))
                }
            )
        }

        // 5. Settings Screen
        composable(Screen.Settings.route) {
            val viewModel: SettingsViewModel = viewModel(factory = SimpleViewModelFactory {
                SettingsViewModel(application)
            })
            SettingsScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() }
            )
        }

        // 6. Search Screen
        composable(
            route = Screen.Search.route,
            arguments = listOf(
                navArgument("bookId") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId")
            val viewModel: SearchViewModel = viewModel(
                key = "search_$bookId",
                factory = SimpleViewModelFactory {
                    SearchViewModel(application, bookId)
                }
            )
            SearchScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onOpenReader = { bId, cIdx ->
                    navController.navigate(Screen.TextReader.createRoute(bId, cIdx))
                },
                onOpenPlayer = {
                    val currentBookId = viewModel.playbackState.value.bookId
                    if (currentBookId.isNotBlank()) {
                        val currentChapIdx = viewModel.playbackState.value.chapterIndex
                        navController.navigate(Screen.Player.createRoute(currentBookId, currentChapIdx))
                    }
                }
            )
        }
    }
}

class SimpleViewModelFactory<T : androidx.lifecycle.ViewModel>(
    private val creator: () -> T
) : androidx.lifecycle.ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <VM : androidx.lifecycle.ViewModel> create(modelClass: Class<VM>): VM {
        return creator() as VM
    }
}
