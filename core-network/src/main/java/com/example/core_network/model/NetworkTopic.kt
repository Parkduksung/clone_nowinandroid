package com.example.core_network.model

import com.example.core_model.Topic
import kotlinx.serialization.Serializable

//저 토픽 눌렀을때 model.Topic 으로 가려면 import 시켜주면 된다.
/**
 * Network representation of [Topic]
 */
@Serializable
data class NetworkTopic(
    val id: String,
    val name: String = "",
    val shortDescription: String = "",
    val longDescription: String = "",
    val url: String = "",
    val imageUrl: String = "",
    val followed: Boolean = false
)

