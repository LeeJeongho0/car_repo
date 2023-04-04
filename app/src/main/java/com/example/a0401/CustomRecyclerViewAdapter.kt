package com.example.a0401

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.a0401.databinding.ItemViewBinding

class CustomRecyclerViewAdapter(val dataList:MutableList<DataList>):RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CustomViewHolder(itemViewBinding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemViewBinding = holder.itemViewBinding
        itemViewBinding.tvName1.text = dataList.get(position).tvName
        itemViewBinding.tvPrice1.text = dataList.get(position).tvPrice
        itemViewBinding.tvPower1.text = dataList.get(position).tvPower
        itemViewBinding.tvEngine1.text = dataList.get(position).tvEngine
        itemViewBinding.ivPicture1.setImageResource(dataList.get(position).ivPicture)
        itemViewBinding.ivPicture1.setOnClickListener {
            Toast.makeText(itemViewBinding.root.context,"${itemViewBinding.tvName1.text.toString()}",Toast.LENGTH_SHORT).show()
        }
        itemViewBinding.ivPicture1.setOnLongClickListener {
            Toast.makeText(itemViewBinding.root.context,"${itemViewBinding.tvName1.text.toString()} 삭제완료",Toast.LENGTH_SHORT).show()
            dataList.removeAt(position)
            notifyDataSetChanged()
            true
        }
    }


    class CustomViewHolder(val itemViewBinding: ItemViewBinding):RecyclerView.ViewHolder(itemViewBinding.root)

}