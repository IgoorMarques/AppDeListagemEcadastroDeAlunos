package com.igordev.appcurso01.ui.activity

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.igordev.appcurso01.R
import com.igordev.appcurso01.databinding.ActivityMainBinding
import com.igordev.appcurso01.ui.Model.Produto
import com.igordev.appcurso01.ui.utilidades.Utils
import com.igordev.appcurso01.ui.recyclerview_adapter.ListaProdutosAdapter

class MainActivity:AppCompatActivity(R.layout.activity_main){
    private val utils = Utils()
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        binding.listaDeProdutos.adapter = ListaProdutosAdapter(this, utils.buscarTodos(),ListaProdutosAdapter.OnclickListener{
            val intent = Intent(this, InformacoesAlunos::class.java)
                .putExtra("aluno", it)
            startActivity(intent)
        })
        binding.btAdd.setOnClickListener {
            val intent = Intent(this, telaOpcoes::class.java)
            startActivity(intent)
        }

    }
}