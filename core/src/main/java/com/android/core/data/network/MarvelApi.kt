package com.android.core.data.network

import com.android.core.data.network.response.DataWrapperResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MarvelApi {

    @GET("characters") //aqui vai o endPoint depois do baseUrl
    suspend fun getCharacters(
        @QueryMap //faz o mapeamento do gson jogando para a classe DataWrapperResponse
        queries: Map<String, String>
    ): DataWrapperResponse

}