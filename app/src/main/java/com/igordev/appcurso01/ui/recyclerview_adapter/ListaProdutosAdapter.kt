package com.igordev.appcurso01.ui.recyclerview_adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.igordev.appcurso01.databinding.ProdutoInfoBinding
import com.igordev.appcurso01.ui.Model.Produto
import kotlinx.coroutines.NonDisposableHandle.parent
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class ListaProdutosAdapter(
    private val context:Context,
    produtos: List<Produto>,
    private val onClickListener: OnclickListener
):RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {
    private val produtos = produtos.toMutableList()


   class ViewHolder(private val binding: ProdutoInfoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun vincula(produto: Produto) {
            val nome = binding.txtNome
            val faixa = binding.txtFaixa
            val mensalidade = binding.txtStatusMensalidade
            val img = binding.image
            nome.text = produto.nome
            faixa.text = produto.faixa
            mensalidade.text = produto.mensalidade
            img.load(produto.imagem)
        }
    }
    class OnclickListener(val clickListener:(produto:Produto)->Unit){
        fun onClick(produto: Produto) = clickListener(produto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoInfoBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = produtos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(produto)
        }
    }

}