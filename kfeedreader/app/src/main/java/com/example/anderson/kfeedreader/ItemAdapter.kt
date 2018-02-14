package com.example.anderson.kfeedreader

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_list.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Anderson on 2/14/2018.
 */


class ItemAdapter(val list:ArrayList<MainActivity.Item>, val context: Context):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>()
{

    class ItemViewHolder(view : View):RecyclerView.ViewHolder(view){
        val titulo = view.findViewById(R.id.titulo) as TextView
        val autor = view.findViewById(R.id.autor)as TextView
        val data = view.findViewById(R.id.data)as TextView
        val imagem = view.findViewById(R.id.imagem)as TextView
        val btnVerMais = view.findViewById(R.id.btnVerMais)as TextView

    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_list, parent, false)
        val ivh = ItemViewHolder(v)

        return ivh
    }

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        holder?.titulo?.text=list[position].titulo
        holder?.autor?.text=list[position].autor
        holder?.data?.text=SimpleDateFormat("dd/MM/yyy", Locale("pt", "BR")).format(Date(list[position].data))
        holder?.btnVerMais?.setOnClickListener{
            val intent= Intent(Intent.ACTION_VIEW, list[position].link)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int =list.size  //criando método em uma linha







}