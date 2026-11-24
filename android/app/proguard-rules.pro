# ==============================================================================
# ProGuard & R8 Configuration for Bangla Audiobook & Spoken Course (com.gigabyte.bookstore)
# ==============================================================================

# ------------------------------------------------------------------------------
# 1. Line Numbers & Source File Information for Play Console Crash Reporting
# ------------------------------------------------------------------------------
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Preserve standard annotations and signatures for reflection
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod,Exceptions

# ------------------------------------------------------------------------------
# 2. Firestore & Application Data Models
# Preserve data classes and their properties/constructors for Firestore toObject()
# ------------------------------------------------------------------------------
-keepclassmembers class com.gigabyte.bookstore.data.models.** {
    <fields>;
    <init>();
    public *;
}
-keep class com.gigabyte.bookstore.data.models.** { *; }

-keepclassmembers class com.gigabyte.bookstore.learning.domain.model.** {
    <fields>;
    <init>();
    public *;
}
-keep class com.gigabyte.bookstore.learning.domain.model.** { *; }

-keepclassmembers class com.gigabyte.bookstore.learning.presentation.**.*Model* {
    <fields>;
    <init>();
    public *;
}

# ------------------------------------------------------------------------------
# 3. Room Database
# ------------------------------------------------------------------------------
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-keepclassmembers @androidx.room.Entity class * { <fields>; }
-keep @androidx.room.Dao interface * { <methods>; }
-keep class * extends androidx.room.migration.Migration
-dontwarn androidx.room.paging.**

# ------------------------------------------------------------------------------
# 4. Moshi & Retrofit
# ------------------------------------------------------------------------------
-keep class com.squareup.moshi.** { *; }
-keepclassmembers class * {
    @com.squareup.moshi.Json <fields>;
    @com.squareup.moshi.JsonQualifier <fields>;
}
-dontwarn com.squareup.moshi.**

-keepclassmembers enum * { *; }
-keep class retrofit2.** { *; }
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-dontwarn retrofit2.**
-dontwarn okhttp3.**
-dontwarn okio.**

# ------------------------------------------------------------------------------
# 5. Firebase (AppCheck, Firestore, Storage)
# ------------------------------------------------------------------------------
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# ------------------------------------------------------------------------------
# 6. Meta Audience Network (Facebook Ads)
# ------------------------------------------------------------------------------
-keep class com.facebook.ads.** { *; }
-dontwarn com.facebook.ads.**
-dontwarn com.facebook.infer.annotation.**

# ------------------------------------------------------------------------------
# 7. QR Code Scanner / ZXing
# ------------------------------------------------------------------------------
-keep class com.google.zxing.** { *; }
-dontwarn com.google.zxing.**
-keep class com.google.android.gms.code.scanner.** { *; }

# ------------------------------------------------------------------------------
# 8. Kotlin Coroutines & Jetpack Compose
# ------------------------------------------------------------------------------
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-dontwarn kotlinx.coroutines.**

# Compose runtime rules are bundled, but retain Composable annotations
-keepattributes RuntimeVisibleAnnotations,RuntimeInvisibleAnnotations
