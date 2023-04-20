package com.igordev.appcurso01.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.igordev.appcurso01.R
import com.igordev.appcurso01.databinding.ActivityTelaOpcoesBinding

class telaOpcoes : AppCompatActivity(R.layout.activity_tela_opcoes) {
    val telaOpcoes by lazy {ActivityTelaOpcoesBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(telaOpcoes.root)
    }

    override fun onResume() {
        super.onResume()
        telaOpcoes.btNovoAluno.setOnClickListener {
            val abrirTelaCadastro = Intent(this, formularioCadastroItem::class.java)
            startActivity(abrirTelaCadastro)
            finish()
        }
        telaOpcoes.buttonHome.setOnClickListener {
            val voltarTelaPrincipal = Intent(this, MainActivity::class.java)
            startActivity(voltarTelaPrincipal)
            finish()
        }
    }
}