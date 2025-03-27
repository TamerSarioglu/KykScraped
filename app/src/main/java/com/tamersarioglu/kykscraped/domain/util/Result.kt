package com.tamersarioglu.kykscraped.domain.util


/**
 * A generic wrapper to handle success/error scenarios
 */
sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error<T>(val message: String, val exception: Exception? = null) : Result<T>()
    class Loading<T> : Result<T>()

    companion object {
        /**
         * Utility function to create a Success result
         */
        fun <T> success(data: T): Result<T> = Success(data)

        /**
         * Utility function to create an Error result
         */
        fun <T> error(message: String, exception: Exception? = null): Result<T> = Error(message, exception)

        /**
         * Utility function to create a Loading result
         */
        fun <T> loading(): Result<T> = Loading()
    }
}