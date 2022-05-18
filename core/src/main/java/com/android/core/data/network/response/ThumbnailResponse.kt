package com.android.core.data.network.response

import com.google.gson.annotations.SerializedName

data class ThumbnailResponse(
/*
    usa se essa anotacao abaixo (@SerializedName) caso vc queira deixar o nome da variável diferente do campo que vem da api
    se caso vc nao quiser colocar essa anotacao é só deixar com o nome davariavel igual o que esta no json da api
*/
    @SerializedName("path")
    val caminho: String,
    val extension: String
)
