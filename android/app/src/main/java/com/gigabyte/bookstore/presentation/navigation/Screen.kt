package com.gigabyte.bookstore.presentation.navigation

sealed class Screen(val route: String) {
    object Register : Screen("register")
    object Sync : Screen("sync")
    object Home : Screen("home")
    object Library : Screen("library")
    object BookDetails : Screen("book_details/{bookId}") {
        fun createRoute(bookId: String) = "book_details/$bookId"
    }
    object Player : Screen("player/{bookId}/{chapterIndex}") {
        fun createRoute(bookId: String, chapterIndex: Int = 0) = "player/$bookId/$chapterIndex"
    }
    object TextReader : Screen("text_reader/{bookId}/{chapterIndex}") {
        fun createRoute(bookId: String, chapterIndex: Int = 0) = "text_reader/$bookId/$chapterIndex"
    }
    object Settings : Screen("settings")
    object Payment : Screen("payment")
    object PaymentApproval : Screen("payment_approval")
    object Search : Screen("search?bookId={bookId}") {
        fun createRoute(bookId: String? = null) = if (bookId != null) "search?bookId=$bookId" else "search"
    }
    object PdfViewer : Screen("pdf_viewer/{bookId}") {
        fun createRoute(bookId: String) = "pdf_viewer/$bookId"
    }
    object Referral : Screen("referral")
    object BookCategories : Screen("book_categories?bundleId={bundleId}") {
        fun createRoute(bundleId: String? = null) = if (bundleId != null) "book_categories?bundleId=$bundleId" else "book_categories"
    }

    // English learning module
    object Learn : Screen("learn")
    object LearnPart : Screen("learn/part/{partId}") {
        fun createRoute(partId: String) = "learn/part/$partId"
    }
    object LearnLesson : Screen("learn/lesson/{lessonId}") {
        fun createRoute(lessonId: String) = "learn/lesson/$lessonId"
    }
    object LearnQuiz : Screen("learn/quiz/{lessonId}") {
        fun createRoute(lessonId: String) = "learn/quiz/$lessonId"
    }
}

