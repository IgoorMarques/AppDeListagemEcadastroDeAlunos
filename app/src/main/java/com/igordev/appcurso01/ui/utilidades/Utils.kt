package com.igordev.appcurso01.ui.utilidades

import android.widget.EditText
import com.igordev.appcurso01.ui.Model.Produto


class Utils{
    fun limparTela(nome:EditText, descricao:EditText, valor:EditText){
        nome.text.clear()
        descricao.text.clear()
        valor.text.clear()
    }
    fun adicionar(produto: Produto){
        listaProdutos.add(produto)
    }
    fun buscarTodos():List<Produto>{
        return listaProdutos.toList()
    }

    companion object{
        private val listaProdutos = mutableListOf<Produto>(
            Produto(
                nome = "Igor Marques da Costa",
                    faixa = "BRANCA",
                    mensalidade = "PAGA",
                    imagem = "https://miro.medium.com/v2/resize:fit:1400/1*g09N-jl7JtVjVZGcd-vL2g.jpeg"
            )
        )
    }

}