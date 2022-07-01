package com.example.core_network.retrofit

import com.example.core_common.BuildConfig
import com.example.core_network.NiANetwork
import com.example.core_network.model.NetworkTopic
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitNiANetworkApi {
    @GET(value = "topics")
    suspend fun getTopics(
        @Query("id") ids: List<String>?
    ): NetworkResponse<List<NetworkTopic>>

}

private const val NiABaseUrl = BuildConfig.BACKEND_URL

@Serializable
private data class NetworkResponse<T>(
    val data: T
)


@Singleton
class RetrofitNiANetwork @Inject constructor(
    networkJson: Json
) : NiANetwork {

    private val networkApi = Retrofit.Builder()
        .baseUrl(NiABaseUrl)
        .client(
            OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            ).build()
        )
        .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(RetrofitNiANetworkApi::class.java)

    override suspend fun getTopics(ids: List<String>?): List<NetworkTopic> =
        networkApi.getTopics(ids = ids).data
}
