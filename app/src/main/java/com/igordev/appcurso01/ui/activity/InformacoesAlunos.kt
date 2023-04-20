package com.igordev.appcurso01.ui.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import coil.load
import com.igordev.appcurso01.databinding.ActivityInformacoesAlunosBinding
import com.igordev.appcurso01.ui.Model.Produto

class InformacoesAlunos : AppCompatActivity() {
    private lateinit var binding: ActivityInformacoesAlunosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacoesAlunosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        repcuperaDados()
    }
    @Suppress("DEPRECATION")
    private fun repcuperaDados(){
        val produto = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("aluno", Produto::class.java)
        } else {
            intent.getParcelableExtra<Produto>("aluno")
        }
        binding.textViewNome.text = produto?.nome
        binding.imageView.load(produto?.imagem)
        binding.textViewStatusMensalidade.text = produto?.mensalidade
        binding.textViewFaixaGraus.text = produto?.faixa

    }
}