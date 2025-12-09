package com.novelitech.navigationwithretrofitmvvm.features.mealDetails.data.serializers

import com.novelitech.navigationwithretrofitmvvm.features.mealDetails.data.models.MealDetailsModel
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object MealDetailsSerializer : KSerializer<MealDetailsModel> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("MealDetailsModel")

    override fun serialize(
        encoder: Encoder,
        value: MealDetailsModel,
    ) {
        throw NotImplementedError("Serialization not required")
    }

    override fun deserialize(decoder: Decoder): MealDetailsModel {

        val input = decoder as? JsonDecoder ?: error("This serializer only works with JSON")

        val jsonObject = input.decodeJsonElement().jsonObject

        val id = jsonObject[""]!!.jsonPrimitive.content
        val name = jsonObject[""]!!.jsonPrimitive.content
        val category = jsonObject[""]!!.jsonPrimitive.content
        val area = jsonObject[""]!!.jsonPrimitive.content
        val instructions = jsonObject[""]!!.jsonPrimitive.content

        val ingredients = jsonObject.entries
            .filter { it.key.startsWith("strIngredient") }
            .mapNotNull { it.value.jsonPrimitive.contentOrNull }
            .filter { it.isNotBlank() }

        val measures = jsonObject.entries
            .filter { it.key.startsWith("strMeasure") }
            .mapNotNull { it.value.jsonPrimitive.contentOrNull }
            .filter { it.isNotBlank() }

        return MealDetailsModel(
            id = id,
            name = name,
            category = category,
            area = area,
            instructions = instructions,
            ingredients = ingredients,
            measures = measures,
        )
    }
}