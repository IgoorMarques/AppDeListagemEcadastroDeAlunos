package com.igordev.appcurso01.ui.Model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Produto(
    val nome: String?,
    val faixa: String?,
    val mensalidade: String?,
    val imagem:String? = null
) : Parcelable