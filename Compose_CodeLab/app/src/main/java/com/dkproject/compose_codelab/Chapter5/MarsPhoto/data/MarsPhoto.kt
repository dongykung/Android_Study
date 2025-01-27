package com.dkproject.compose_codelab.Chapter5.MarsPhoto.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto(
    val id: String,
    @SerialName(value = "img_src")
    val imageSrc: String
)
