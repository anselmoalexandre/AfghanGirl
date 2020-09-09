package mz.co.bilheteira.afghangirl.util

/**
 * Resource class to switch from different network states
 * [data] Network response data
 * [message] Network response message {Successful or Error message}
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String?, data: T? = null) : Resource<T>(message = message, data = data)
}