package com.dellas0095.assesmobpro3.network


import android.media.Image
import com.dellas0095.assesmobpro3.model.GeneralApiResponse
import com.dellas0095.assesmobpro3.model.Pelanggan
import com.dellas0095.assesmobpro3.model.OpStatus
import com.dellas0095.assesmobpro3.model.PelangganResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

private const val BASE_URL = "https://store.sthresearch.site/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PelangganApiService {
    @GET("api.php")
    suspend fun getPelanggan(
        @Header("Authorization") userId: String
    ): PelangganResponse

    @Multipart
    @POST("api.php")
    suspend fun postPelanggan(
        @Header("Authorization") userId: String,
        @Part("nama_pelanggan") namaPelanggan: RequestBody,
        @Part("varian") varian: RequestBody,
        @Part("warna") warna: RequestBody,
        @Part gambar: MultipartBody.Part
    ): GeneralApiResponse

    @Multipart
    @POST("api.php")
    suspend fun updateBuah(
        @Header("Authorization") userEmail: String,
        @Query("nama_pelanggan") imageId : Int,
        @Part("varian") varian: RequestBody,
        @Part("warna") warna: RequestBody
    ): GeneralApiResponse


    @DELETE("api.php")
    suspend fun deletePelanggan(
        @Header("Authorization") userId: String,
        @Query("id") id: Int
    ): GeneralApiResponse
}

object PelangganApi {
    val service: PelangganApiService by lazy {
        retrofit.create(PelangganApiService::class.java)
    }

    fun getPelangganUrl(imageId: String): String {
        return BASE_URL + imageId
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }