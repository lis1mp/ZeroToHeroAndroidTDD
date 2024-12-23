package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ItemLayoutBinding

class MyItemsAdapter : RecyclerView.Adapter<MyItemViewHolder>() {

    private val itemsList = ArrayList<CharSequence>()

    fun add(source: CharSequence) {
        itemsList.add(source)
        notifyItemInserted(itemsList.lastIndex)
    }

    fun save(bundle: Bundle) {
        bundle.putCharSequenceArrayList(KEY, itemsList)
    }

    fun restore(bundle: Bundle) {
        itemsList.addAll(bundle.getCharSequenceArrayList(KEY) ?: ArrayList())
        notifyItemRangeInserted(0, itemsList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemViewHolder {
        return MyItemViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = itemsList.size

    override fun onBindViewHolder(holder: MyItemViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    companion object {
        private const val KEY = "MyItemsAdapterKey"
    }
}

class MyItemViewHolder(private val binding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(source: CharSequence) {
        binding.elementTextView.text = source
    }
}