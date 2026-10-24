package com.gigabyte.bookstore.presentation.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
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

    // English and Japanese learning module
    object Learn : Screen("learn?lang={lang}") {
        fun createRoute(lang: String = "english") = "learn?lang=$lang"
    }
    object LearnPart : Screen("learn/part/{partId}") {
        fun createRoute(partId: String) = "learn/part/$partId"
    }
    object LearnLesson : Screen("learn/lesson/{lessonId}") {
        fun createRoute(lessonId: String) = "learn/lesson/$lessonId"
    }
    object LearnQuiz : Screen("learn/quiz/{lessonId}") {
        fun createRoute(lessonId: String) = "learn/quiz/$lessonId"
    }
    object LearnIntro : Screen("learn/intro?asset={asset}") {
        fun createRoute(asset: String = "Intro.md") = "learn/intro?asset=$asset"
    }
    object CourseSyllabus : Screen("learn/course/syllabus?course={course}") {
        fun createRoute(course: String = "present") = "learn/course/syllabus?course=$course"
    }
    object LastRead : Screen("last-read")
}

