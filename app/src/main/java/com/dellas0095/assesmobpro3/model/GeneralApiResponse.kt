package com.dellas0095.assesmobpro3.model

class GeneralApiResponse (
    var status: String,
    var message: String? = "",
    val id: Int? = null,
    val imagepath : String? = null,
    val nama_pelanggan : String? = null,
    val varian : String? = null,
    val warna : String? = null,
    val upload_date : String? = null,
    val imageUrl : String?= null
    )