package dev.whysoezzy.common

sealed class ScreenState<out T> {
    object Loading : ScreenState<Nothing>()
    data class Content<out T>(val data: T) : ScreenState<T>()
    data class Error(val message: String) : ScreenState<Nothing>()
}