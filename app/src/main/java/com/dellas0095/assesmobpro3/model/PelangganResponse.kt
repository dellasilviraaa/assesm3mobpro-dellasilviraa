package com.dellas0095.assesmobpro3.model

data class PelangganResponse(
    val status: String,
    val data: List<Pelanggan>,
    val message: String? = ""
)