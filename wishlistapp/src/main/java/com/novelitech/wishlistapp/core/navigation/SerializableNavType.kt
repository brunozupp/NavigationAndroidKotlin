package com.novelitech.wishlistapp.core.navigation

import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * Keyword inline -> a kotlin inline function is a function marked with the 'inline' keyword that
 * instructs the compiler to copy the function's entire body directly into the code where it is
 * called (the call site), instead of creating a normal function call at runtime. This eliminates
 * the overhead of function calls and is particularly useful for optimizing performance when using
 * higher-order functions (functions that accept other functions as parameters) and lambdas
 *
 * Keyword reified -> it allows a generic type to be accessed at runtime by inlining the function
 * and replacing the generic with the real type at the call site. It is required when type
 * information (like serializers or class references) is needed at runtime. By default, generics
 * disappear at runtime and reified brings them back - but only by copying the code 'inline'.
 *
 * Now, a brief explanation about generics and the use of inline and reified:
 *
 * Given the code: fun <T> foo(value: T) { ... }
 * At runtime, JVM does NOT know what T is, because of type erasure.
 * Another example would be, at runtime, List<String> and List<Int> both becomes just List.
 * Being aware of those scenarios, I can not:
 * - Check "T::class"
 * - Do "is T"
 * - Call serializers/deserializers that need the actual type
 *
 * And here is where reified shines, because it maintain the type of the generics in runtime, making
 * possible to me do those things listed above. But it only works in inline functions. This happens
 * because, as the function is marked with inline, the compiler:
 * - Copies the function body
 * - Pastes it at the call site
 * - Replaces T with the real type
 *
 * And to use reified I need to put inline in my function, because:
 * - The JVM does not support runtime generics
 * - Kotlin fakes it using inlining
 *
 * So summarizing:
 * reified ➜ requires inline
 * inline ➜ allows reified
 *
 * Examples of inline function that are common in Android development:
 * inline fun <reified VM : ViewModel> viewmodel() : VM
 * inline fun <reified T> NavBackStackEntry.toRoute() : T
 * inline fun <reified T> Json.decodeFromString(json: String) : T
 * inline fun <reified T> get() : T
 *
 * One last thing now: When NOT to use reified ->
 * When the function:
 * - is not 'inline'
 * - is very large (inlining can increase bytecode size)
 * - is part of a public Java API
 *
 * In those cases, I pass the type manually:
 * fun <T> decode(json: String, clazz: Class<T>)
 */
inline fun <reified T> serializableNavType(
    json: Json = Json
): NavType<T?> =
    object : NavType<T?>(isNullableAllowed = true) {

        override fun put(bundle: Bundle, key: String, value: T?) {
            if (value == null) {
                bundle.putString(key, null)
            } else {
                bundle.putString(key, json.encodeToString(value))
            }
        }

        override fun get(bundle: Bundle, key: String): T? {
            val string = bundle.getString(key) ?: return null
            return json.decodeFromString(string)
        }

        override fun parseValue(value: String): T? {
            if (value == "null") return null

            val decoded = URLDecoder.decode(
                value,
                StandardCharsets.UTF_8.name()
            )
            return json.decodeFromString(decoded)
        }

        override fun serializeAsValue(value: T?): String {
            if (value == null) return "null"

            return URLEncoder.encode(
                json.encodeToString(value),
                StandardCharsets.UTF_8.name()
            )
        }
    }