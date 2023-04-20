package com.igordev.appcurso01.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import coil.load
import com.igordev.appcurso01.R
import com.igordev.appcurso01.databinding.ActivityFormularioCadastroItemBinding
import com.igordev.appcurso01.databinding.FormularioImagemBinding
import com.igordev.appcurso01.ui.Model.Produto
import com.igordev.appcurso01.ui.utilidades.Utils


class formularioCadastroItem : AppCompatActivity(R.layout.activity_formulario_cadastro_item) {
    val telaCadastro by lazy {ActivityFormularioCadastroItemBinding.inflate(layoutInflater)}
    private var url:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(telaCadastro.root)

        telaCadastro.btCadastrar.setOnClickListener {
            cadastrar()
        }

        telaCadastro.buttonHome.setOnClickListener {
            val backToMain = Intent(this, MainActivity::class.java)
            startActivity(backToMain)
            finish()
        }

        telaCadastro.btVoltar.setOnClickListener {
            val backToOptions = Intent(this, telaOpcoes::class.java)
            startActivity(backToOptions)
            finish()
        }

        telaCadastro.imagemCadastro.setOnClickListener {
            cadastrarImg()
        }
    }







    private fun cadastrarImg() {
        val bindingFormularioImagem = FormularioImagemBinding.inflate(layoutInflater)
        AlertDialog.Builder(this)
            .setView(bindingFormularioImagem.root)
            .setPositiveButton("Confirmar") { _, _ ->
                url = bindingFormularioImagem.textInputUrl.text.toString()
                if (!url.isNullOrEmpty()) {
                    telaCadastro.imagemCadastro.load(url)
                }
            }
            .setNegativeButton("Cancelar") { _, _ -> }
            .show()

        bindingFormularioImagem.formularioImagemBtCarregar.setOnClickListener {
            url = bindingFormularioImagem.textInputUrl.text.toString()
            if (url.isNullOrEmpty()) {
                Toast.makeText(this, "Informe o link", Toast.LENGTH_SHORT).show()
            } else {
                bindingFormularioImagem.formularioImagemImagemview.load(url)
            }
        }
    }


    private fun cadastrar() {
        val nome =telaCadastro.inputNome.text.toString()
        val faixa = telaCadastro.inputFaixa.text.toString()
        val mensalidade = telaCadastro.inputStatusMensalidade.text.toString()
        val utils = Utils()
        if (nome.isNotEmpty().and(faixa.length >= 3).and(mensalidade.isNotEmpty())) {
            utils.adicionar(Produto(nome, faixa, mensalidade, url))
            Toast.makeText(this, "Prduto\ncadastrado!", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            if (nome.isEmpty()) {
                telaCadastro.inputNome.error = "Informe um nome"
            }
            if (faixa.length < 5) {
                telaCadastro.inputFaixa.error = "Informe a descrição\ncom no minimo\n5 caractwewa"
            }
            if (mensalidade.isEmpty()) {
                telaCadastro.inputStatusMensalidade.error = "Informe o valor"
            }
        }
    }

}