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
import com.gigabyte.bookstore.presentation.categories.BookCategoriesScreen
import com.gigabyte.bookstore.presentation.categories.BookCategoriesViewModel
import com.gigabyte.bookstore.presentation.bookdetails.BookDetailsScreen
import com.gigabyte.bookstore.presentation.bookdetails.BookDetailsViewModel
import com.gigabyte.bookstore.presentation.home.HomeScreen
import com.gigabyte.bookstore.presentation.home.HomeViewModel
import com.gigabyte.bookstore.presentation.library.LibraryScreen
import com.gigabyte.bookstore.presentation.library.LibraryViewModel
import com.gigabyte.bookstore.presentation.player.PlayerScreen
import com.gigabyte.bookstore.presentation.player.PlayerViewModel
import com.gigabyte.bookstore.presentation.reader.TextReaderScreen
import com.gigabyte.bookstore.presentation.reader.TextReaderViewModel
import com.gigabyte.bookstore.presentation.search.SearchScreen
import com.gigabyte.bookstore.presentation.search.SearchViewModel
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.presentation.auth.LoginScreen
import com.gigabyte.bookstore.presentation.auth.RegisterScreen
import com.gigabyte.bookstore.presentation.sync.SyncScreen
import com.gigabyte.bookstore.presentation.settings.SettingsScreen
import com.gigabyte.bookstore.presentation.settings.SettingsViewModel
import com.gigabyte.bookstore.presentation.payment.PaymentScreen
import com.gigabyte.bookstore.presentation.payment.PaymentApprovalScreen
import com.gigabyte.bookstore.presentation.pdf.PdfViewerScreen
import com.gigabyte.bookstore.presentation.referral.ReferralScreen
import com.gigabyte.bookstore.learning.presentation.home.LearnHomeScreen
import com.gigabyte.bookstore.learning.presentation.home.LearnHomeViewModel
import com.gigabyte.bookstore.learning.presentation.lesson.LessonScreen
import com.gigabyte.bookstore.learning.presentation.lesson.LessonViewModel
import com.gigabyte.bookstore.learning.presentation.part.PartLessonsScreen
import com.gigabyte.bookstore.learning.presentation.part.PartLessonsViewModel
import com.gigabyte.bookstore.learning.presentation.quiz.QuizScreen
import com.gigabyte.bookstore.learning.presentation.quiz.QuizViewModel
import com.gigabyte.bookstore.learning.presentation.intro.CourseIntroScreen
import com.gigabyte.bookstore.learning.presentation.syllabus.CourseSyllabusScreen
import com.gigabyte.bookstore.presentation.lastread.LastReadScreen
import com.gigabyte.bookstore.presentation.lastread.LastReadViewModel

@Composable

fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val application = LocalContext.current.applicationContext as Application

    NavHost(
        navController = navController,
        startDestination = Screen.Sync.route,
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
        // 0. Splash & Background Sync Screen (Verifies Device ID, downloads missing files with progress)
        composable(Screen.Sync.route) {
            SyncScreen(
                // Logged out (or account/device problem): show Login, which links to Register.
                onNavigateToRegister = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Sync.route) { inclusive = true }
                    }
                },
                onNavigateToLibrary = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Sync.route) { inclusive = true }
                    }
                }
            )
        }

        // 0.1 Login Screen (shown when logged out)
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    // Sync re-verifies the account and downloads the user's books, then opens Home.
                    navController.navigate(Screen.Sync.route) {
                        popUpTo(navController.graph.id) { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(Screen.Register.route) { launchSingleTop = true }
                }
            )
        }

        // 0.2 First-time Registration Screen
        composable(Screen.Register.route) {
            RegisterScreen(
                onRegistrationSuccess = {
                    navController.navigate(Screen.Sync.route) {
                        popUpTo(navController.graph.id) { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    if (!navController.popBackStack(Screen.Login.route, inclusive = false)) {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(Screen.Register.route) { inclusive = true }
                        }
                    }
                }
            )
        }

        // 0.2 Home Screen (Audiobook Bundles, English Language Courses, Japanese Language Courses, Trending Books)
        composable(Screen.Home.route) {
            val viewModel: HomeViewModel = viewModel(factory = SimpleViewModelFactory {
                HomeViewModel(application)
            })
            HomeScreen(
                viewModel = viewModel,
                onNavigateToLibrary = {
                    navController.navigate(Screen.Library.route)
                },
                onNavigateToBook = { bookId ->
                    navController.navigate(Screen.BookDetails.createRoute(bookId))
                },
                onNavigateToPlayer = {
                    val currentBookId = viewModel.playbackState.value.bookId
                    if (!currentBookId.isNullOrBlank()) {
                        val currentChapIdx = viewModel.playbackState.value.chapterIndex
                        navController.navigate(Screen.Player.createRoute(currentBookId, currentChapIdx))
                    }
                },
                onPlayBook = { bookId, chapterIdx ->
                    navController.navigate(Screen.Player.createRoute(bookId, chapterIdx))
                },
                onNavigateToSearch = {
                    navController.navigate(Screen.Search.createRoute())
                },
                onNavigateToPayment = {
                    navController.navigate(Screen.Payment.route)
                },
                onNavigateToReferral = {
                    navController.navigate(Screen.Referral.route)
                },
                onNavigateToApproval = {
                    navController.navigate(Screen.PaymentApproval.route)
                },
                onNavigateToBookCategories = { bundleId ->
                    navController.navigate(Screen.BookCategories.createRoute(bundleId))
                },
                onNavigateToLearnEnglish = {
                    navController.navigate(Screen.Learn.createRoute("english"))
                },
                onNavigateToLearnJapanese = {
                    navController.navigate(Screen.Learn.createRoute("japanese"))
                },
                onNavigateToLastRead = {
                    navController.navigate(Screen.LastRead.route)
                },
                onLogout = { logout(application, navController) }
            )
        }

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
                },
                onOpenPayment = {
                    navController.navigate(Screen.Payment.route)
                },
                onOpenPaymentApproval = {
                    navController.navigate(Screen.PaymentApproval.route)
                },
                onOpenReferral = {
                    navController.navigate(Screen.Referral.route)
                },
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route)
                },
                onNavigateToLastRead = {
                    navController.navigate(Screen.LastRead.route)
                },
                onLogout = { logout(application, navController) }
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
                onOpenFullBook = { fullBookId ->
                    navController.navigate(Screen.TextReader.createRoute(fullBookId, 0))
                },
                onOpenPdf = { bId ->
                    navController.navigate(Screen.PdfViewer.createRoute(bId))
                },
                onSearchInBook = { bId ->
                    navController.navigate(Screen.Search.createRoute(bId))
                },
                onOpenPayment = {
                    navController.navigate(Screen.Payment.route)
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
                onOpenBook = { bId ->
                    navController.navigate(Screen.BookDetails.createRoute(bId))
                },
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

        // 6. Payment & Membership Screen
        composable(Screen.Payment.route) {
            PaymentScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // 7. Payment Approval Screen
        composable(Screen.PaymentApproval.route) {
            PaymentApprovalScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // 8. In-App PDF Viewer Screen
        composable(
            route = Screen.PdfViewer.route,
            arguments = listOf(navArgument("bookId") { type = NavType.StringType })
        ) { backStackEntry ->
            val bId = backStackEntry.arguments?.getString("bookId") ?: ""
            PdfViewerScreen(
                bookId = bId,
                onBackClick = { navController.popBackStack() }
            )
        }

        // 9. Referral & Earn Screen
        composable(Screen.Referral.route) {
            ReferralScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // 10. Book Categories Screen
        composable(
            route = Screen.BookCategories.route,
            arguments = listOf(
                navArgument("bundleId") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) { backStackEntry ->
            val bundleId = backStackEntry.arguments?.getString("bundleId")
            val catViewModel: BookCategoriesViewModel = viewModel(factory = SimpleViewModelFactory {
                BookCategoriesViewModel(application)
            })
            BookCategoriesScreen(
                viewModel = catViewModel,
                initialBundleId = bundleId,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToBook = { bookId ->
                    navController.navigate(Screen.BookDetails.createRoute(bookId))
                },
                onNavigateToPayment = {
                    navController.navigate(Screen.Payment.route)
                },
                onNavigateToPlayer = {
                    val currentBookId = catViewModel.playbackState.value.bookId
                    if (!currentBookId.isNullOrBlank()) {
                        val currentChapIdx = catViewModel.playbackState.value.chapterIndex
                        navController.navigate(Screen.Player.createRoute(currentBookId, currentChapIdx))
                    }
                },
                onPlayBook = { bookId, chapterIdx ->
                    navController.navigate(Screen.Player.createRoute(bookId, chapterIdx))
                }
            )
        }

        composable(
            route = Screen.Learn.route,
            arguments = listOf(navArgument("lang") {
                type = NavType.StringType
                defaultValue = "english"
            })
        ) { backStackEntry ->
            val lang = backStackEntry.arguments?.getString("lang") ?: "english"
            val learnViewModel: LearnHomeViewModel = viewModel(factory = SimpleViewModelFactory {
                LearnHomeViewModel(application)
            })
            LearnHomeScreen(
                viewModel = learnViewModel,
                initialLanguage = lang,
                onBackClick = { navController.popBackStack() },
                onOpenCourse = { course -> navController.navigate(Screen.CourseSyllabus.createRoute(course)) },
                onOpenIntro = { asset -> navController.navigate(Screen.LearnIntro.createRoute(asset)) }
            )
        }

        composable(
            route = Screen.CourseSyllabus.route,
            arguments = listOf(navArgument("course") {
                type = NavType.StringType
                defaultValue = "present"
            })
        ) { backStackEntry ->
            val course = backStackEntry.arguments?.getString("course") ?: "present"
            val learnViewModel: LearnHomeViewModel = viewModel(factory = SimpleViewModelFactory {
                LearnHomeViewModel(application)
            })
            CourseSyllabusScreen(
                viewModel = learnViewModel,
                courseType = course,
                onBackClick = { navController.popBackStack() },
                onOpenPart = { partId -> navController.navigate(Screen.LearnPart.createRoute(partId)) },
                onOpenLesson = { lessonId -> navController.navigate(Screen.LearnLesson.createRoute(lessonId)) },
                onOpenIntro = { asset -> navController.navigate(Screen.LearnIntro.createRoute(asset)) }
            )
        }

        composable(
            route = Screen.LearnIntro.route,
            arguments = listOf(navArgument("asset") {
                type = NavType.StringType
                defaultValue = "Intro.md"
            })
        ) { backStackEntry ->
            val asset = backStackEntry.arguments?.getString("asset") ?: "Intro.md"
            CourseIntroScreen(
                assetFileName = asset,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.LearnPart.route,
            arguments = listOf(navArgument("partId") { type = NavType.StringType })
        ) { backStackEntry ->
            val partId = backStackEntry.arguments?.getString("partId") ?: ""
            val partViewModel: PartLessonsViewModel = viewModel(
                key = "learn_part_$partId",
                factory = SimpleViewModelFactory { PartLessonsViewModel(application, partId) }
            )
            PartLessonsScreen(
                viewModel = partViewModel,
                onBackClick = { navController.popBackStack() },
                onOpenLesson = { lessonId -> navController.navigate(Screen.LearnLesson.createRoute(lessonId)) },
                onOpenIntro = { asset -> navController.navigate(Screen.LearnIntro.createRoute(asset)) }
            )
        }

        composable(
            route = Screen.LearnLesson.route,
            arguments = listOf(navArgument("lessonId") { type = NavType.StringType })
        ) { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId") ?: ""
            val lessonViewModel: LessonViewModel = viewModel(
                key = "learn_lesson_$lessonId",
                factory = SimpleViewModelFactory { LessonViewModel(application, lessonId) }
            )
            LessonScreen(
                viewModel = lessonViewModel,
                onBackClick = { navController.popBackStack() },
                onOpenQuiz = { navController.navigate(Screen.LearnQuiz.createRoute(lessonId)) }
            )
        }

        composable(
            route = Screen.LearnQuiz.route,
            arguments = listOf(navArgument("lessonId") { type = NavType.StringType })
        ) { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId") ?: ""
            val quizViewModel: QuizViewModel = viewModel(
                factory = SimpleViewModelFactory { QuizViewModel(application, lessonId) }
            )
            QuizScreen(
                viewModel = quizViewModel,
                onBackClick = { navController.popBackStack() },
                onRetry = {
                    // A fresh back-stack entry gives a fresh quiz.
                    navController.navigate(Screen.LearnQuiz.createRoute(lessonId)) {
                        popUpTo(Screen.LearnQuiz.route) { inclusive = true }
                    }
                },
                onOpenNextLesson = { nextId ->
                    navController.navigate(Screen.LearnLesson.createRoute(nextId)) {
                        popUpTo(Screen.LearnLesson.route) { inclusive = true }
                    }
                }
            )
        }

        // 12. Last Read Screen (Recent Activity categorized by Modules)
        composable(Screen.LastRead.route) {
            val lastReadViewModel: LastReadViewModel = viewModel(factory = SimpleViewModelFactory {
                LastReadViewModel(application)
            })
            LastReadScreen(
                viewModel = lastReadViewModel,
                onBackClick = { navController.popBackStack() },
                onOpenPlayer = { bookId, chapterIndex ->
                    navController.navigate(Screen.Player.createRoute(bookId, chapterIndex))
                },
                onOpenBookDetails = { bookId ->
                    navController.navigate(Screen.BookDetails.createRoute(bookId))
                },
                onOpenLibrary = {
                    navController.navigate(Screen.Library.route)
                },
                onOpenLesson = { lessonId ->
                    navController.navigate(Screen.LearnLesson.createRoute(lessonId))
                },
                onOpenCourseSyllabus = {
                    navController.navigate(Screen.CourseSyllabus.createRoute("present"))
                },
                onOpenIntro = { asset ->
                    navController.navigate(Screen.LearnIntro.createRoute(asset))
                }
            )
        }
    }
}


/** Stops playback, clears the local session and shows Login with an empty back stack. */
private fun logout(application: Application, navController: NavHostController) {
    val app = application as BanglaAudiobookApp
    app.player.stopAndClose()
    app.preferences.clearUserSession()
    navController.navigate(Screen.Login.route) {
        popUpTo(navController.graph.id) { inclusive = true }
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
