package com.example.core_network.retrofit

import com.example.core_model.BuildConfig
import com.example.core_network.NiANetwork
import com.example.core_network.model.NetworkAuthor
import com.example.core_network.model.NetworkChangeList
import com.example.core_network.model.NetworkNewsResource
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

/**
 * Retrofit API declaration for NIA Network API
 */
private interface RetrofitNiANetworkApi {
    @GET(value = "topics")
    suspend fun getTopics(
        @Query("id") ids: List<String>?,
    ): NetworkResponse<List<NetworkTopic>>

    @GET(value = "authors")
    suspend fun getAuthors(
        @Query("id") ids: List<String>?,
    ): NetworkResponse<List<NetworkAuthor>>

    @GET(value = "newsresources")
    suspend fun getNewsResources(
        @Query("id") ids: List<String>?,
    ): NetworkResponse<List<NetworkNewsResource>>

    @GET(value = "changelists/topics")
    suspend fun getTopicChangeList(
        @Query("after") after: Int?,
    ): List<NetworkChangeList>

    @GET(value = "changelists/authors")
    suspend fun getAuthorsChangeList(
        @Query("after") after: Int?,
    ): List<NetworkChangeList>

    @GET(value = "changelists/newsresources")
    suspend fun getNewsResourcesChangeList(
        @Query("after") after: Int?,
    ): List<NetworkChangeList>
}

//todo BuildConfig 를 network 꺼로 변경해야함.
private const val NiABaseUrl = BuildConfig.BACKEND_URL

/**
 * Wrapper for data provided from the [NiABaseUrl]
 */
@Serializable
private data class NetworkResponse<T>(
    val data: T
)

/**
 * [Retrofit] backed [NiANetwork]
 */
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

    override suspend fun getAuthors(ids: List<String>?): List<NetworkAuthor> =
        networkApi.getAuthors(ids = ids).data

    override suspend fun getNewsResources(ids: List<String>?): List<NetworkNewsResource> =
        networkApi.getNewsResources(ids = ids).data

    override suspend fun getTopicChangeList(after: Int?): List<NetworkChangeList> =
        networkApi.getTopicChangeList(after = after)

    override suspend fun getAuthorChangeList(after: Int?): List<NetworkChangeList> =
        networkApi.getAuthorsChangeList(after = after)

    override suspend fun getNewsResourceChangeList(after: Int?): List<NetworkChangeList> =
        networkApi.getNewsResourcesChangeList(after = after)
}
