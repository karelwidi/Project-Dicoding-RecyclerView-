package com.example.project_akhir.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShoesData (
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable