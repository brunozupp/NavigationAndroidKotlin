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

        val id = jsonObject["idMeal"]!!.jsonPrimitive.content
        val name = jsonObject["strMeal"]!!.jsonPrimitive.content
        val category = jsonObject["strCategory"]!!.jsonPrimitive.content
        val area = jsonObject["strArea"]!!.jsonPrimitive.content
        val instructions = jsonObject["strInstructions"]!!.jsonPrimitive.content

        val tags = jsonObject["strTags"]?.jsonPrimitive?.contentOrNull?.split(",")?.filter { it.isNotEmpty() } ?: emptyList()

//        val ingredients = jsonObject.entries
//            .filter { it.key.startsWith("strIngredient") }
//            .mapNotNull { it.value.jsonPrimitive.contentOrNull }
//            .filter { it.isNotBlank() }
//
//        val measures = jsonObject.entries
//            .filter { it.key.startsWith("strMeasure") }
//            .mapNotNull { it.value.jsonPrimitive.contentOrNull }
//            .filter { it.isNotBlank() }

//        val ingredients = jsonObject.entries
//            .filter { it.key.startsWith("strIngredient") }
//            .associateBy { it.key.replace("\\w+", "") }
//            .filter { it.value.value.jsonPrimitive.contentOrNull != null }
//            .filter { it.value.value.jsonPrimitive.content.isNotBlank() }

        val ingredients = jsonObject.entries
            .filter { it.key.startsWith("strIngredient") }
            .mapNotNull { entry ->

                val index = entry.key.removePrefix("strIngredient")
                val value = entry.value.jsonPrimitive.contentOrNull?.takeIf { it.isNotBlank() }

                if(index.isNotBlank() && value != null) {
                    index to value
                } else {
                    null
                }
            }
            .toMap()

        val measures = jsonObject.entries
            .filter { it.key.startsWith("strMeasure") }
            .mapNotNull { entry ->

                val index = entry.key.removePrefix("strMeasure")
                val value = entry.value.jsonPrimitive.contentOrNull?.takeIf { it.isNotBlank() }

                if(index.isNotBlank() && value != null) {
                    index to value
                } else {
                    null
                }
            }
            .toMap()

        val ingredientsWithMeasures = mutableListOf<String>()

        ingredients.forEach { key, value ->

            var ingredient = value

            if(measures.contains(key)) {
                ingredient += " - ${measures[key]}"
            }

            ingredientsWithMeasures.add(ingredient)
        }

        return MealDetailsModel(
            id = id,
            name = name,
            category = category,
            area = area,
            tags = tags,
            instructions = instructions,
            ingredients = ingredientsWithMeasures,
        )
    }
}