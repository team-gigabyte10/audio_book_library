package com.gigabyte.bookstore.presentation.navigation

sealed class Screen(val route: String) {
    object Register : Screen("register")
    object Sync : Screen("sync")
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
}

