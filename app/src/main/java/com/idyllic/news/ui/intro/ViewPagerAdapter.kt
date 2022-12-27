package com.idyllic.news.ui.intro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idyllic.news.R
import com.idyllic.news.databinding.ViewPagerRowBinding

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    private val items = listOf(
        PagerItem(
            R.drawable.countries, "Select your country ", "" +
                    "select your country and your language to get news of your country with your language"
        ),
        PagerItem(
            R.drawable.favorite_img, "Save your favorite news",
            "you can save your favorite news to read them any time you want without Internet Connection"
        ),
        PagerItem(
            R.drawable.setting_image, "Change your country",
                    "you can change country and language to read news for this country "
        )
    )

    inner class PagerViewHolder(private val binding: ViewPagerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(item: PagerItem) {
            binding.title.text = item.title
            binding.description.text = item.description
            binding.image.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val binding =
            ViewPagerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.setData(items[position])
    }

    override fun getItemCount(): Int = items.size
}