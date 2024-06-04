package nathcorrealopes.com.github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nathcorrealopes.com.github.R
import nathcorrealopes.com.github.model.ItemModel

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items = mutableListOf<ItemModel>()

    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }
    fun removeItem(item: ItemModel){
        items.remove(item)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //private val textViewPraia = view.findViewById<EditText>(R.id.edittextpraia)
        //private val textViewCidade = view.findViewById<EditText>(R.id.edittextcidade)
        //private val textViewEstado = view.findViewById<EditText>(R.id.edittextestado)
        val textView = view.findViewById<TextView>(R.id.textviewlista)
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun bind(item: ItemModel) {
            //textViewPraia.text = item.name
            //textViewCidade.text = item.name1
            //textViewEstado.text = item.name2
            textView.text = item.name
            textView.text = item.name1
            textView.text = item.name2

            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }
}