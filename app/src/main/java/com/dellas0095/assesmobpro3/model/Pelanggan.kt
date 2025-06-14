package com.dellas0095.assesmobpro3.model

data class Pelanggan(
    val id: Int,
    val imagepath : String,
    val nama_pelanggan : String,
    val varian : String,
    val warna : String,
    val upload_date : String,
    val imageUrl : String?= null
)