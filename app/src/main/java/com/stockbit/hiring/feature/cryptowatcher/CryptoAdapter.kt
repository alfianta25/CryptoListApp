package com.stockbit.hiring.feature.cryptowatcher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.myans.littlestockbitdev.utils.DiffCallBack
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.CryptoItemBinding
import com.stockbit.repository.utils.Crypto
import java.text.NumberFormat
import java.util.*

class CryptoAdapter: RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {
    private var items: List<Crypto> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding: CryptoItemBinding = CryptoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CryptoViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    fun updateList(newList: List<Crypto>){
        val diffResult = DiffUtil.calculateDiff(ListDiffCallback(items, newList))
        items = newList
        diffResult.dispatchUpdatesTo(this)
    }

    fun setList(list: List<Crypto>){
        items = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) = holder.bind(items[position])
    fun isDataSetEmpty(): Boolean {
        return items.isEmpty()
    }

    class CryptoViewHolder(private val itemBinding: CryptoItemBinding): RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Crypto) {
            itemBinding.companyName.text = item.companyName
            itemBinding.name.text = item.name
            itemBinding.currentValue.text = formatNumber(item.currentValue)
            itemBinding.differentValues.text = formatDifferentValue(item.openValue, item.currentValue)

            if (item.currentValue > item.openValue) {
                itemBinding.differentValues.setTextColor(ContextCompat.getColor(itemView.context, R.color.greenPrimary))
            } else {
                itemBinding.differentValues.setTextColor(ContextCompat.getColor(itemView.context, R.color.redPrimary))
            }
        }

        private fun formatNumber(value: Double): String {
            val format: NumberFormat = NumberFormat.getNumberInstance(Locale.US)
            format.setMaximumFractionDigits(3)
            return format.format(value)
        }

        private fun formatDifferentValue(start: Double, current: Double): String {
            val builder = StringBuilder()
            val different = current - start
            if (different > 0) {
                builder.append("+")
            } else {
                builder.append("-")
            }
            builder.append(String.format("%.2f", different))
            builder.append(" (")
            if (different > 0) {
                builder.append("+")
            }
            val percentage = String.format("%.2f", (different * 100) / start)
            builder.append("$percentage%)")
            return builder.toString()
        }

    }

    class ListDiffCallback constructor(oldList: List<Crypto>, newList: List<Crypto>): DiffCallBack<Crypto>(oldList, newList){
        init {
            this.oldList = oldList
            this.newList = newList
        }
        override fun checkEquality(oldItem: Crypto, newItem: Crypto): Boolean {
            return true
        }
    }
}