package com.example.core_network

import com.example.core_network.model.NetworkTopic

interface NiANetwork {

    suspend fun getTopics(ids: List<String>? = null): List<NetworkTopic>
}