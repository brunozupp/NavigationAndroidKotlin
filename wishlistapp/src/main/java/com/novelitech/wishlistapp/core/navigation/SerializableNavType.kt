package com.novelitech.wishlistapp.core.navigation

import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

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