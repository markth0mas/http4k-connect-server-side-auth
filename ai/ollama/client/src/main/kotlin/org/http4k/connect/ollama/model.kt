package org.http4k.connect.ollama

import dev.forkhandles.values.NonBlankStringValueFactory
import dev.forkhandles.values.StringValue
import org.http4k.connect.model.Base64Blob

class ModelName private constructor(value: String) : StringValue(value) {
    companion object : NonBlankStringValueFactory<ModelName>(::ModelName)
}

class Prompt private constructor(value: String) : StringValue(value) {
    companion object : NonBlankStringValueFactory<Prompt>(::Prompt)
}

class SystemMessage private constructor(value: String) : StringValue(value) {
    companion object : NonBlankStringValueFactory<SystemMessage>(::SystemMessage)
}

class Template private constructor(value: String) : StringValue(value) {
    companion object : NonBlankStringValueFactory<Template>(::Template)
}

enum class ResponseFormat {
    json
}

enum class Role {
    system, user, assistant
}

data class Message(val role: Role, val content: String, val images: List<Base64Blob>? = null)
