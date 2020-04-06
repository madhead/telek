package by.dev.madhead.telek.model

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.modules.SerializersModule

val json = Json(
    configuration = JsonConfiguration(
        encodeDefaults = false,
        ignoreUnknownKeys = true
    ),
    context = SerializersModule {
        polymorphic(ReplyMarkup::class) {
            ForceReply::class with ForceReply.serializer()
            InlineKeyboardMarkup::class with InlineKeyboardMarkup.serializer()
            ReplyKeyboardMarkup::class with ReplyKeyboardMarkup.serializer()
            ReplyKeyboardRemove::class with ReplyKeyboardRemove.serializer()
        }
    }
)
