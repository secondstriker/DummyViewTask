package com.codewithmohsen.dummyviewtask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.codewithmohsen.dummyviewtask.AppCoroutineDispatchers
import com.codewithmohsen.dummyviewtask.R
import com.codewithmohsen.dummyviewtask.databinding.ItemMoviesBinding
import com.codewithmohsen.dummyviewtask.model.Movie

/**
 * A RecyclerView adapter for [Item List] class.
 */
class MovieItemAdapter(
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val itemClickCallback: ((Movie) -> Unit)?
) : DataBoundListAdapter<Movie, ItemMoviesBinding>(
    appCoroutineDispatchers = appCoroutineDispatchers,
    diffCallback = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.title == newItem.title &&
                    oldItem.yearPublished == newItem.yearPublished &&
                    oldItem.description == newItem.description &&
                    oldItem.posterId == newItem.posterId
        }
    }
) {

    override fun createBinding(parent: ViewGroup): ItemMoviesBinding {

        val binding = DataBindingUtil.inflate<ItemMoviesBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movies,
            parent,
            false
        )
        binding.root.setOnClickListener { _ ->
            binding.item.let {
                if (it != null) itemClickCallback?.invoke(it)
            }
        }

        return binding
    }

    override fun bind(binding: ItemMoviesBinding, item: Movie) {
        binding.item = item
    }
}
